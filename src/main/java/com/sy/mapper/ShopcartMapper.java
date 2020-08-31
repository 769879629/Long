package com.sy.mapper;

import com.sy.model.Shopcart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShopcartMapper {


    @Select(value = "SELECT * FROM shopcart where userId=#{userId}")
    List<Shopcart> findlist(Integer userId) throws Exception;

//    @Insert(value = "insert into shopcart(userId,totalPrice,createby,lastUpdateTime,createTime) select  #{userId},#{totalPrice}, username,now(),now() from au_user where id= #{id}")
//    Integer insert(Shopcart shopcart,@Param("id") Integer id)throws Exception;

}
