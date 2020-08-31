package com.sy.controller;

import com.github.pagehelper.PageInfo;
import com.sy.model.Account;
import com.sy.model.Goods;
import com.sy.model.OrderInfo;
import com.sy.model.base.BaseResult;
import com.sy.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/io")
public class OrderInfoController {
    @Autowired
    private OrderInfoService service;

    @Autowired
    private CartService service1;

    @Autowired
    private AccountService accountService;
    @Autowired
    private UserService userService;
    @Autowired
    private GoodsService goodsService;

    @RequiresPermissions("/io/add.do")
    @RequestMapping("/add.do")
    public BaseResult insertone(OrderInfo orderInfo) throws Exception {
        BaseResult baseResult = new BaseResult();
        //得到账户余额
        Account findbalance = accountService.findbalance(orderInfo.getUserId());
        Double ye = findbalance.getMoneyIn() - findbalance.getMoneyOut();
        //商品价格
        Double orderPrice = orderInfo.getOrderPrice();
        //价格小于余额才可以购买
        if (orderPrice < ye) {
                OrderInfo o = new OrderInfo();
                o.setCreateBy(orderInfo.getCreateBy());
                o.setOrderPrice(orderInfo.getOrderPrice());
                Date currentTime = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = formatter.format(currentTime);
                o.setOrderCode(dateString);
                o.setUserId(orderInfo.getUserId());
                o.setStatus(1);
                //加入订单表
                Integer i = service.insertone(o);
                if (i > 0) {
                    Account account = new Account();
                    account.setAccountId(orderInfo.getUserId());
                    account.setMoneyOut(orderInfo.getOrderPrice());
                    String bankAccount = userService.findone(orderInfo.getUserId()).getBankAccount();
                    account.setOtherAccountId(bankAccount);
                    //加入账户表消费
                    accountService.insertdout1(account);
                    baseResult.setCode(BaseResult.CODE_SUCCESS);
                    baseResult.setMsg("购买成功！");
                } else {
                    baseResult.setCode(BaseResult.CODE_FAILED);
                    baseResult.setMsg("购买失败！");
                }

        } else {
            baseResult.setCode(BaseResult.CODE_FAILED);
            baseResult.setMsg("账户余额不足！");
        }
        return baseResult;
    }

    @RequiresPermissions("/io/findAll.do")
    @RequestMapping("/findAll.do")
    public BaseResult findAll(int page, int limit, Integer userId) throws Exception {
        PageInfo findAll = service.findlogin(page, limit, userId);
        BaseResult baseResult = new BaseResult();
        baseResult.setMsg("分页查询成功！");
        baseResult.setCode(BaseResult.CODE_SUCCESS);
        baseResult.setData(findAll);
        baseResult.setPage(page);
        baseResult.setLimit(limit);
        baseResult.setCount((int) findAll.getTotal());
        return baseResult;
    }
    @RequiresPermissions("/io/findAll1.do")
    @RequestMapping("/findAll1.do")
    public BaseResult findAll1(int page, int limit, Integer userId) throws Exception {
        PageInfo findAll = service.findlogin1(page, limit, userId);
        BaseResult baseResult = new BaseResult();
        baseResult.setMsg("分页查询成功！");
        baseResult.setCode(BaseResult.CODE_SUCCESS);
        baseResult.setData(findAll);
        baseResult.setPage(page);
        baseResult.setLimit(limit);
        baseResult.setCount((int) findAll.getTotal());
        return baseResult;
    }
}
