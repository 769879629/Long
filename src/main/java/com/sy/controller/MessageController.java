package com.sy.controller;

import com.github.pagehelper.PageInfo;
import com.sy.model.Dd;
import com.sy.model.Message;
import com.sy.model.base.BaseResult;
import com.sy.service.DdService;
import com.sy.service.MessageService;
import com.sy.service.ReplyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mess")
public class MessageController {

    @Autowired
    private MessageService service;
    @Autowired
    private ReplyService service1;

    @RequiresPermissions("/mess/findlist.do")
    @RequestMapping("/findlist.do")
    public BaseResult findlist(int page,int limit)throws Exception{
        BaseResult baseResult =new BaseResult();

        PageInfo findlist = service.findlist(page, limit);

        if(findlist!=null){
            baseResult.setCode(BaseResult.CODE_SUCCESS);
            baseResult.setMsg("回复查询成功");
            baseResult.setData(findlist);
            baseResult.setPage(page);
            baseResult.setLimit(limit);
            baseResult.setCount((int) findlist.getTotal());
        }else {
            baseResult.setCode(BaseResult.CODE_FAILED);
            baseResult.setMsg("查询失败");
        }
        return baseResult;
    }

    @RequiresPermissions("/mess/add.do")
    @RequestMapping("/add.do")
    public BaseResult add(Message message)throws Exception{
        BaseResult baseResult =new BaseResult();

        Integer insertone = service.insertone(message);

        if (insertone>0){
            baseResult.setCode(BaseResult.CODE_SUCCESS);
            baseResult.setMsg("留言成功");
        }else {
            baseResult.setCode(BaseResult.CODE_FAILED);
            baseResult.setMsg("留言失败");
        }
        return baseResult;
    }

    @RequiresPermissions("/mess/findone.do")
    @RequestMapping("/findone.do")
    public Message findone(Integer id)throws Exception{


        return service.findone(id);
    }

    @RequiresPermissions("/mess/modify.do")
    @RequestMapping("/modify.do")
    public Integer modify(Integer id)throws Exception{


        return service.updateId(id);
    }
    @RequiresPermissions("/mess/delete.do")
    @RequestMapping("/delete.do")
    public BaseResult delete(Integer id)throws Exception{
        BaseResult baseResult =new BaseResult();

        Integer id1 = service.deleteById(id);

        Integer id2 = service1.deleteById(id);

        if (id1>0||id2>0){
            baseResult.setCode(BaseResult.CODE_SUCCESS);
            baseResult.setMsg("删除成功");
        }else {
            baseResult.setCode(BaseResult.CODE_FAILED);
            baseResult.setMsg("删除失败");
        }


        return baseResult;
    }
}
