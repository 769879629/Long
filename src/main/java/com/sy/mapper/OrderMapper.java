package com.sy.mapper;



import com.sy.model.Order;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {

    @Select(value = "SELECT * FROM ORDER_GOODS ")
    List<Order> findlist( ) throws Exception;

    @Select(value = "SELECT * FROM ORDER_GOODS where createBy like CONCAT('%',#{createBy},'%') ")
    List<Order> findcreateBy(String createBy) throws Exception;

    @Select(value = "SELECT * FROM ORDER_GOODS where goodsName like CONCAT('%',#{goodsName},'%') ")
    List<Order> findgoodsName(String goodsName) throws Exception;
}
