package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.MessageBoard;
import com.osmium.schoolconnect.backend.mapper.MessageBoardMapper;
import com.osmium.schoolconnect.backend.service.IMessageBoardService;
import org.springframework.stereotype.Service;

/**
 * @Author
 * @Date 2023/3/1
 * @Description
 */
@Service
public class MessageBoardImpl extends ServiceImpl<MessageBoardMapper, MessageBoard> implements IMessageBoardService {
}
