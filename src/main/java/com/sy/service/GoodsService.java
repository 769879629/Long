package com.sy.service;

import com.sy.model.Goods;
import com.sy.model.User;

import java.util.List;

public interface GoodsService {

    List<Goods> findlist( ) throws Exception;

    Integer insertone(Goods goods) throws Exception;

    Integer updatenum(Integer num,Integer id)throws Exception;

    List<Goods> findgoodsName(String goodsName) throws Exception;

}
