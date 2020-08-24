package com.sy.mapper;

import com.sy.model.Cart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CartMapper {


    @Select(value = "select*from CART_GOODS where createBy = #{createBy}")
    List<Cart> findlist(String createBy) throws Exception;

    @Insert(value = "insert into CART_GOODS(goodsId ,goodsName,goodsPrice,goodsNum,cartId,flag,createBy,createTime,lastUpdateTime) values (#{goodsId},#{goodsName},#{goodsPrice},#{goodsNum},1,1,#{createBy},now(),now())")
    Integer insertone(Cart cart)throws Exception;

}
