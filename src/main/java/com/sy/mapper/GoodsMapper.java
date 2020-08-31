package com.sy.mapper;

import com.sy.model.Goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GoodsMapper {

    @Select(value = "SELECT * FROM goods_info where num>0 ")
    List<Goods> findlist() throws Exception;

    @Insert(value = "INSERT into  goods_info(goodsSN,goodsName,goodsFormat,marketPrice,realPrice,state,note,num,unit,createTime,lastUpdateTime,createdBy) VALUES(#{goodsSN},#{goodsName},#{goodsFormat},#{marketPrice},#{realPrice},#{state},#{note},#{num},#{unit},NOW(),NOW(),#{createdBy})")
    Integer insertone(Goods goods) throws Exception;

    @Update(value = "update goods_info set num=num-#{num} where id=#{id}")
    Integer updatenum(@Param("num")Integer num, @Param("id")Integer id)throws Exception;

    @Select(value = "SELECT * FROM goods_info where goodsName like CONCAT('%',#{goodsName},'%') and num>0")
    List<Goods> findgoodsName(@Param("goodsName")String goodsName) throws Exception;

    @Select("SELECT * FROM goods_info where id = #{id}")
    Goods findByID(Integer id)throws Exception;
}
