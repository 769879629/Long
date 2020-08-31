package com.sy.controller;


import com.sy.model.Shopcart;
import com.sy.model.User;
import com.sy.service.ShopcartService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopcartController {

    @Autowired
    private ShopcartService service;

    @RequiresPermissions("/shop/findlist.do")
    @RequestMapping("/findlist.do")
    public List<Shopcart> findlist(Integer userId)throws Exception{


        return service.findlist(userId);
    }

//    @RequiresPermissions("/shop/add.do")
//    @RequestMapping("/add.do")
//    public Integer add(Shopcart shopcart,Integer id)throws Exception{
//
//
//        return service.insert(shopcart,id);
//    }

}
