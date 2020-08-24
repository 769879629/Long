package com.sy.service.impl;

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
    public List<Account> findlist() throws Exception {
        return mapper.findlist();
    }

    @Override
    public List<Account> findlist1() throws Exception {
        return mapper.findlist1();
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
    public Account findbalance() throws Exception {
        return mapper.findbalance();
    }
}
