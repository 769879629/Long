package com.sy.mapper;

import com.sy.model.Account;
import com.sy.model.Uaccount;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UaccountMapper {

    @Select(value = "SELECT * FROM USER_ACCOUNT ")
    List<Uaccount> findlist( ) throws Exception;


}
