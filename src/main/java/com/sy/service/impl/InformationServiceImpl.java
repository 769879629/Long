package com.sy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageInfo findlist(int pageNum, int pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<Information> list = mapper.findlist();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
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
