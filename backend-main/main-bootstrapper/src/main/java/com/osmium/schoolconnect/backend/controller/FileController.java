package com.osmium.schoolconnect.backend.controller;


import com.ruoyi.common.utils.uuid.UUID;
import com.osmium.schoolconnect.backend.entity.CampaignInfoPics;
import com.osmium.schoolconnect.backend.service.ICampaignInfoPicService;
import com.osmium.schoolconnect.backend.utils.annotations.AccessIsolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @Author
 * @Date 2023/4/14
 * @Description
 */
@RestController
public class FileController {
    @Value("${file.upload.path}")
    private String path;

    private final ICampaignInfoPicService iCampaignInfoPicService;

    public FileController(@Autowired ICampaignInfoPicService iCampaignInfoPicService) {
        this.iCampaignInfoPicService = iCampaignInfoPicService;
    }


    @AccessIsolation
    @PostMapping("/upload")
    public String create(@RequestParam String userId,String campaignId,@RequestPart MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String filePath = path + fileName;
        File dest = new File(filePath);
        Files.copy(file.getInputStream(), dest.toPath());
        if(!iCampaignInfoPicService.save(new CampaignInfoPics( UUID.randomUUID().toString().replace("-", "").substring(0,12), campaignId, file.getOriginalFilename())))
        {
            return "failed";
        }
     return file.getOriginalFilename();


    }
}
