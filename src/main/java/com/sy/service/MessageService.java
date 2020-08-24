package com.sy.service;

import com.sy.model.Message;

import java.util.List;

public interface MessageService {

    List<Message> findlist( ) throws Exception;

    Integer insertone(Message message)throws Exception;

    Message findone(Integer id) throws Exception;

    Integer updateId(Integer id)throws Exception;

}
