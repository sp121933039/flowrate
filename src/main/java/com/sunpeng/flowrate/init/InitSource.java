package com.sunpeng.flowrate.init;


import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public  class InitSource implements CommandLineRunner {



    @Override
    public void run(String... args) throws Exception {
        System.out.println("初始化资源");
    }

}
