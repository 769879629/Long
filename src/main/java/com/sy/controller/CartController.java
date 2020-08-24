package com.sy.controller;

import com.sy.model.Affiche;
import com.sy.model.Cart;
import com.sy.service.CartService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService service;

    @RequiresPermissions("/cart/findlist.do")
    @RequestMapping("/findlist.do")
    public List<Cart> findlist(String createBy)throws Exception{

        return service.findlist(createBy);
    }


    @RequiresPermissions("/cart/addone.do")
    @RequestMapping("/addone.do")
    public Integer insertone(Cart cart)throws Exception{

        return service.insertone(cart);
    }


}
