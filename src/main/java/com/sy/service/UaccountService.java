package com.sy.service;

import com.sy.model.Account;
import com.sy.model.Uaccount;

import java.util.List;

public interface UaccountService {
    List<Uaccount> findlist( ) throws Exception;
}
