package com.sy.service;

import com.github.pagehelper.PageInfo;
import com.sy.model.Message;

import java.util.List;

public interface MessageService {

    PageInfo findlist(int pageNum, int pageSize) throws Exception;

    Integer insertone(Message message)throws Exception;

    Message findone(Integer id) throws Exception;

    Integer updateId(Integer id)throws Exception;

    Integer deleteById(Integer id)throws Exception;
}
