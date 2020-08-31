package com.sy.controller;

import com.github.pagehelper.PageInfo;
import com.sy.model.Goods;
import com.sy.model.base.BaseResult;
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
    public BaseResult findlist(int page, int limit)throws Exception{
        PageInfo findlist = service.findlist(page, limit);
        BaseResult baseResult =new BaseResult();
        baseResult.setMsg("分页查询成功！");
        baseResult.setCode(BaseResult.CODE_SUCCESS);
        baseResult.setData(findlist);
        baseResult.setPage(page);
        baseResult.setLimit(limit);
        baseResult.setCount((int) findlist.getTotal());
        return baseResult;
    }

    @RequiresPermissions("/goods/add.do")
    @RequestMapping("/add.do")
    public Integer findlist(Goods goods)throws Exception{


        return service.insertone(goods);
    }

    @RequiresPermissions("/goods/modifynum.do")
    @RequestMapping("/modifynum.do")
    public BaseResult modifynum(Integer num,Integer id)throws Exception{
        BaseResult baseResult =new BaseResult();
        Integer updatenum = service.updatenum(num, id);
        if (updatenum>0){
            baseResult.setCode(BaseResult.CODE_SUCCESS);
            baseResult.setMsg("修改成功！");
        }else {
            baseResult.setCode(BaseResult.CODE_FAILED);
            baseResult.setMsg("修改失败！");
        }
        return baseResult;
    }

    @RequiresPermissions("/goods/findgoodsName.do")
    @RequestMapping("/findgoodsName.do")
    public BaseResult findgoodsName(int page, int limit,String goodsName)throws Exception{
        PageInfo findlist = service.findgoodsName(page, limit, goodsName);
        BaseResult baseResult =new BaseResult();
        baseResult.setMsg("分页查询成功！");
        baseResult.setCode(BaseResult.CODE_SUCCESS);
        baseResult.setData(findlist);
        baseResult.setPage(page);
        baseResult.setLimit(limit);
        baseResult.setCount((int) findlist.getTotal());
        return baseResult;
    }

    @RequiresPermissions("/goods/goodsup.do")
    @RequestMapping("/goodsup.do")
    public BaseResult goodsup(Integer goodsId, Integer num)throws Exception{
        Goods byID = service.findByID(goodsId);
        BaseResult baseResult =new BaseResult();
        if (byID.getNum()>=num){
            baseResult.setMsg("库存足够！");
            baseResult.setCode(BaseResult.CODE_SUCCESS);
        }else {
            baseResult.setMsg("库存不够！");
            baseResult.setCode(BaseResult.CODE_SUCCESS);
        }

        return baseResult;
    }
}
