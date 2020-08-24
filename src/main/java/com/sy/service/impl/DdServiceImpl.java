package com.sy.service.impl;

import com.sy.mapper.DdMapper;
import com.sy.model.Dd;
import com.sy.service.DdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DdServiceImpl implements DdService {
    @Autowired
    private DdMapper mapper;
    @Override
    public List<Dd> findlist() throws Exception {
        return mapper.findlist();
    }
}
