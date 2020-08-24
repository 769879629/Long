package com.sy.service;

import com.sy.model.Cart;

import java.util.List;

public interface CartService {

    List<Cart> findlist(String createBy) throws Exception;

    Integer insertone(Cart cart)throws Exception;

}
