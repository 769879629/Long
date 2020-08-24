package com.sy.service.impl;

import com.sy.mapper.MessageMapper;
import com.sy.model.Message;
import com.sy.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper mapper;

    @Override
    public List<Message> findlist() throws Exception {
        return mapper.findlist();
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer insertone(Message message) throws Exception {
        return mapper.insertone(message);
    }

    @Override
    public Message findone(Integer id) throws Exception {
        return mapper.findone(id);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer updateId(Integer id) throws Exception {
        return mapper.updateId(id);
    }
}
