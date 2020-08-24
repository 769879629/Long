package com.sy.mapper;

import com.sy.model.Dd;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DdMapper {

    @Select(value = "SELECT * FROM data_dictionary ")
    List<Dd> findlist( ) throws Exception;

}
