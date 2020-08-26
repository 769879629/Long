package com.sy.controller;

import com.github.pagehelper.PageInfo;
import com.sy.model.Account;
import com.sy.model.base.BaseResult;
import com.sy.service.AccountService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/acc")
public class AccountController {

    @Autowired
    private AccountService service;

    @RequiresPermissions("/acc/findBymoneyIn.do")
    @RequestMapping("/findBymoneyIn.do")
    public BaseResult findBymoneyIn(int page,int limit,Integer id)throws Exception{
        BaseResult baseResult= new BaseResult();
        PageInfo bymoneyIn = service.findBymoneyIn(page, limit,id);

        if (bymoneyIn!=null){
            baseResult.setMsg("查询成功");
            baseResult.setCode(BaseResult.CODE_SUCCESS);
            baseResult.setData(bymoneyIn);
            baseResult.setPage(page);
            baseResult.setLimit(limit);
            baseResult.setCount((int) bymoneyIn.getTotal());
        }else {
            baseResult.setMsg("查询失败");
            baseResult.setCode(BaseResult.CODE_FAILED);
        }
        return baseResult;
    }


    @RequiresPermissions("/acc/findBymoneyOut.do")
    @RequestMapping("/findBymoneyOut.do")
    public BaseResult findBymoneyOut(int page,int limit)throws Exception{
        BaseResult baseResult= new BaseResult();
        PageInfo bymoneyOut = service.findBymoneyOut(page, limit);

        if (bymoneyOut!=null){
            baseResult.setMsg("查询成功");
            baseResult.setCode(BaseResult.CODE_SUCCESS);
            baseResult.setData(bymoneyOut);
            baseResult.setPage(page);
            baseResult.setLimit(limit);
            baseResult.setCount((int) bymoneyOut.getTotal());
        }else {
            baseResult.setMsg("查询失败");
            baseResult.setCode(BaseResult.CODE_FAILED);
        }
        return baseResult;
    }


    @RequiresPermissions("/acc/insertone.do")
    @RequestMapping("/insertone.do")
    public BaseResult insertone(Account account) throws Exception {
        BaseResult baseResult = new BaseResult();
        Integer i = service.insertone(account);
        if (i>0){
            baseResult.setCode(BaseResult.CODE_SUCCESS);
            baseResult.setMsg("充值成功！");
        }else {
            baseResult.setCode(BaseResult.CODE_FAILED);
            baseResult.setMsg("充值失败！");
        }
        return baseResult;
    }

    @RequiresPermissions("/acc/insertdout.do")
    @RequestMapping("/insertdout.do")
    public Integer insertdout(Account account) throws Exception {
        return service.insertdout(account);
    }

    @RequiresPermissions("/acc/findbalance.do")
    @RequestMapping("/findbalance.do")
    public Account findbalance() throws Exception {
        return service.findbalance();
    }
}
