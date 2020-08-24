package com.sy.mapper;

import com.sy.model.Account;
import com.sy.model.Affiche;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AfficheMapper {

    /**
     * 查询所有公告
     *
     */
    @Select("SELECT * FROM affiche  order by publishTime asc LIMIT 0,5")
    List<Affiche> selectFive() throws Exception;

    @Select("SELECT * FROM affiche  order by publishTime asc ")
    List<Affiche> selectAll() throws Exception;

    @Select("SELECT * FROM affiche where id=#{id}")
    Affiche selectOne(Integer id) throws Exception;

    @Insert(value = "insert into affiche(title,content,publisher,publishTime,startTime,endTime) values (#{title},#{content},#{publisher},now(),#{startTime},#{endTime})")
    Integer insertone(Affiche affiche)throws Exception;


    @Delete(value = "delete from affiche where id = #{id}" )
     Integer deleteById(Integer id)throws Exception;


}
