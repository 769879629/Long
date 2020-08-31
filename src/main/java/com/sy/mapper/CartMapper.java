package com.sy.mapper;

import com.sy.model.Cart;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CartMapper {


    @Select(value = "select*from CART_GOODS where createBy = #{createBy}")
    List<Cart> findlist(@Param("createBy")String createBy) throws Exception;

    @Insert(value = "insert into CART_GOODS(goodsId ,goodsName,goodsPrice,goodsNum,cartId,flag,createBy,createTime,lastUpdateTime) values (#{goodsId},#{goodsName},#{goodsPrice},#{goodsNum},1,1,#{createBy},now(),now())")
    Integer insertone(Cart cart)throws Exception;

    @Select(value = "select*from CART_GOODS where goodsId = #{goodsId}")
    Cart findByGoodsId(@Param("goodsId")Integer goodsId) throws Exception;

    @Update(value = "update CART_GOODS set goodsNum=goodsNum+#{goodsNum} where goodsId=#{goodsId}")
    Integer updateOne(Cart cart)throws Exception;

    @Update(value = "update CART_GOODS set goodsNum=goodsNum-#{goodsNum} where goodsId=#{goodsId}")
    Integer updateOnej(Cart cart)throws Exception;

    @Delete("delete from CART_GOODS where id=#{id}")
    Integer deleteById(Integer id)throws Exception;
}
