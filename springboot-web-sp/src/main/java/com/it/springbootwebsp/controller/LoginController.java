package com.it.springbootwebsp.controller;


import com.it.springbootwebsp.pojo.Emp;
import com.it.springbootwebsp.pojo.Result;
import com.it.springbootwebsp.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
* 登录接口*/

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工登录{}", emp.toString());
        Emp e = empService.login(emp);
        return e != null?Result.success():Result.error("用户名或密码错误");
    }
}
