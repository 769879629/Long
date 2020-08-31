package com.sy.mapper;

import com.sy.model.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMapper extends Mapper<Role> {

    @Insert(value = "insert into au_role(roleCode,roleName,createDate,isStart,createBy) values (#{roleCode},#{roleName},now(),#{isStart},#{createBy})")
    Integer insertone(Role role)throws Exception;

}
