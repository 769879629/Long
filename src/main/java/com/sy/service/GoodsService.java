package com.sy.service;

import com.github.pagehelper.PageInfo;
import com.sy.model.Goods;
import com.sy.model.User;

import java.util.List;

public interface GoodsService {

    PageInfo findlist(int pageNum, int pageSize) throws Exception;

    Integer insertone(Goods goods) throws Exception;

    Integer updatenum(Integer num, Integer id)throws Exception;

    PageInfo findgoodsName(int pageNum, int pageSize,String goodsName) throws Exception;

    Goods findByID(Integer id)throws Exception;

}
