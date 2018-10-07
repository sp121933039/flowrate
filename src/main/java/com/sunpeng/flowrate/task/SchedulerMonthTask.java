package com.sunpeng.flowrate.task;

import com.sunpeng.flowrate.common.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
public class SchedulerMonthTask {

    @Value("${phone}")
    private String phoneNumbers ;

    @Value("${url.month}")
    private String url ;

    @Scheduled(cron="0 0 5 1 * ?")
    private void process(){
        String[] numbers = phoneNumbers.split(",");
        Arrays.stream(numbers).forEach(phone->{
            log.info("订购月包手机："+phone);
            try {
                HttpClientUtil.doGet(url+phone);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
