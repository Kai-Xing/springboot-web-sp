package com.it.springbootwebsp.controller;

import com.it.springbootwebsp.anno.Log;
import com.it.springbootwebsp.pojo.Dept;
import com.it.springbootwebsp.pojo.Result;
import com.it.springbootwebsp.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Scope("prototype")
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

    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) throws Exception {
        log.info("删除部门:{}",id);
        deptService.delete(id);
        return Result.success();
    }

    @Log
    @PostMapping
    public Result insert(@RequestBody Dept dept){
        log.info("添加部门:{}",dept.toString());
        deptService.insert(dept);
        return Result.success();
    }

    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门信息:{}",dept.getId());
        deptService.update(dept);
        return Result.success();
    }
}
