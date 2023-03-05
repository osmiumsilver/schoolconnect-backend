package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.MessageBoard;
import com.osmium.schoolconnect.backend.service.IMessageBoardService;
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


    @GetMapping
    public List<MessageBoard> getMessages(){
        return iMessageBoardService.list();
    }

    @PostMapping
    public Boolean addMessage(@RequestBody List<MessageBoard> m) {
        return iMessageBoardService.saveBatch(m);
    }

    @PutMapping
    public Boolean modifyMessage(@RequestBody List<MessageBoard> MessageBoards) {
        return iMessageBoardService.updateBatchById(MessageBoards);
    }

    @DeleteMapping
    public Boolean deleteMessage(@RequestBody List<MessageBoard> m) {
        return iMessageBoardService.removeBatchByIds(m);
    }
}
