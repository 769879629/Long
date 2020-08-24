package com.sy.mapper;

import com.sy.model.Reply;
import org.apache.ibatis.annotations.Insert;

public interface ReplyMapper {

    @Insert(value = "insert into LEAVE_REPLY(messageId,replyContent,createdBy,createTime) values(#{messageId},#{replyContent},#{createdBy},now())")
    Integer insert(Reply reply)throws Exception;


}
