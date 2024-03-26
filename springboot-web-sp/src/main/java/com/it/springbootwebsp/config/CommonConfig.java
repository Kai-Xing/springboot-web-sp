package com.it.springbootwebsp.config;

import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

    //声明第三方bean
    @Bean //将当前方法的返回值对象交给IOC容器管理，成为IOC容器bean
          //通过@Bean注解的name或value属性指定bean名称，默认为方法名。
    public SAXReader saxReader(){
        return new SAXReader();
    }
}
