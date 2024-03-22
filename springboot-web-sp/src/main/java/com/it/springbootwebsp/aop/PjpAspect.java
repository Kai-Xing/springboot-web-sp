package com.it.springbootwebsp.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Aspect
@Slf4j
@Component
public class PjpAspect {

    @Pointcut("execution(* com.it.springbootwebsp.service.DeptService.*(..))")
    private void pt(){}

    @Before("pt()")
    public void before(JoinPoint joinPoint){
        log.info("pjp...before...");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        log.info("pjp...around.before");

        //1.获取目标对象类名
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        log.info("目标对象类名:{}", className);

        //2.获取目标方法名
        String methodName = proceedingJoinPoint.getSignature().getName();
        log.info("目标方法名:{}", methodName);

        //3.获取目标方法运行时的传入参数
        Object[] args = proceedingJoinPoint.getArgs();
        log.info("目标方法运行时的传入参数:{}", Arrays.toString(args));

        //4.放行目标方法执行
        Object result = proceedingJoinPoint.proceed();

        //5.获取目标方法运行的返回值
        log.info("目标方法运行的返回值:{}",result);

        log.info("pjp...around.after");

        return result;
    }
}
