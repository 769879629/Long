package com.sy.service.impl;

import com.sy.mapper.UaccountMapper;
import com.sy.model.Account;
import com.sy.model.Uaccount;
import com.sy.service.UaccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UaccountServiceImpl implements UaccountService {

    @Autowired
    private UaccountMapper mapper;

    @Override
    public List<Uaccount> findlist() throws Exception {
        return mapper.findlist();
    }
}
