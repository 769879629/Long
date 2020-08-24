package com.sy.mapper;

import com.sy.model.Affiche;
import com.sy.model.Information;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface InformationMapper {

    @Select(value = "SELECT * FROM information ")
    List<Information> findlist( ) throws Exception;

    @Select("SELECT * FROM information where id=#{id}")
    Information selectOne(Integer id) throws Exception;

    @Insert(value = "insert into information(title,content,state,publisher,publishTime,typeId,typeName,fileName,filePath,fileSize,uploadTime) values (#{title},#{content},1,#{publisher},now(),1,'图片','1','D:',40.6,now())")
    Integer insertone(Information information)throws Exception;


    @Delete(value = "delete from information where id = #{id}" )
    Integer deleteById(Integer id)throws Exception;

}
