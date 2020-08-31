package com.sy.service;

import com.sy.model.MoneyReport;

import java.util.List;

public interface MoneyReportService {

    List<MoneyReport> findAll()throws Exception;
}
