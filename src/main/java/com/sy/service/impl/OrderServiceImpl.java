package com.sy.service.impl;

import com.sy.mapper.OrderMapper;
import com.sy.model.Order;
import com.sy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper mapper;

    @Override
    public List<Order> findlist() throws Exception {
        return mapper.findlist();
    }

    @Override
    public List<Order> findcreateBy(String createBy) throws Exception {
        return mapper.findcreateBy(createBy);
    }

    @Override
    public List<Order> findgoodsName(String goodsName) throws Exception {
        return mapper.findgoodsName(goodsName);
    }
}
