package com.it.springbootwebsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringbootWebSpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebSpApplication.class, args);
    }

}
