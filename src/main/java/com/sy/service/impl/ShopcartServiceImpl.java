package com.sy.service.impl;

import com.sy.mapper.ShopcartMapper;
import com.sy.model.Shopcart;
import com.sy.service.ShopcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly = true)
public class ShopcartServiceImpl implements ShopcartService {

    @Autowired
    private ShopcartMapper mapper;

    @Override
    public List<Shopcart> findlist(Integer userId) throws Exception {
        return mapper.findlist(userId);
    }

//    @Override
//    public Integer insert(Shopcart shopcart,Integer id) throws Exception {
//        return mapper.insert(shopcart,id);
//    }
}
