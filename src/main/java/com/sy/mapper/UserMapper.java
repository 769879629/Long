package com.sy.mapper;

import com.sy.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {

    @Select(value = "SELECT * FROM au_user  where id=#{id}")
    User findone(Integer id) throws Exception;

    @Update(value = "update au_user set id=#{id},username=#{username},`realName`=#{realName},`sex`=#{sex},`birthday`=#{birthday},`cardTypeName`=#{cardTypeName},`idCard`=#{idCard},`country`=#{country},`mobile`=#{mobile},`email`=#{email},`userAddress`=#{userAddress},`postCode`=#{postCode},`createTime`=#{createTime},`referCode`=#{referCode},`bankAccount`=#{bankAccount},`bankName`=#{bankName},`accountHolder`=#{accountHolder} where id=#{id}")
    Integer updateId(User user)throws Exception;

    @Update(value = "update au_user set `password`=#{password}, `password2`=#{password2} where id=#{id}")
    Integer updatepassword(User user)throws Exception;

    @Insert(value = "insert into au_user(username,`password`,`password2`,sex,mobile,roleId,roleName,isStart,createTime,lastUpdateTime,lastLoginTime) values (#{username},'111111','111111',#{sex},#{mobile},0,'注册会员',2,now(),now(),now())")
    Integer insertone(User user)throws Exception;

    @Select(value = "SELECT * FROM au_user ")
    List<User> findlist( ) throws Exception;

    @Update(value = "update au_user set `isStart`= 2 where id=#{id}")
    Integer updateisStart(Integer id)throws Exception;

    @Insert(value = "insert into au_user(username,`password`,`password2`,sex,mobile,roleId,roleName,isStart,createTime,lastUpdateTime,lastLoginTime) values (#{username},#{password},#{password2},#{sex},#{mobile},2,'注册会员',0,now(),now(),now())")
    Integer addone(User user)throws Exception;

    @Select(value = "SELECT * FROM au_user where roleName = '注册会员'and isStart=0 ")
    List<User> findlogin( ) throws Exception;

    @Select(value = "SELECT * FROM au_user where roleName != '注册会员' ")
    List<User> findoffical( ) throws Exception;

    @Delete(value = "delete from au_user where id = #{id}")
    Integer deleteone(Integer id)throws Exception;

    @Select(value = "SELECT * FROM au_user where username like CONCAT('%',#{username},'%') ")
    List<User> findusername(String username) throws Exception;

    @Update(value = "update au_user set `isStart`= 1 where id=#{id}")
    Integer updateisStart1(Integer id)throws Exception;

    @Update(value = "update au_user set username=#{username},`realName`=#{realName},`sex`=#{sex},`isStart`=#{isStart},`mobile`=#{mobile} where id=#{id}")
    Integer update1(User user)throws Exception;

    @Update(value = "update au_user set `password`='1234', `password2`='4321' where id=#{id}")
    Integer updatepassword1(Integer id)throws Exception;

    @Update(value = "update au_user set roleId=#{roleId},roleName=#{roleName} where id=#{id}")
    Integer updatevip(User user)throws Exception;

}
