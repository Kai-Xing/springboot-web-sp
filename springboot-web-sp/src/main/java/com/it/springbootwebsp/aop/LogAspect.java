package com.it.springbootwebsp.aop;

import com.alibaba.fastjson.JSONObject;
import com.it.springbootwebsp.mapper.OperateLogMapper;
import com.it.springbootwebsp.pojo.OperateLog;
import com.it.springbootwebsp.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Around("@annotation(com.it.springbootwebsp.anno.Log)")
    public Object recordLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        //操作人ID --> 获取请求头中jwt令牌中的信息
        String jwt = httpServletRequest.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);
        Integer operateUser = (Integer) claims.get("id");

        //操作时间
        LocalDateTime operateTime = LocalDateTime.now();

        //操作类名
        String className = proceedingJoinPoint.getTarget().getClass().getName();

        //操作方法名
        String methodName = proceedingJoinPoint.getSignature().getName();

        //操作方法传入参数
        Object args[] = proceedingJoinPoint.getArgs();
        String methodParams = Arrays.toString(args);

        //调用原始目标方法运行
        Long begin = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();


        //操作方法返回值
        String returnValue = JSONObject.toJSONString(result);

        //执行操作方法耗时
        Long end = System.currentTimeMillis();
        Long costTime = end - begin;

        //记录操作日志
        OperateLog operateLog = new OperateLog(null, operateUser, operateTime, className, methodName, methodParams, returnValue, costTime);
        operateLogMapper.insert(operateLog);

        log.info("AOP记录操作日志:{}", operateLog.toString());
        return result;

    }

}
