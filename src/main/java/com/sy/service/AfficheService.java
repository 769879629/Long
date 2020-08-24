package com.sy.service;

import com.sy.model.Affiche;

import java.util.List;

public interface AfficheService {

    List<Affiche> selectFive() throws Exception;

    List<Affiche> selectAll() throws Exception;

    Affiche selectOne(Integer id) throws Exception;

    Integer insertone(Affiche affiche)throws Exception;

    Integer deleteById(Integer id)throws Exception;

}
