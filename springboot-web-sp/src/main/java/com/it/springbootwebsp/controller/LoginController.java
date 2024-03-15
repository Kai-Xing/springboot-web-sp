package com.it.springbootwebsp.controller;


import com.it.springbootwebsp.pojo.Emp;
import com.it.springbootwebsp.pojo.Result;
import com.it.springbootwebsp.service.EmpService;
import com.it.springbootwebsp.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/*
* 登录接口*/

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工登录:{}", emp.toString());
        Emp e = empService.login(emp);

        //登录成功，生成并下发令牌
        if (e != null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("name", e.getName());
            claims.put("username", e.getUsername());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        //登录失败，返回错误信息
        return Result.error("用户名或密码错误");
    }
}
