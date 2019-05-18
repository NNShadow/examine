package com.examine;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//指定数据访问接口的包名
@MapperScan("com.examine.repository")
public class ExamineApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExamineApplication.class, args);
    }

}
