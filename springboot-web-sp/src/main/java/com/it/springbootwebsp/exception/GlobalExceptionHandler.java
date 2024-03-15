package com.it.springbootwebsp.exception;

import com.it.springbootwebsp.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)//捕获所有异常
    public Result ex(Exception e){
        e.printStackTrace();
        return Result.error("操作失败");
    }
}
