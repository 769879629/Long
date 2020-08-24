package com.sy.service.impl;

import com.sy.mapper.CartMapper;
import com.sy.model.Cart;
import com.sy.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper mapper;

    @Override
    public List<Cart> findlist(String createBy) throws Exception {
        return mapper.findlist(createBy);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer insertone(Cart cart) throws Exception {
        return mapper.insertone(cart);
    }
}
