package com.sy.controller;

import com.sy.model.Affiche;
import com.sy.model.Information;
import com.sy.service.InformationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inf")
public class InformationController {

    @Autowired
    private InformationService service;


    @RequiresPermissions("/inf/findlist.do")
    @RequestMapping("/findlist.do")
    public List<Information> findlist( )throws Exception{


        return service.findlist();
    }


    @RequiresPermissions("/inf/findOne.do")
    @RequestMapping("/findOne.do")
    public Information findOne(Integer id)throws Exception{

        return service.selectOne(id);
    }

    @RequiresPermissions("/inf/addOne.do")
    @RequestMapping("/addOne.do")
    public Integer addOne(Information information)throws Exception{

        return service.insertone(information);
    }

    @RequiresPermissions("/inf/remove.do")
    @RequestMapping("/remove.do")
    public Integer remove(Integer id)throws Exception{

        return service.deleteById(id);
    }

}
