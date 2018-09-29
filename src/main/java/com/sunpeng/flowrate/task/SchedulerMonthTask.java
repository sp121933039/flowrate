package com.sunpeng.flowrate.task;

import com.sunpeng.flowrate.common.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SchedulerMonthTask {

    @Value("${phone}")
    private String phoneNumbers ;

    @Value("${url.month}")
    private String url ;

    @Scheduled(cron="0 5 0 1 * ?")
    private void process(){
        String[] numbers = phoneNumbers.split(",");
        for (String phone:numbers){
            log.info("订购月包手机："+phone);
            try {
                HttpClientUtil.doGet(url+phone);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
