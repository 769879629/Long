package com.sy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.mapper.OrderInfoMapper;
import com.sy.model.OrderInfo;
import com.sy.model.User;
import com.sy.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoMapper mapper;

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer insertone(OrderInfo orderInfo) throws Exception {
        return mapper.insertone(orderInfo);
    }

    @Override
    public PageInfo findlogin(int pageNum, int pageSize, Integer userId) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<OrderInfo> list = mapper.findlist(userId);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }
    @Override
    public PageInfo findlogin1(int pageNum, int pageSize, Integer userId) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<OrderInfo> list = mapper.findlist1(userId);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
