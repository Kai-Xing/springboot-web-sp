package com.it.springbootwebsp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.it.springbootwebsp.mapper.EmpMapper;
import com.it.springbootwebsp.pojo.Emp;
import com.it.springbootwebsp.pojo.PageBean;
import com.it.springbootwebsp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

//    @Override
//    public PageBean page(Integer page, Integer pageSize){
//        //获取总记录数
//        Long count = empMapper.count();
//        //获取分页查询结果列表
//        List<Emp> list = empMapper.page((page-1)*pageSize, pageSize);
//        //封装
//        PageBean pageBean = new PageBean(count, list);
//        return pageBean;
//    }

    @Override
    public PageBean page(Integer page, Integer pageSize,
                         String name, Integer gender, Integer job,
                         Integer deptId, LocalDateTime begin, LocalDateTime end){
        //设置分页参数
        PageHelper.startPage(page, pageSize);
        //执行查询
        List<Emp> empList = empMapper.list(name, gender, job, deptId, begin, end);
        Page<Emp> p = (Page<Emp>) empList;
        //封装
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public Integer delete(List<Integer> ids){
        return empMapper.delete(ids);
    }


    @Override
    public Integer insert(Emp emp){
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        return empMapper.insert(emp);
    }

    @Override
    public Emp getById(Integer id){
        return empMapper.getById(id);
    }

    @Override
    public Integer update(Emp emp){
        emp.setUpdateTime(LocalDateTime.now());
        return empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.getByUsernameAndPassword(emp);
    }


    @Override
    public Integer deleteByDeptId(Integer id){
        return empMapper.deleteByDeptId(id);
    }
}
