package com.sy.controller;


import com.github.pagehelper.PageInfo;
import com.sy.model.Account;
import com.sy.model.OrderInfo;
import com.sy.model.User;
import com.sy.model.base.BaseResult;
import com.sy.service.AccountService;
import com.sy.service.CartService;
import com.sy.service.OrderInfoService;
import com.sy.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroController.class);
    @Autowired
    private UserService service;

    @Autowired
    private AccountService accountService;

    @Autowired
    private OrderInfoService orderInfoService;

    @RequiresPermissions("/user/findOne.do")
    @RequestMapping("/findOne.do")
    public BaseResult findOne(Integer id) throws Exception {
        User findone = service.findone(id);
        BaseResult baseResult = new BaseResult();
        baseResult.setMsg("用户查询成功！");
        baseResult.setCode(BaseResult.CODE_SUCCESS);
        baseResult.setData(findone);
        return baseResult;
    }

    @RequiresPermissions("/user/modify.do")
    @RequestMapping("/modify.do")
    public BaseResult modify(User user) throws Exception {
        BaseResult baseResult = new BaseResult();
        Integer i = service.updateId(user);
        if (i > 0) {
            baseResult.setMsg("用户修改成功！");
            baseResult.setCode(BaseResult.CODE_SUCCESS);
        } else {
            baseResult.setMsg("用户修改失败，请重新操作！");
            baseResult.setCode(BaseResult.CODE_FAILED);
        }

        return baseResult;
    }

    @RequiresPermissions("/user/modifypwd.do")
    @RequestMapping("/modifypwd.do")
    public BaseResult modifypwd(User user) throws Exception {
        BaseResult baseResult = new BaseResult();
        Integer i = service.updatepassword(user);
        if (i > 0) {
            baseResult.setMsg("密码修改成功！");
            baseResult.setCode(BaseResult.CODE_SUCCESS);
        } else {
            baseResult.setMsg("密码修改失败，请重新操作！");
            baseResult.setCode(BaseResult.CODE_FAILED);
        }

        return baseResult;
    }


    @RequiresPermissions("/user/findlist.do")
    @RequestMapping("/findlist.do")
    public List<User> findlist() throws Exception {


        return service.findlist();
    }

    @RequiresPermissions("/user/add.do")
    @RequestMapping("/add.do")
    public Integer add(User user) throws Exception {


        return service.insertone(user);
    }


    @RequiresPermissions("/user/modifyisStart.do")
    @RequestMapping("/modifyisStart.do")
    public BaseResult modifyisStart(Integer id) throws Exception {
        BaseResult baseResult = new BaseResult();
        Integer i = service.updateisStart(id);

        if (i > 0) {
            baseResult.setMsg("锁定成功！");
            baseResult.setCode(BaseResult.CODE_SUCCESS);
        } else {
            baseResult.setMsg("锁定失败，请重新操作！");
            baseResult.setCode(BaseResult.CODE_FAILED);
        }

        return baseResult;
    }

    @RequiresPermissions("/user/addone.do")
    @RequestMapping("/addone.do")
    public BaseResult addone(User user) throws Exception {
        BaseResult baseResult = new BaseResult();
        String username = user.getUsername();
        User byUsername = service.findByUsername(username);
        if (byUsername == null) {
            service.addone(user);
            baseResult.setMsg("会员添加成功！");
            baseResult.setCode(BaseResult.CODE_SUCCESS);
        } else {
            baseResult.setMsg("会员昵称已存在，请重新输入！");
            baseResult.setCode(BaseResult.CODE_FAILED);
        }
        return baseResult;
    }

    @RequiresPermissions("/user/findlogin.do")
    @RequestMapping("/findlogin.do")
    public BaseResult findlogin(int page, int limit, Integer referId) throws Exception {
        PageInfo findlogin = service.findlogin(page, limit, referId);
        BaseResult baseResult = new BaseResult();
        baseResult.setMsg("分页查询成功！");
        baseResult.setCode(BaseResult.CODE_SUCCESS);
        baseResult.setData(findlogin);
        baseResult.setPage(page);
        baseResult.setLimit(limit);
        baseResult.setCount((int) findlogin.getTotal());
        LOGGER.info("分页查询成功！");
        return baseResult;
    }

    @RequiresPermissions("/user/findoffical.do")
    @RequestMapping("/findoffical.do")
    public BaseResult findoffical(int page, int limit, Integer referId) throws Exception {
        PageInfo findlogin = service.findoffical(page, limit, referId);
        BaseResult baseResult = new BaseResult();
        baseResult.setMsg("分页查询成功！");
        baseResult.setCode(BaseResult.CODE_SUCCESS);
        baseResult.setData(findlogin);
        baseResult.setPage(page);
        baseResult.setLimit(limit);
        baseResult.setCount((int) findlogin.getTotal());
        LOGGER.info("分页查询成功！");
        return baseResult;
    }

    @RequiresPermissions("/user/remove.do")
    @RequestMapping("/remove.do")
    public Integer remove(Integer id) throws Exception {


        return service.deleteone(id);
    }

    @RequiresPermissions("/user/findusername.do")
    @RequestMapping("/findusername.do")
    public BaseResult findusername(int page, int limit, String username) throws Exception {
        PageInfo findusername = service.findusername(page, limit, username);
        BaseResult baseResult = new BaseResult();
        baseResult.setMsg("分页查询成功！");
        baseResult.setCode(BaseResult.CODE_SUCCESS);
        baseResult.setData(findusername);
        baseResult.setPage(page);
        baseResult.setLimit(limit);
        baseResult.setCount((int) findusername.getTotal());
        LOGGER.info("分页查询成功！");
        return baseResult;
    }

    @RequiresPermissions("/user/findOfficialbyUn.do")
    @RequestMapping("/findOfficialbyUn.do")
    public BaseResult findOfficialbyUn(int page, int limit, String username) throws Exception {
        PageInfo findOfficialbyUn = service.findOfficialbyUn(page, limit, username);
        BaseResult baseResult = new BaseResult();
        baseResult.setMsg("分页查询成功！");
        baseResult.setCode(BaseResult.CODE_SUCCESS);
        baseResult.setData(findOfficialbyUn);
        baseResult.setPage(page);
        baseResult.setLimit(limit);
        baseResult.setCount((int) findOfficialbyUn.getTotal());
        LOGGER.info("分页查询成功！");
        return baseResult;
    }

    @RequiresPermissions("/user/modifyisStart1.do")
    @RequestMapping("/modifyisStart1.do")
    public BaseResult modifyisStart1(Integer id) throws Exception {
        BaseResult baseResult = new BaseResult();
        Integer i = service.updateisStart1(id);

        if (i > 0) {
            baseResult.setMsg("审核成功！");
            baseResult.setCode(BaseResult.CODE_SUCCESS);
        } else {
            baseResult.setMsg("审核失败，请重新操作！");
            baseResult.setCode(BaseResult.CODE_FAILED);
        }

        return baseResult;
    }

    @RequiresPermissions("/user/modify1.do")
    @RequestMapping("/modify1.do")
    public BaseResult modify1(User user) throws Exception {
        String username = user.getUsername();
        User byUsername = service.findByUsername(username);
        BaseResult baseResult = new BaseResult();
        Integer i = service.update1(user);
        if (i > 0) {
            baseResult.setMsg("用户修改成功！");
            baseResult.setCode(BaseResult.CODE_SUCCESS);
        } else {
            baseResult.setMsg("用户修改失败！");
            baseResult.setCode(BaseResult.CODE_FAILED);
        }

        return baseResult;
    }

    @RequiresPermissions("/user/modifypwd1.do")
    @RequestMapping("/modifypwd1.do")
    public BaseResult modifypwd1(Integer id) throws Exception {
        BaseResult baseResult = new BaseResult();
        Integer i = service.updatepassword1(id);

        if (i > 0) {
            baseResult.setMsg("密码重置成功！");
            baseResult.setCode(BaseResult.CODE_SUCCESS);
        } else {
            baseResult.setMsg("密码重置失败，请重新操作！");
            baseResult.setCode(BaseResult.CODE_FAILED);
        }

        return baseResult;
    }

    @RequiresPermissions("/user/updatevip.do")
    @RequestMapping("/updatevip.do")
    public BaseResult updatevip(User user, Double price, Integer id) throws Exception {
        BaseResult baseResult = new BaseResult();
        //得到账户余额
        Account findbalance = accountService.findbalance(user.getId());
        Double ye = findbalance.getMoneyIn() - findbalance.getMoneyOut();

        if (ye > price) {
            User findone = service.findone(user.getId());
            Integer roleId = findone.getRoleId();
            Double yprice = 0.0;
            if (roleId == 3) {
                yprice = 1999.0;
            }
            if (roleId == 4) {
                yprice = 2999.0;
            }
            Account account = new Account();
            User findone1 = service.findone(id);
            account.setAccountId(id);
            account.setMoneyOut(price - yprice);
            account.setOtherAccountId(findone1.getBankAccount());

            //加入账户表消费
            Integer integer1 = accountService.insertdout1(account);
            Integer integer = service.updateisStart(user.getId());
            Integer updatevip = service.updatevip(user);

            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = formatter.format(currentTime);
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setOrderCode(dateString);
            orderInfo.setOrderPrice(price - yprice);
            orderInfo.setCreateBy(findone1.getUsername());
            orderInfo.setStatus(1);
            orderInfo.setUserId(id);
            Integer insertone = orderInfoService.insertone(orderInfo);

            System.out.println("1111111111" + integer1 + integer + updatevip);
            if (updatevip > 0 && integer1 > 0 && integer > 0&& insertone>0) {
                baseResult.setMsg("购买成功！");
                baseResult.setCode(BaseResult.CODE_SUCCESS);
            } else {
                if (updatevip <= 0) {
                    baseResult.setMsg(" 修改用户会员失败！");
                    baseResult.setCode(BaseResult.CODE_SUCCESS);
                }
                if (integer1 <= 0) {
                    baseResult.setMsg(" 用户关闭启用错误！");
                    baseResult.setCode(BaseResult.CODE_SUCCESS);
                }
                if (integer <= 0) {
                    baseResult.setMsg(" 加入金钱数据错误！");
                    baseResult.setCode(BaseResult.CODE_SUCCESS);
                }
                if (insertone <= 0) {
                    baseResult.setMsg(" 生成订单失败错误！");
                    baseResult.setCode(BaseResult.CODE_SUCCESS);
                }
            }
        } else {
            baseResult.setCode(BaseResult.CODE_FAILED);
            baseResult.setMsg("账户余额不足！");
        }
        return baseResult;
    }

    @RequiresPermissions("/user/findOfficialbyRid.do")
    @RequestMapping("/findOfficialbyRid.do")
    public BaseResult findOfficialbyRid(int page, int limit, Integer referId) throws Exception {
        PageInfo officialbyRid = service.findOfficialbyRid(page, limit, referId);
        BaseResult baseResult = new BaseResult();
        baseResult.setMsg("分页查询成功！");
        baseResult.setCode(BaseResult.CODE_SUCCESS);
        baseResult.setData(officialbyRid);
        baseResult.setPage(page);
        baseResult.setLimit(limit);
        baseResult.setCount((int) officialbyRid.getTotal());
        LOGGER.info("分页查询成功！");
        return baseResult;
    }

    @RequiresPermissions("/user/findOfficialbyRidAndUn.do")
    @RequestMapping("/findOfficialbyRidAndUn.do")
    public BaseResult findOfficialbyRidAndUn(int page, int limit, Integer referId, String username) throws Exception {
        PageInfo officialbyRidAndUn = service.findOfficialbyRidAndUn(page, limit, referId, username);
        BaseResult baseResult = new BaseResult();
        baseResult.setMsg("分页查询成功！");
        baseResult.setCode(BaseResult.CODE_SUCCESS);
        baseResult.setData(officialbyRidAndUn);
        baseResult.setPage(page);
        baseResult.setLimit(limit);
        baseResult.setCount((int) officialbyRidAndUn.getTotal());
        LOGGER.info("分页查询成功！");
        return baseResult;
    }

    @RequiresPermissions("/user/findOfficialbyRid2.do")
    @RequestMapping("/findOfficialbyRid2.do")
    public BaseResult findOfficialbyRid2(int page, int limit, Integer referId) throws Exception {
        PageInfo officialbyRid = service.findOfficialbyRid2(page, limit, referId);
        BaseResult baseResult = new BaseResult();
        baseResult.setMsg("分页查询成功！");
        baseResult.setCode(BaseResult.CODE_SUCCESS);
        baseResult.setData(officialbyRid);
        baseResult.setPage(page);
        baseResult.setLimit(limit);
        baseResult.setCount((int) officialbyRid.getTotal());
        LOGGER.info("分页查询成功！");
        return baseResult;
    }

    @RequiresPermissions("/user/findOfficialbyRid2AndUn.do")
    @RequestMapping("/findOfficialbyRid2AndUn.do")
    public BaseResult findOfficialbyRid2AndUn(int page, int limit, Integer referId, String username) throws Exception {
        PageInfo officialbyRidAndUn = service.findOfficialbyRid2AndUn(page, limit, referId, username);
        BaseResult baseResult = new BaseResult();
        baseResult.setMsg("分页查询成功！");
        baseResult.setCode(BaseResult.CODE_SUCCESS);
        baseResult.setData(officialbyRidAndUn);
        baseResult.setPage(page);
        baseResult.setLimit(limit);
        baseResult.setCount((int) officialbyRidAndUn.getTotal());
        LOGGER.info("分页查询成功！");
        return baseResult;
    }
}
