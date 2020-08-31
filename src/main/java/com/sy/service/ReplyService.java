package com.sy.service;

import com.github.pagehelper.PageInfo;
import com.sy.model.Reply;

import java.util.List;

public interface ReplyService {

    Integer insert(Reply reply)throws Exception;

    List<Reply> find(int messageId)throws Exception;

    PageInfo find(int pageNum, int pageSize, int messageId)throws Exception;

    Integer deleteById(Integer messageId)throws Exception;
}
