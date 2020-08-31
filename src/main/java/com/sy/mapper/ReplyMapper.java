package com.sy.mapper;

import com.sy.model.Reply;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ReplyMapper {

    @Insert(value = "insert into LEAVE_REPLY(messageId,replyContent,createdBy,createTime) values(#{messageId},#{replyContent},#{createdBy},now())")
    Integer insert(Reply reply)throws Exception;

    @Select("select * from LEAVE_REPLY where messageId=#{messageId}")
    List<Reply> find(int messageId)throws Exception;

    @Delete("delete from LEAVE_REPLY where messageId=#{messageId}")
    Integer deleteById(Integer messageId)throws Exception;
}
