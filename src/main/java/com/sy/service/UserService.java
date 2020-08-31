package com.sy.service;


import com.github.pagehelper.PageInfo;
import com.sy.model.Account;
import com.sy.model.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserService {
    User findByUsername(String username) throws Exception;

    User findone(Integer id) throws Exception;

    Integer updateId(User user)throws Exception;

    Integer updatepassword(User user)throws Exception;

    List<User> findlist( ) throws Exception;

    Integer insertone(User user)throws Exception;

    Integer updateisStart(Integer id)throws Exception;

    Integer addone(User user)throws Exception;

    PageInfo findlogin(int pageNum, int pageSize,Integer referId) throws Exception;

    PageInfo findoffical(int pageNum, int pageSize,Integer referId) throws Exception;

    Integer deleteone(Integer id)throws Exception;

    PageInfo findusername(int pageNum, int pageSize,String username) throws Exception;

    PageInfo findOfficialbyUn(int pageNum, int pageSize,String username) throws Exception;

    Integer updateisStart1(Integer id)throws Exception;

    Integer update1(User user)throws Exception;

    Integer updatepassword1(Integer id)throws Exception;

    Integer updatevip(User user)throws Exception;

    PageInfo findOfficialbyRid(int pageNum, int pageSize,Integer referId) throws Exception;

    PageInfo findOfficialbyRidAndUn(int pageNum, int pageSize,Integer referId,String username) throws Exception;

    PageInfo findOfficialbyRid2(int pageNum, int pageSize,Integer referId) throws Exception;

    PageInfo findOfficialbyRid2AndUn(int pageNum, int pageSize,Integer referId,String username) throws Exception;

}
