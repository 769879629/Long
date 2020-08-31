package com.sy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.mapper.CartMapper;
import com.sy.model.Cart;
import com.sy.model.User;
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
    public PageInfo findlist(int pageNum, int pageSize,String createBy) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<Cart> list = mapper.findlist(createBy);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer insertone(Cart cart) throws Exception {
        return mapper.insertone(cart);
    }

    @Override
    public Cart findByGoodsId(Integer goodsId) throws Exception {
        return mapper.findByGoodsId(goodsId);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer updateOne(Cart cart) throws Exception {
        return mapper.updateOne(cart);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer deleteById(Integer id) throws Exception {
        return mapper.deleteById(id);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer updateOnej(Cart cart) throws Exception {
        return mapper.updateOnej(cart);
    }
}
