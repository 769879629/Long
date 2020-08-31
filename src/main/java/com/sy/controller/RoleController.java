package com.sy.controller;

import com.github.pagehelper.PageInfo;
import com.sy.model.Role;
import com.sy.model.base.BaseResult;
import com.sy.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService service;
    @RequiresPermissions("/role/page.do")
    @RequestMapping("/page.do")
    public BaseResult showRoleList() throws Exception{
        PageInfo byPage = service.findByPage();
        List<Role>list = byPage.getList();
        BaseResult baseResult = new BaseResult();
        baseResult.setData(list);
        baseResult.setCode(BaseResult.CODE_SUCCESS);
        baseResult.setMsg(BaseResult.MSG_SUCCESS);
        return baseResult;
    }

    @RequiresPermissions("/role/modify.do")
    @RequestMapping("/modify.do")
    public Integer modify(Role role) throws Exception{
        return service.modify(role);

    }

    @RequiresPermissions("/role/findone.do")
    @RequestMapping("/findone.do")
    public Role modify(Integer id) throws Exception{
        return service.findById(id);

    }
    @RequiresPermissions("/role/add.do")
    @RequestMapping("/add.do")
    public BaseResult add(Role role) throws Exception{
        BaseResult baseResult = new BaseResult();
        Integer save = service.save(role);
        if (save>0){
            baseResult.setCode(BaseResult.CODE_SUCCESS);
            baseResult.setMsg("插入成功");
        }
else {
            baseResult.setCode(BaseResult.CODE_FAILED);
            baseResult.setMsg(BaseResult.MSG_FAILED);
        }

        return baseResult;

    }

    @RequiresPermissions("/role/del.do")
    @RequestMapping("/del.do")
    public BaseResult del(int id) throws Exception{
        BaseResult baseResult = new BaseResult();
        Integer save = service.removeById(id);
        if (save>0){
            baseResult.setCode(BaseResult.CODE_SUCCESS);
            baseResult.setMsg("删除成功");
        }
        else {
            baseResult.setCode(BaseResult.CODE_FAILED);
            baseResult.setMsg(BaseResult.MSG_FAILED);
        }

        return baseResult;

    }
}
