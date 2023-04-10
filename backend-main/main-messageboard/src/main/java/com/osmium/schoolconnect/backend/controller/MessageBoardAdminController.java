package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.MessageBoard;
import com.osmium.schoolconnect.backend.service.IMessageBoardService;
import com.osmium.schoolconnect.backend.utils.annotations.SuperAccess;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * @Date 2023/3/1
 * @Description
 */
@RestController
@RequestMapping("/admin/messageboard")
@SuperAccess
@Tag(name = "公告板管理员")
public class MessageBoardAdminController {
    private final IMessageBoardService iMessageBoardService;

    public MessageBoardAdminController(IMessageBoardService iMessageBoardService) {
        this.iMessageBoardService = iMessageBoardService;
    }

    @Operation(summary = "查询公告")
    @GetMapping
    public List<MessageBoard> getMessages() {
        return iMessageBoardService.list();
    }

    @Operation(summary = "管理员添加公告")
    @PostMapping
    public Boolean addMessage(@RequestBody List<MessageBoard> m) {
        return iMessageBoardService.saveBatch(m);
    }

    @Operation(summary = "管理员修改公告")

    @PutMapping
    public Boolean modifyMessage(@RequestBody List<MessageBoard> MessageBoards) {
        return iMessageBoardService.updateBatchById(MessageBoards);
    }

    @Operation(summary = "管理员删除公告")

    @DeleteMapping
    public Boolean deleteMessage(@RequestBody List<MessageBoard> m) {
        return iMessageBoardService.removeBatchByIds(m);
    }
}
