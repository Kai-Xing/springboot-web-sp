package com.it.springbootwebsp.controller;

import com.it.springbootwebsp.pojo.Dept;
import com.it.springbootwebsp.pojo.Result;
import com.it.springbootwebsp.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    //private static Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    //    @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除部门:{}",id);
        Integer re = deptService.delete(id);
        return Result.success(re);
    }

    @PostMapping
    public Result insert(@RequestBody Dept dept){
        log.info("添加部门:{}",dept.toString());
        Integer re = deptService.insert(dept);
        return Result.success(re);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门信息:{}",dept.getId());
        Integer re = deptService.update(dept);
        return Result.success(re);
    }
}