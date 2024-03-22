package com.it.springbootwebsp.controller;

import com.it.springbootwebsp.anno.Log;
import com.it.springbootwebsp.pojo.Emp;
import com.it.springbootwebsp.pojo.PageBean;
import com.it.springbootwebsp.pojo.Result;
import com.it.springbootwebsp.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

//    @GetMapping
//    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize){
//        log.info("分页查询员工:{},{}",page, pageSize);
//        PageBean pageBean = empService.page(page, pageSize);
//        return Result.success(pageBean);
//    }

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Integer gender, Integer job, Integer deptId,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime end){
        log.info("分页查询员工:{},{},{},{},{},{},{},{}",page, pageSize, name, gender, job, deptId, begin, end);
        PageBean pageBean = empService.page(page, pageSize, name, gender, job, deptId, begin, end);
        return Result.success(pageBean);
    }

    @Log
    @DeleteMapping("{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除员工：{}",ids);
        Integer re = empService.delete(ids);
        return Result.success(re);
    }

    @Log
    @PostMapping
    public Result insert(@RequestBody Emp emp){
        log.info("新增员工:{}",emp.toString());
        Integer re = empService.insert(emp);
        return Result.success(re);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据id查询员工:{}",id);
        Emp re = empService.getById(id);
        return Result.success(re);
    }

    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("更新信息:{}",emp.toString());
        Integer re = empService.update(emp);
        return Result.success(re);
    }
}
