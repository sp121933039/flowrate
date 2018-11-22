package com.sunpeng.flowrate.service.day.impl;

import com.sunpeng.flowrate.common.HttpClientUtil;
import com.sunpeng.flowrate.service.day.IOrderDayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Slf4j
public class OrderDayService implements IOrderDayService {

    @Value("${phone}")
    private String phoneNumbers ;

    @Value("${url.day}")
    private String url ;


    @Override
    public void process(String phones) {

        String[] numbers;
        if(null != phones &&!"".equals(phones)){
            numbers = phones.split(",");
        }else{
            numbers = phoneNumbers.split(",");
        }
        Arrays.stream(numbers).forEach(phone->{
            log.info("day:phone "+phone);
            try {
                HttpClientUtil.doGet(url+phone);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}
