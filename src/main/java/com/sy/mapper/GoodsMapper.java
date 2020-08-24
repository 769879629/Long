package com.sy.mapper;

import com.sy.model.Goods;
import com.sy.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GoodsMapper {

    @Select(value = "SELECT * FROM goods_info where num>0 ")
    List<Goods> findlist( ) throws Exception;

    @Insert(value = "INSERT into  goods_info(goodsSN,goodsName,goodsFormat,marketPrice,realPrice,state,note,num,unit,createTime,lastUpdateTime,createdBy) VALUES(#{goodsSN},#{goodsName},#{goodsFormat},#{marketPrice},#{realPrice},#{state},#{note},#{num},#{unit},NOW(),NOW(),#{createdBy})")
    Integer insertone(Goods goods) throws Exception;

    @Update(value = "update goods_info set num=num-#{num} where id=#{id}")
    Integer updatenum(Integer num,Integer id)throws Exception;

    @Select(value = "SELECT * FROM goods_info where goodsName like CONCAT('%',#{goodsName},'%') ")
    List<Goods> findgoodsName(String goodsName) throws Exception;
}
