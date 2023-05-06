package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.RepairData;
import com.osmium.schoolconnect.backend.service.IRepairDataService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * @Date 2023/3/10
 * @Description
 */
@RestController
@RequestMapping("/repair")
@Tag(name = "报修区域")
public class RepairDataController {
    private final IRepairDataService iRepairDataService;

    public RepairDataController(IRepairDataService iRepairDataService) {
        this.iRepairDataService = iRepairDataService;
    }


    @GetMapping("/my")
    public List<RepairData> getMyRepairData(@RequestParam (required=false) String status, Authentication authentication)
    {
        if (status.equals("undefined"))
            return iRepairDataService.listRepairData(String.valueOf(0),authentication.getName());
        return iRepairDataService.listRepairData(status,authentication.getName());
    }

    @GetMapping
    public List<RepairData> getOngoingRepairData(@RequestParam (required=false) String status)
    {
        if (status == null)
            return iRepairDataService.list();
        return iRepairDataService.listRepairData(status);
    }
    @DeleteMapping
    public Boolean invalidateOngoingRepairData(@RequestBody RepairData r) {
        return iRepairDataService.removeById(r);
    }
    @PostMapping
    public Boolean addRepairData(@RequestBody List<RepairData> r )
    {
        return iRepairDataService.saveBatch(r);
    }

    @PutMapping
    public Boolean setRepairStatus(@RequestBody List<RepairData> r)
    {
        return iRepairDataService.updateBatchById(r);
    }
}
