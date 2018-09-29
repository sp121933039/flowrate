package com.sunpeng.flowrate.task;



import com.sunpeng.flowrate.common.HttpClientUtil;
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

    @Scheduled(cron="0 5 0 * * ?")
    private void process(){
        String[] numbers = phoneNumbers.split(",");
        for (String phone:numbers){
            log.info("订购日包 :手机 "+phone);
            try {
                HttpClientUtil.doGet(url+phone);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
