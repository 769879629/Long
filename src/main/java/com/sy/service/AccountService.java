package com.sy.service;

import com.sy.model.Account;

import java.util.List;

public interface AccountService {

    List<Account> findlist( ) throws Exception;

    List<Account> findlist1( ) throws Exception;

    Integer insertone(Account account)throws Exception;

    Integer insertdout(Account account)throws Exception;

    Account findbalance()throws Exception;
}
