package com.sy.mapper;

import com.sy.model.Auth;
import com.sy.model.Func;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AuthMapper {

    @Select("SELECT * FROM au_function WHERE id IN (SELECT functionid FROM au_authority WHERE roleId = #{roleId}) order by id asc")
    List<Auth> selectByRoleId(@Param("roleId")Integer roleId) throws Exception;

}
