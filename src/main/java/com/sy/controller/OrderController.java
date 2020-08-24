package com.sy.controller;


import com.sy.model.Order;
import com.sy.model.User;
import com.sy.service.OrderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @RequiresPermissions("/order/findlist.do")
    @RequestMapping("/findlist.do")
    public List<Order> findlist( )throws Exception{


        return service.findlist();
    }

    @RequiresPermissions("/order/findcreateBy.do")
    @RequestMapping("/findcreateBy.do")
    public List<Order> findcreateBy(String createBy)throws Exception{


        return service.findcreateBy(createBy);
    }


    @RequiresPermissions("/order/findgoodsName.do")
    @RequestMapping("/findgoodsName.do")
    public List<Order> findgoodsName(String goodsName)throws Exception{


        return service.findgoodsName(goodsName);
    }
}
