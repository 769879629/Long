package com.sy.controller;

import com.sy.model.Affiche;
import com.sy.model.Func;
import com.sy.model.base.BaseResult;
import com.sy.service.AfficheService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aff")
public class AfficheController {
    @Autowired
    private AfficheService service;

    @RequiresPermissions("/aff/findFive.do")
    @RequestMapping("/findFive.do")
    public List<Affiche> findFive()throws Exception{

        return service.selectFive();
    }

    @RequiresPermissions("/aff/findAll.do")
    @RequestMapping("/findAll.do")
    public List<Affiche> findAll()throws Exception{

        return service.selectAll();
    }

    @RequiresPermissions("/aff/findOne.do")
    @RequestMapping("/findOne.do")
    public Affiche findOne(Integer id)throws Exception{

        return service.selectOne(id);
    }

    @RequiresPermissions("/aff/addOne.do")
    @RequestMapping("/addOne.do")
    public Integer addOne(Affiche affiche)throws Exception{

        return service.insertone(affiche);
    }

    @RequiresPermissions("/aff/remove.do")
    @RequestMapping("/remove.do")
    public Integer remove(Integer id)throws Exception{

        return service.deleteById(id);
    }

}
