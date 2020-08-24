package com.sy.mapper;

import com.sy.model.Goods;
import com.sy.model.Pack;
import com.sy.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PackMapper {

    @Select(value = "SELECT * FROM GOODS_PACK where num>0 ")
    List<Pack> findlist( ) throws Exception;

    @Select(value = "SELECT * FROM GOODS_PACK where goodsPackName like CONCAT('%',#{goodsPackName},'%') ")
    List<Pack> findgoodsPackName(String goodsPackName) throws Exception;

    @Insert(value = "insert into GOODS_PACK(goodsPackName,goodsPackCode,typeId,typeName,totalPrice,state,note,num,createdBy,createTime,lastUpdateTime) values (#{goodsPackName},'111',1,'生活用品',#{totalPrice},#{state},#{note},#{num},#{createdBy},now(),now())")
    Integer addone(Pack pack)throws Exception;

}
