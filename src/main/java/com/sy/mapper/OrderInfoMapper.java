package com.sy.mapper;

import com.sy.model.OrderInfo;
import com.sy.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderInfoMapper {

    @Insert(value = "insert into order_info(orderCode,orderPrice,createTime,createBy,lastUpdateTime,status,userId) values (#{orderCode},#{orderPrice},now(),#{createBy},now(),#{status},#{userId})")
    Integer insertone(OrderInfo orderInfo)throws Exception;

    @Select(value = "SELECT * FROM order_info where userId = #{userId}")
    List<OrderInfo> findlist(Integer userId) throws Exception;

    @Select(value = "SELECT * FROM order_info where userId = #{userId} and orderPrice>=1000")
    List<OrderInfo> findlist1(Integer userId) throws Exception;
}
