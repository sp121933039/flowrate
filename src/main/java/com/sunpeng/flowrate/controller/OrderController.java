package com.sunpeng.flowrate.controller;

import com.sunpeng.flowrate.service.day.IOrderDayService;
import com.sunpeng.flowrate.service.month.IOrderMonthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private IOrderDayService orderDayService;

    @Resource
    private IOrderMonthService orderMonthService;

    @GetMapping("/day")
    public String day(@RequestParam(name = "phone",required = false) String phone){

        orderDayService.process(phone);
        return "ok";
    }

    @GetMapping("/month")
    public String month(@RequestParam(name = "phone",required = false) String phone){

        orderMonthService.process(phone);

        return "ok";
    }

}
