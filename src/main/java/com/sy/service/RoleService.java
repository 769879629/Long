package com.sy.service;

import com.github.pagehelper.PageInfo;
import com.sy.model.Role;

import java.util.List;

public interface RoleService  {

    Integer save(Role role) throws Exception;

    Integer removeById(Integer id) throws Exception;

    Integer modify(Role role) throws Exception;

    PageInfo findByPage() throws Exception;

    Role findById(Integer id) throws Exception;


}
