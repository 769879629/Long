package com.sy.controller;

import com.sy.model.Reply;
import com.sy.service.ReplyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reply")
public class ReplyController {
    @Autowired
    private ReplyService service;



    @RequiresPermissions("/reply/addone.do")
    @RequestMapping("/addone.do")
    public Integer addone(Reply reply) throws Exception {
        return service.insert(reply);
    }


}
