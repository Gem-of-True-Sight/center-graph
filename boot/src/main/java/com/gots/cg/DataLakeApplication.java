package com.gots.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.gots.cg")
public class DataLakeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataLakeApplication.class, args);
    }

}
