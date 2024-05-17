package com.zhuang.easyes;

import org.dromara.easyes.starter.register.EsMapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EsMapperScan("")
public class MyEasyEsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyEasyEsApplication.class, args);
    }

}
