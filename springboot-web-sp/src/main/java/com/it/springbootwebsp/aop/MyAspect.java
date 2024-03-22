package com.it.springbootwebsp.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
//@Aspect
@Slf4j
public class MyAspect {

    //抽取 切入点表达式
    @Pointcut("execution(* com.it.springbootwebsp.service..*.*(..))")
    //@Pointcut("@annotation(com.it.springbootwebsp.aop.MyLog)")
    private void pc(){}

    @Before("pc()")
    public void before(){
        log.info("before......");
    }

    @Around("pc()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("around before......");
        Object object = proceedingJoinPoint.proceed();
        log.info("around after......");
        return object;
    }

    @After("pc()")
    public void after(){
        log.info("after......");
    }

    @AfterReturning("pc()")
    public void afterReturning(){
        log.info("afterReturning......");
    }

    @AfterThrowing("pc()")
    public void afterThrowing(){
        log.info("afterThrowing......");
    }
}
