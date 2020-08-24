package com.sy.service;

import com.sy.model.Order;

import java.util.List;

public interface OrderService {


    List<Order> findlist( ) throws Exception;

    List<Order> findcreateBy(String createBy) throws Exception;

    List<Order> findgoodsName(String goodsName) throws Exception;

}
