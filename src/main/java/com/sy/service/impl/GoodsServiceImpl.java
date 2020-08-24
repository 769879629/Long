package com.sy.service.impl;

import com.sy.mapper.GoodsMapper;
import com.sy.model.Goods;
import com.sy.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper mapper;

    @Override
    public List<Goods> findlist() throws Exception {
        return mapper.findlist();
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer insertone(Goods goods) throws Exception {

        return mapper.insertone(goods);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Integer updatenum(Integer num,Integer id) throws Exception {
        return mapper.updatenum(  num,  id);
    }

    @Override
    public List<Goods> findgoodsName(String goodsName) throws Exception {
        return mapper.findgoodsName(goodsName);
    }
}
