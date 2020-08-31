package com.sy.service;

import com.github.pagehelper.PageInfo;
import com.sy.model.Affiche;
import com.sy.model.Information;

import java.util.List;

public interface InformationService {

    PageInfo findlist(int pageNum, int pageSize) throws Exception;

    Information selectOne(Integer id) throws Exception;

    Integer insertone(Information information)throws Exception;

    Integer deleteById(Integer id)throws Exception;








}
