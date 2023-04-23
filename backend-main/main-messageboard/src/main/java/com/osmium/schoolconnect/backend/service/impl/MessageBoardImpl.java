package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.MessageBoard;
import com.osmium.schoolconnect.backend.mapper.MessageBoardMapper;
import com.osmium.schoolconnect.backend.service.IMessageBoardService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * @Author
 * @Date 2023/3/1
 * @Description
 */
@Service
@Validated
public class MessageBoardImpl extends ServiceImpl<MessageBoardMapper, MessageBoard> implements IMessageBoardService {
    @Override
    public List<MessageBoard> listMessagesSendByMe(String name) {
        QueryWrapper<MessageBoard> q = new QueryWrapper<>();
        q.eq("sender",name);
        return baseMapper.selectList(q);
    }
}
