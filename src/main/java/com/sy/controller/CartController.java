package com.sy.controller;

import com.github.pagehelper.PageInfo;
import com.sy.model.Affiche;
import com.sy.model.Cart;
import com.sy.model.Goods;
import com.sy.model.base.BaseResult;
import com.sy.service.CartService;
import com.sy.service.GoodsService;
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
    @Autowired
    private GoodsService service1;

    @RequiresPermissions("/cart/findlist.do")
    @RequestMapping("/findlist.do")
    public BaseResult findlist(int page, int limit, String createBy) throws Exception {
        PageInfo officialbyRid = service.findlist(page, limit, createBy);
        BaseResult baseResult = new BaseResult();
        baseResult.setMsg("分页查询成功！");
        baseResult.setCode(BaseResult.CODE_SUCCESS);
        baseResult.setData(officialbyRid);
        baseResult.setPage(page);
        baseResult.setLimit(limit);
        baseResult.setCount((int) officialbyRid.getTotal());
        return baseResult;
    }


    @RequiresPermissions("/cart/addone.do")
    @RequestMapping("/addone.do")
    public BaseResult insertone(Cart cart) throws Exception {
        System.out.println("================" + cart);
        BaseResult baseResult = new BaseResult();

        Cart byGoodsId = service.findByGoodsId(cart.getGoodsId());
        if (byGoodsId == null) {
            Integer insertone = service.insertone(cart);
            if (insertone > 0) {
                baseResult.setMsg("添加购物车成功！");
                baseResult.setCode(BaseResult.CODE_SUCCESS);
            } else {
                baseResult.setMsg("添加购物车失败！");
                baseResult.setCode(BaseResult.CODE_FAILED);
            }
        } else {
            Integer integer = service.updateOne(cart);
            if (integer > 0) {
                baseResult.setMsg("添加购物车成功！");
                baseResult.setCode(BaseResult.CODE_SUCCESS);
            } else {
                baseResult.setMsg("添加购物车失败！");
                baseResult.setCode(BaseResult.CODE_FAILED);
            }
        }

        return baseResult;
    }

    @RequiresPermissions("/cart/deleteById.do")
    @RequestMapping("/deleteById.do")
    public BaseResult deleteById(Integer id) throws Exception {
        BaseResult baseResult = new BaseResult();
        Integer id1 = service.deleteById(id);
        if (id1 > 0) {
            baseResult.setMsg("删除成功！");
            baseResult.setCode(BaseResult.CODE_SUCCESS);
        } else {
            baseResult.setMsg("删除失败！");
            baseResult.setCode(BaseResult.CODE_FAILED);
        }
        return baseResult;
    }

    @RequiresPermissions("/cart/updatej.do")
    @RequestMapping("/updatej.do")
    public BaseResult updatej(Cart cart) throws Exception {
        BaseResult baseResult = new BaseResult();
        System.out.println("aaaaa"+cart);
        Integer id1 = service.updateOnej(cart);
        if (id1 > 0) {
            baseResult.setMsg("修改减少商品库存成功！");
            baseResult.setCode(BaseResult.CODE_SUCCESS);
        } else {
            baseResult.setMsg("修改减少商品库存失败！");
            baseResult.setCode(BaseResult.CODE_FAILED);
        }
        return baseResult;
    }
}
