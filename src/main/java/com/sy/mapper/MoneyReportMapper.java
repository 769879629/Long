package com.sy.mapper;

import com.sy.model.MoneyReport;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MoneyReportMapper {

    @Select("select * from REPORT2 ")
    List<MoneyReport> findAll()throws Exception;


}
