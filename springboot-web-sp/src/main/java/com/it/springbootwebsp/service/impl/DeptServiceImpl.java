package com.it.springbootwebsp.service.impl;

import com.it.springbootwebsp.mapper.DeptMapper;
import com.it.springbootwebsp.pojo.Dept;
import com.it.springbootwebsp.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list(){
        return deptMapper.list();
    }

    @Override
    public Integer delete(Integer id){
        return deptMapper.delete(id);
    }

    @Override
    public Integer insert(Dept dept){
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        return deptMapper.insert(dept);
    }

    @Override
    public Integer update(Dept dept){
        dept.setUpdateTime(LocalDateTime.now());
        return deptMapper.update(dept);
    }
}
