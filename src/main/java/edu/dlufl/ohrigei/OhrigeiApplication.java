package edu.dlufl.ohrigei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("edu.dlufl.ohrigei.dao")
public class OhrigeiApplication {
    public static void main(String[] args) {
        SpringApplication.run(OhrigeiApplication.class, args);
    }

}
