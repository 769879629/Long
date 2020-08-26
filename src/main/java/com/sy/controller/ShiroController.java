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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * shiro认证
 */
@RestController
public class ShiroController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroController.class);

    @Autowired
    private UserService service;

    @RequestMapping("/login.do")
    public BaseResult login(User user, String captcha, HttpSession session) {

        BaseResult baseResult = new BaseResult();
        //1.验证码比较
        String text = (String)session.getAttribute("captcha");
        System.out.println("captcha:"+captcha);
        System.out.println(text);
        if(!text.toLowerCase().equals(captcha)){
            baseResult.setCode(BaseResult.CODE_FAILED);
            baseResult.setMsg("验证码不正确");
            return baseResult;
        }

        System.out.println("login.do");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());

        try {
            subject.login(token);
            //用户放入session
            User findUser = service.findByUsername((String) subject.getPrincipal());
            session.setAttribute("sessionUser", findUser);
            baseResult.setCode(BaseResult.CODE_SUCCESS);
            baseResult.setMsg("登录成功");
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error(e.getMessage(), e);
            baseResult.setCode(BaseResult.CODE_FAILED);
            baseResult.setMsg("用户名或密码错误");
        }
        return baseResult;
    }

    @RequestMapping("/session.do")
    public BaseResult findSessionUser(HttpSession session){
        BaseResult baseResult = new BaseResult();
        User sessionUser = (User)session.getAttribute("sessionUser");
        if(sessionUser==null){
            baseResult.setMsg("用户未登录，请登录！");
            baseResult.setCode(BaseResult.CODE_FAILED);
        }else{
            baseResult.setMsg(BaseResult.MSG_SUCCESS);
            baseResult.setCode(BaseResult.CODE_SUCCESS);
            baseResult.setData(sessionUser);
        }
        return baseResult;
    }

    @RequestMapping("/logout.do")
    public BaseResult logout(HttpSession session){
        BaseResult baseResult = new BaseResult();
        session.removeAttribute("sessionUser");
        User sessionUser = (User)session.getAttribute("sessionUser");
        if(sessionUser==null){
            baseResult.setMsg("退出成功！");
            baseResult.setCode(BaseResult.CODE_SUCCESS);
        }else{
            baseResult.setMsg(BaseResult.MSG_FAILED);
            baseResult.setCode(BaseResult.CODE_FAILED);
        }
        return baseResult;
    }

}
