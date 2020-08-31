package com.sy.controller;

import com.github.pagehelper.PageInfo;
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
    public BaseResult findAll(int page, int limit)throws Exception{
        BaseResult baseResult = new BaseResult();
        PageInfo pageInfo = service.selectAll(page, limit);
        if (pageInfo!=null){
            baseResult.setData(pageInfo);
            baseResult.setMsg("查询成功");
            baseResult.setCode(BaseResult.CODE_SUCCESS);
            baseResult.setLimit(limit);
            baseResult.setPage(page);
            baseResult.setCount((int) pageInfo.getTotal());
        }else {
            baseResult.setMsg("查询失败");
            baseResult.setCode(BaseResult.CODE_FAILED);
        }
        return baseResult;
    }

    @RequiresPermissions("/aff/findOne.do")
    @RequestMapping("/findOne.do")
    public Affiche findOne(Integer id)throws Exception{

        return service.selectOne(id);
    }

    @RequiresPermissions("/aff/addOne.do")
    @RequestMapping("/addOne.do")
    public BaseResult addOne(Affiche affiche)throws Exception{

        BaseResult baseResult = new BaseResult();
        Integer insertone = service.insertone(affiche);
        if (insertone>0) {
            baseResult.setCode(BaseResult.CODE_SUCCESS);
            baseResult.setMsg("添加成功");
        }else {
            baseResult.setCode(BaseResult.CODE_FAILED);
            baseResult.setMsg("添加失败");
        }
        return baseResult;
    }

    @RequiresPermissions("/aff/remove.do")
    @RequestMapping("/remove.do")
    public BaseResult remove(Integer id)throws Exception{
        BaseResult baseResult = new BaseResult();
        Integer i = service.deleteById(id);
        if (i>0) {
            baseResult.setCode(BaseResult.CODE_SUCCESS);
            baseResult.setMsg("删除成功");
        }else {
            baseResult.setCode(BaseResult.CODE_FAILED);
            baseResult.setMsg("删除失败");
        }
        return baseResult;
    }

}
