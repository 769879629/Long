package com.sy.service;

import com.sy.model.Pack;

import java.util.List;

public interface PackService {

    List<Pack> findlist( ) throws Exception;

    List<Pack> findgoodsPackName(String goodsPackName) throws Exception;

    Integer addone(Pack pack)throws Exception;


}
