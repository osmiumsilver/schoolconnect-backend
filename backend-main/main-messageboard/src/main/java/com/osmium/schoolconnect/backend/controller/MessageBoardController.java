package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.MessageBoard;
import com.osmium.schoolconnect.backend.misc.RequestException;
import com.osmium.schoolconnect.backend.misc.ResultCode;
import com.osmium.schoolconnect.backend.service.IMessageBoardService;
import com.osmium.schoolconnect.backend.utils.SecurityUtils;
import com.osmium.schoolconnect.backend.utils.annotations.AdministrativeAccess;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * @Date 2023/3/1
 * @Description
 */
@RestController
@RequestMapping("/messageboard")
public class MessageBoardController {
    private final IMessageBoardService iMessageBoardService;

    public MessageBoardController(IMessageBoardService iMessageBoardService) {
        this.iMessageBoardService = iMessageBoardService;
    }

@Operation(summary = "查询所有公告")
    @GetMapping
    public List<MessageBoard> getMessages() {
        return iMessageBoardService.list();
    }


    @Operation(summary = "查询我发出的公告")
    @GetMapping("/my")
    public List<MessageBoard> getMessagesSendByMe(Authentication authentication) {
        return iMessageBoardService.listMessagesSendByMe(authentication.getName());
    }
    @Operation(summary = "管理员添加公告")
    @AdministrativeAccess
    @PostMapping
    public Boolean addMessage(@RequestBody MessageBoard message) {
        if (!(message.getSender().equals(SecurityUtils.getUserId())))
            throw new RequestException(ResultCode.AUTH_NO_PERMISSION);

        return iMessageBoardService.save(message);
    }

    @Operation(summary = "管理员修改公告")
    @AdministrativeAccess
    @PutMapping
    public Boolean modifyMessage(@RequestBody MessageBoard m) {
        if (!(m.getSender().equals(SecurityUtils.getUserId())))
            throw new RequestException(ResultCode.AUTH_NO_PERMISSION);

        return iMessageBoardService.updateById(m);
    }
    @Operation(summary = "管理员删除公告")
    @AdministrativeAccess
    @DeleteMapping
    public Boolean deleteMessage(@RequestBody MessageBoard m) {
        if (!(m.getSender().equals(SecurityUtils.getUserId())))
            throw new RequestException(ResultCode.AUTH_NO_PERMISSION);

        return iMessageBoardService.removeById(m);
    }
}
