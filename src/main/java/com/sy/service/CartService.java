package com.sy.service;

import com.github.pagehelper.PageInfo;
import com.sy.model.Cart;

import java.util.List;

public interface CartService {

    PageInfo findlist(int pageNum, int pageSize, String createBy) throws Exception;

    Integer insertone(Cart cart)throws Exception;

    Cart findByGoodsId(Integer goodsId) throws Exception;

    Integer updateOne(Cart cart)throws Exception;

    Integer deleteById(Integer id)throws Exception;

    Integer updateOnej(Cart cart)throws Exception;

}
