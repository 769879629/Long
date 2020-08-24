package com.sy.controller;

import com.sy.model.Dd;
import com.sy.service.DdService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dd")
public class DdController {

    @Autowired
    private DdService service;
    @RequiresPermissions("/dd/findlist.do")
    @RequestMapping("/findlist.do")
    public List<Dd> findlist( )throws Exception{


        return service.findlist();
    }

}
