package com.it.springbootwebsp.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
//@Aspect  //AOP类
@Slf4j
public class TimeAspect {

    @Around("com.it.springbootwebsp.aop.MyAspect.pc()")
    public Object recordTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        //1.记录开始时间
        long begin = System.currentTimeMillis();
        //2.调用原始方法
        Object result = proceedingJoinPoint.proceed();

        //3.计算结束时间
        long end = System.currentTimeMillis();
        log.info(proceedingJoinPoint.getSignature()+" 方法耗时:{}ms",end - begin);

        return result;
    }

}
