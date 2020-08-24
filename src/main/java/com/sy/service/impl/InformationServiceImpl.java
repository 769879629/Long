package com.sy.service.impl;

import com.sy.mapper.InformationMapper;
import com.sy.model.Affiche;
import com.sy.model.Information;
import com.sy.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class InformationServiceImpl implements InformationService {

    @Autowired
    private InformationMapper mapper;

    @Override
    public List<Information> findlist() throws Exception {
        return mapper.findlist();
    }

    @Override
    public Information selectOne(Integer id) throws Exception {
        return mapper.selectOne(id);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer insertone(Information information) throws Exception {
        return mapper.insertone(information);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer deleteById(Integer id) throws Exception {
        return mapper.deleteById(id);
    }
}
