package com.sy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.mapper.GoodsMapper;
import com.sy.model.User;
import com.sy.service.GoodsService;
import com.sy.model.Goods;
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
    public PageInfo findlist(int pageNum, int pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> list = mapper.findlist();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
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
    public PageInfo findgoodsName(int pageNum, int pageSize,String goodsName)  throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> list = mapper.findgoodsName(goodsName);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public Goods findByID(Integer id) throws Exception {
        return mapper.findByID(id);
    }
}
