package com.sy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.mapper.ReplyMapper;
import com.sy.model.Reply;
import com.sy.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyMapper mapper;

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer insert(Reply reply) throws Exception {
        return mapper.insert(reply);
    }

    @Override
    public List<Reply> find(int messageId) throws Exception {
        return mapper.find(messageId);
    }

    @Override
    public PageInfo find(int pageNum, int pageSize, int messageId) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<Reply> list = mapper.find(messageId);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer deleteById(Integer messageId) throws Exception {
        return mapper.deleteById(messageId);
    }
}

