package com.sy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.mapper.UserMapper;
import com.sy.model.User;
import com.sy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;

    public User findByUsername(String username) throws Exception{
        Example example = new Example(User.class);
        example.createCriteria().andCondition("username=", username);
        List<User> list = mapper.selectByExample(example);
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public User findone(Integer id) throws Exception {

        return mapper.findone(id);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer updateId(User user) throws Exception {
        return mapper.updateId(user);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer updatepassword(User user) throws Exception {
        return mapper.updatepassword(user);
    }

    @Override
    public List<User> findlist() throws Exception {
        return mapper.findlist();
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer insertone(User user) throws Exception {
        return mapper.insertone(user);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer updateisStart(Integer id) throws Exception {



        return mapper.updateisStart(id);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer addone(User user) throws Exception {
        return mapper.addone(user);
    }

    @Override
    public List<User> findlogin() throws Exception {
        return mapper.findlogin();
    }

    @Override
    public List<User> findoffical() throws Exception {
        return mapper.findoffical();
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer deleteone(Integer id) throws Exception {
        return mapper.deleteone(id);
    }

    @Override
    public List<User> findusername(String username) throws Exception {
        return mapper.findusername(username);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer updateisStart1(Integer id) throws Exception {



        return mapper.updateisStart1(id);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer update1(User user) throws Exception {
        return mapper.update1(user);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer updatepassword1(Integer id) throws Exception {
        return mapper.updatepassword1(id);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer updatevip(User user) throws Exception {
        return mapper.updatevip(user);
    }

}
