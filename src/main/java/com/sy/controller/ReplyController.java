package com.sy.controller;

import com.github.pagehelper.PageInfo;
import com.sy.model.Reply;
import com.sy.model.base.BaseResult;
import com.sy.service.MessageService;
import com.sy.service.ReplyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reply")
public class ReplyController {
    @Autowired
    private ReplyService service;

    @Autowired
    private MessageService service1;



    @RequiresPermissions("/reply/addone.do")
    @RequestMapping("/addone.do")
    public BaseResult addone(Reply reply) throws Exception {
        BaseResult baseResult = new BaseResult();
        Integer insert = service.insert(reply);
        Integer id = service1.updateId(reply.getMessageId());
        if (insert>0||id>0){
            baseResult.setCode(BaseResult.CODE_SUCCESS);
            baseResult.setMsg("回复成功");
        }else {
            baseResult.setCode(BaseResult.CODE_FAILED);
            baseResult.setMsg("回复失败");
        }
        return baseResult;
    }

    @RequiresPermissions("/reply/find.do")
    @RequestMapping("/find.do")
    public BaseResult find(int page,int limit,Integer messageId) throws Exception {
        BaseResult baseResult = new BaseResult();
        PageInfo pageInfo = service.find(page, limit, messageId);
        if (pageInfo!=null){
            baseResult.setCode(BaseResult.CODE_SUCCESS);
            baseResult.setMsg("已有回复");
            baseResult.setData(pageInfo);
            baseResult.setPage(page);
            baseResult.setLimit(limit);
            baseResult.setCount((int) pageInfo.getTotal());
        }else {
            baseResult.setCode(BaseResult.CODE_FAILED);
            baseResult.setMsg("没有回复");
        }
        return baseResult;
    }

    @RequiresPermissions("/reply/find1.do")
    @RequestMapping("/find1.do")
    public List<Reply> find1(int messageId) throws Exception {
        return service.find(messageId);
    }
}
