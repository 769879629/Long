package com.sy.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.sy.exception.GlobalExceptionHandler;
import com.sy.model.User;
import com.sy.model.base.BaseResult;
import com.sy.model.base.PageResult;
import com.sy.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * shiro认证
 */
@RestController

public class ShiroController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroController.class);

    @Autowired
    private UserService service;



    @RequestMapping("/session.do")
    public BaseResult findSessionUser(HttpServletRequest request,HttpSession session) throws Exception{
        BaseResult baseResult = new BaseResult();
        User sessionUser1 = (User) session.getAttribute("sessionUser");
        if(sessionUser1==null){
            baseResult.setMsg("用户未登录，请登录！");
            baseResult.setCode(BaseResult.CODE_FAILED);
        }else{

            baseResult.setMsg(BaseResult.MSG_SUCCESS);
            baseResult.setCode(BaseResult.CODE_SUCCESS);
            baseResult.setData(sessionUser1);
        }
        return baseResult;
    }

}
