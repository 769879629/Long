package com.sy.service;

import com.github.pagehelper.PageInfo;
import com.sy.model.OrderInfo;

public interface OrderInfoService {
    Integer insertone(OrderInfo orderInfo)throws Exception;

    PageInfo findlogin(int pageNum, int pageSize,Integer userId) throws Exception;
    PageInfo findlogin1(int pageNum, int pageSize,Integer userId) throws Exception;
}
