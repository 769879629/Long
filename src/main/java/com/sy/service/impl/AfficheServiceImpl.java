package com.sy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.mapper.AfficheMapper;
import com.sy.model.Affiche;
import com.sy.model.User;
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
    public PageInfo selectAll(int pageNum, int pageSize)  throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<Affiche> list = mapper.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
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
