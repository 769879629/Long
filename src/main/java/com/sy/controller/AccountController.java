package com.sy.controller;

import com.sy.model.Account;
import com.sy.service.AccountService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/acc")
public class AccountController {

    @Autowired
    private AccountService service;

    @RequiresPermissions("/acc/findlist.do")
    @RequestMapping("/findlist.do")
    public List<Account> findlist( )throws Exception{


        return service.findlist();
    }


    @RequiresPermissions("/acc/findlist1.do")
    @RequestMapping("/findlist1.do")
    public List<Account> findlist1( )throws Exception{


        return service.findlist1();
    }


    @RequiresPermissions("/acc/insertone.do")
    @RequestMapping("/insertone.do")
    public Integer insertone(Account account) throws Exception {
        return service.insertone(account);
    }

    @RequiresPermissions("/acc/insertdout.do")
    @RequestMapping("/insertdout.do")
    public Integer insertdout(Account account) throws Exception {
        return service.insertdout(account);
    }

    @RequiresPermissions("/acc/findbalance.do")
    @RequestMapping("/findbalance.do")
    public Account findbalance() throws Exception {
        return service.findbalance();
    }
}
