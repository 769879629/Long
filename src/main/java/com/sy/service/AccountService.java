package com.sy.service;

import com.github.pagehelper.PageInfo;
import com.sy.model.Account;

import java.util.List;

public interface AccountService {

    PageInfo findBymoneyIn(int pageNum, int pageSize,Integer id) throws Exception;

    PageInfo findBymoneyOut(int pageNum, int pageSize) throws Exception;

    Integer insertone(Account account)throws Exception;

    Integer insertdout(Account account)throws Exception;

    Account findbalance()throws Exception;
}
