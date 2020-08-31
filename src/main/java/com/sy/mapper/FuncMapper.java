package com.sy.mapper;

import com.sy.model.Func;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

public interface FuncMapper extends Mapper<Func> {

    /**
     * 按roleId查询所有func
     *
     * @param roleId
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM au_function WHERE id IN (SELECT functionid FROM au_authority WHERE roleId = #{roleId}) order by id asc")
    List<Func> selectByRoleId(@Param("roleId")Integer roleId) throws Exception;

    @Select(" SELECT funcUrl FROM au_function WHERE id IN(SELECT functionid FROM au_authority WHERE roleId =(SELECT roleid FROM au_user WHERE username = #{username}))")
    List<Func> selectByUsername(@Param("username")String username) throws Exception;
    /**
     * 根据角色删除权限
     *
     * @param roleId
     * @return
     * @throws Exception
     */
    @Delete("delete from au_authority where roleId = #{roleId}")
    Integer deleteFuncByRoleId(@Param("roleId")Integer roleId) throws Exception;

    /**
     * 根所角色增加权限
     *
     * @param roleId
     * @param funcId
     * @return
     * @throws Exception
     */
    @Insert("insert into au_authority (roleId,functionId,creationTime,createdBy)" +
            "values(#{roleId},#{funcId},#{creationTime},#{createdBy})")
    Integer insertFuncByRoleId(
            @Param("roleId") Integer roleId,
            @Param("funcId") Integer funcId,
            @Param("creationTime") Date creationTime,
            @Param("createdBy") String createdBy) throws Exception;
}
