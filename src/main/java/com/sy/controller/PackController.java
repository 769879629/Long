package com.sy.controller;

import com.sy.model.Pack;
import com.sy.model.User;
import com.sy.service.PackService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pack")
public class PackController {

    @Autowired
    private PackService service;


    @RequiresPermissions("/pack/findlist.do")
    @RequestMapping("/findlist.do")
    public List<Pack> findlist( )throws Exception{


        return service.findlist();
    }


    @RequiresPermissions("/pack/goodsPackName.do")
    @RequestMapping("/goodsPackName.do")
    public List<Pack> findoodsPackName(String goodsPackName)throws Exception{


        return service.findgoodsPackName(goodsPackName);
    }

    @RequiresPermissions("/pack/addone.do")
    @RequestMapping("/addone.do")
    public Integer addone(Pack pack)throws Exception{
//        SimpleDateFormat dmDate = new SimpleDateFormat("HHmmss"); // 获取当前时间
//        Date date = new Date();
//        String dateran = dmDate.format(date);
//
//        pack.setGoodsPackCode(dateran);
        return service.addone(pack);
    }
}
