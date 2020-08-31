package com.sy.controller;

import com.sy.model.MoneyReport;
import com.sy.service.MoneyReportService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mr")
public class MoneyReportController {
    @Autowired
    private MoneyReportService service;

    @RequiresPermissions("/mr/findAll.do")
    @RequestMapping("/findAll.do")
    public List<MoneyReport> findAll()throws Exception{
        return service.findAll();
    }
}
