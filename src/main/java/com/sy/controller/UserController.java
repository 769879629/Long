package com.sy.controller;


import com.sy.model.User;
import com.sy.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

   @Autowired
    private UserService service;


    @RequiresPermissions("/user/findOne.do")
    @RequestMapping("/findOne.do")
    public User findOne(Integer id)throws Exception{


        return service.findone(id);
    }

    @RequiresPermissions("/user/modify.do")
    @RequestMapping("/modify.do")
    public Integer modify(User user)throws Exception{


        return service.updateId(user);
    }

    @RequiresPermissions("/user/modifypwd.do")
    @RequestMapping("/modifypwd.do")
    public Integer modifypwd(User user)throws Exception{


        return service.updatepassword(user);
    }


    @RequiresPermissions("/user/findlist.do")
    @RequestMapping("/findlist.do")
    public List<User> findlist( )throws Exception{


        return service.findlist();
    }

    @RequiresPermissions("/user/add.do")
    @RequestMapping("/add.do")
    public Integer add(User user)throws Exception{


        return service.insertone(user);
    }


    @RequiresPermissions("/user/modifyisStart.do")
    @RequestMapping("/modifyisStart.do")
    public Integer modifyisStart(Integer id)throws Exception{



        return service.updateisStart(id);
    }

    @RequiresPermissions("/user/addone.do")
    @RequestMapping("/addone.do")
    public Integer addone(User user)throws Exception{



        return service.addone(user);
    }

    @RequiresPermissions("/user/findlogin.do")
    @RequestMapping("/findlogin.do")
    public List<User> findlogin( )throws Exception{


        return service.findlogin();
    }

    @RequiresPermissions("/user/findoffical.do")
    @RequestMapping("/findoffical.do")
    public List<User> findoffical( )throws Exception{


        return service.findoffical();
    }

    @RequiresPermissions("/user/remove.do")
    @RequestMapping("/remove.do")
    public Integer remove(Integer id)throws Exception{


        return service.deleteone(id);
    }

    @RequiresPermissions("/user/findusername.do")
    @RequestMapping("/findusername.do")
    public List<User> findusername(String username)throws Exception{



        return service.findusername(username);
    }

    @RequiresPermissions("/user/modifyisStart1.do")
    @RequestMapping("/modifyisStart1.do")
    public Integer modifyisStart1(Integer id)throws Exception{



        return service.updateisStart1(id);
    }

    @RequiresPermissions("/user/modify1.do")
    @RequestMapping("/modify1.do")
    public Integer modify1(User user)throws Exception{


        return service.update1(user);
    }

    @RequiresPermissions("/user/modifypwd1.do")
    @RequestMapping("/modifypwd1.do")
    public Integer modifypwd1(Integer id)throws Exception{


        return service.updatepassword1(id);
    }

    @RequiresPermissions("/user/updatevip.do")
    @RequestMapping("/updatevip.do")
    public Integer updatevip(User user)throws Exception{


        return service.updatevip(user);
    }
}
