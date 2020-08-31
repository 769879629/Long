package com.sy.service;

import com.sy.model.Shopcart;

import java.util.List;

public interface ShopcartService {

    List<Shopcart> findlist(Integer userId) throws Exception;


//    Integer insert(Shopcart shopcart,Integer id)throws Exception;


}
