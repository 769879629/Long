package com.sy.controller;

import com.sy.model.Goods;
import com.sy.service.GoodsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService service;

    @RequiresPermissions("/goods/findlist.do")
    @RequestMapping("/findlist.do")
    public List<Goods> findlist( )throws Exception{


        return service.findlist();
    }

    @RequiresPermissions("/goods/add.do")
    @RequestMapping("/add.do")
    public Integer findlist(Goods goods)throws Exception{


        return service.insertone(goods);
    }

    @RequiresPermissions("/goods/modifynum.do")
    @RequestMapping("/modifynum.do")
    public Integer modifynum(Integer num,Integer id)throws Exception{

        return service.updatenum(num,id);
    }

    @RequiresPermissions("/goods/findgoodsName.do")
    @RequestMapping("/findgoodsName.do")
    public List<Goods> findgoodsName(String goodsName)throws Exception{


        return service.findgoodsName(goodsName);
    }


}
