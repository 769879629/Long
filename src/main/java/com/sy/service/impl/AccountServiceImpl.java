package com.sy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.mapper.AccountMapper;
import com.sy.model.Account;
import com.sy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper mapper;

    @Override
    public PageInfo findBymoneyIn(int pageNum, int pageSize,Integer id) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<Account> bymoneyIn = mapper.findBymoneyIn(id);
        PageInfo pageInfo =new PageInfo(bymoneyIn);
        return pageInfo;
    }

    @Override
    public PageInfo findBymoneyOut(int pageNum, int pageSize,Integer id) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<Account> bymoneyOut = mapper.findBymoneyOut(id);
        PageInfo pageInfo =new PageInfo(bymoneyOut);
        return pageInfo;
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer insertone(Account account) throws Exception {
        return mapper.insertone(account);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer insertdout(Account account) throws Exception {
        return mapper.insertdout(account);
    }

    @Override
    public Account findbalance(Integer accountId) throws Exception {
        return mapper.findbalance(accountId);
    }
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer insertdout1(Account account) throws Exception {
        return mapper.insertdout1(account);
    }
}
