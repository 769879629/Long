package com.sy.controller;

import com.sy.model.Menu;
import com.sy.model.User;
import com.sy.model.base.BaseResult;

import com.sy.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService service;

    //需要管理员权限
    @RequiresPermissions("/menu/find.do")
    @RequestMapping("/find.do")
    public BaseResult findMenus(Integer roleId) throws Exception{
        List<Menu> list = service.findByRoleId(roleId);
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(BaseResult.CODE_SUCCESS);
        baseResult.setMsg(BaseResult.MSG_SUCCESS);
        baseResult.setData(list);
        return baseResult;
    }

    //更新角色对应权限
    @RequiresPermissions("/menu/modify.do")
    @RequestMapping("/modify.do")
    public BaseResult modifyMenus(Integer roleId, Integer[] funcId, HttpSession session) throws Exception{
//        String username = SecurityUtils.getSubject().getPrincipal().toString();
        User username = (User) session.getAttribute("sessionUser");
        Integer integer = service.modifyFuncByRole(roleId, funcId,username.getUsername());
        BaseResult baseResult = new BaseResult();
        if(integer>0){
            baseResult.setCode(BaseResult.CODE_SUCCESS);
            baseResult.setMsg(BaseResult.MSG_SUCCESS);
        }else{
            baseResult.setCode(BaseResult.CODE_FAILED);
            baseResult.setMsg(BaseResult.MSG_FAILED);
        }
        return baseResult;
    }
}
