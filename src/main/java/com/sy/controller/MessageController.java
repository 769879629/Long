package com.sy.controller;

import com.sy.model.Dd;
import com.sy.model.Message;
import com.sy.service.DdService;
import com.sy.service.MessageService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mess")
public class MessageController {

    @Autowired
    private MessageService service;

    @RequiresPermissions("/mess/findlist.do")
    @RequestMapping("/findlist.do")
    public List<Message> findlist( )throws Exception{


        return service.findlist();
    }

    @RequiresPermissions("/mess/add.do")
    @RequestMapping("/add.do")
    public Integer add(Message message)throws Exception{


        return service.insertone(message);
    }

    @RequiresPermissions("/mess/findone.do")
    @RequestMapping("/findone.do")
    public Message findone(Integer id)throws Exception{


        return service.findone(id);
    }

    @RequiresPermissions("/mess/modify.do")
    @RequestMapping("/modify.do")
    public Integer modify(Integer id)throws Exception{


        return service.updateId(id);
    }

}
