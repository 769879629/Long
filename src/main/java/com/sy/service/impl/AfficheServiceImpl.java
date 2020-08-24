package com.sy.service.impl;

import com.sy.mapper.AfficheMapper;
import com.sy.model.Affiche;
import com.sy.service.AfficheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AfficheServiceImpl implements AfficheService {

    @Autowired
    private AfficheMapper mapper;

    @Override
    public List<Affiche> selectFive() throws Exception {

        return mapper.selectFive();
    }

    @Override
    public List<Affiche> selectAll() throws Exception {
        return mapper.selectAll();
    }

    @Override
    public Affiche selectOne(Integer id) throws Exception {
        return mapper.selectOne(id);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer insertone(Affiche affiche) throws Exception {
        return mapper.insertone(affiche);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer deleteById(Integer id) throws Exception {
        return mapper.deleteById(id);
    }
}
