package com.sunpeng.flowrate.task;



import com.sunpeng.flowrate.common.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
public class SchedulerDayTask {

    @Value("${phone}")
    private String phoneNumbers ;

    @Value("${url.day}")
    private String url ;

    @Scheduled(cron="0 30 0 * * ?")
    private void process(){
        String[] numbers = phoneNumbers.split(",");
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
