package com.sy.mapper;

import com.sy.model.Message;
import com.sy.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MessageMapper {

    @Select(value = "SELECT * FROM LEAVE_MESSAGE ")
    List<Message> findlist( ) throws Exception;

    @Insert(value = "insert into LEAVE_MESSAGE(createdBy,`messageContent`,`messageTitle`,messageCode,state,createTime) values (#{createdBy},'111',#{messageTitle},#{messageCode},0,now())")
    Integer insertone(Message message)throws Exception;

    @Select(value = "SELECT * FROM LEAVE_MESSAGE where id=#{id} ")
    Message findone(Integer id) throws Exception;

    @Update(value = "update LEAVE_MESSAGE set `state`=1 where id=#{id}")
    Integer updateId(Integer id)throws Exception;

}
