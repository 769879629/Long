package com.sy.controller;

import com.sy.model.Account;
import com.sy.model.Uaccount;
import com.sy.service.UaccountService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ua")
public class UaccountController {

    @Autowired
    private UaccountService service;


    @RequiresPermissions("/ua/findlist.do")
    @RequestMapping("/findlist.do")
    public List<Uaccount> findlist() throws Exception {
        return service.findlist();
    }

}
