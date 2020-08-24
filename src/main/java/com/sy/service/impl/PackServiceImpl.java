package com.sy.service.impl;

import com.sy.mapper.PackMapper;
import com.sy.model.Pack;
import com.sy.service.PackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PackServiceImpl implements PackService {

    @Autowired
    private PackMapper mapper;

    @Override
    public List<Pack> findlist() throws Exception {
        return mapper.findlist();
    }

    @Override
    public List<Pack> findgoodsPackName(String goodsPackName) throws Exception {
        return mapper.findgoodsPackName(goodsPackName);
    }


    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer addone(Pack pack) throws Exception {
        return mapper.addone(pack);
    }
}
