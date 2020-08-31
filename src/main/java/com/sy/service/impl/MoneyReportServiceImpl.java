package com.sy.service.impl;

import com.sy.mapper.MoneyReportMapper;
import com.sy.model.MoneyReport;
import com.sy.service.MoneyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly = true)
public class MoneyReportServiceImpl implements MoneyReportService {
    @Autowired
    private MoneyReportMapper moneyReportMapper;

    @Override
    public List<MoneyReport> findAll() throws Exception {



        return moneyReportMapper.findAll();
    }
}
