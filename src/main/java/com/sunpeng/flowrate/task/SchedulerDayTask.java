package com.sunpeng.flowrate.task;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SchedulerDayTask {

    @Value("${phone}")
    private String phoneNumbers ;

    @Value("${url.day}")
    private String url ;

    @Scheduled(cron="0 0/1 * * * ?")
    private void process(){
        String[] numbers = phoneNumbers.split(",");
        for (String phone:numbers){
            log.info("this is scheduler task runing 日 :手机 "+phone);
            log.info(url);

        }
    }
}
