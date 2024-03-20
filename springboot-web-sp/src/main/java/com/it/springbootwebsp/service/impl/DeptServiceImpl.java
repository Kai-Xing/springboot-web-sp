package com.it.springbootwebsp.service.impl;

import com.it.springbootwebsp.mapper.DeptMapper;
import com.it.springbootwebsp.mapper.EmpMapper;
import com.it.springbootwebsp.pojo.Dept;
import com.it.springbootwebsp.pojo.DeptLog;
import com.it.springbootwebsp.service.DeptLogService;
import com.it.springbootwebsp.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogService deptLogService;

    @Override
    public List<Dept> list(){
        return deptMapper.list();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) throws Exception{
        try {
            //根据部门id删除对应员工
            empMapper.deleteByDeptId(id);
            //根据id删除对应的部门
            deptMapper.delete(id);
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行删除部门操作：删除"+id+"号部门");
            deptLogService.insert(deptLog);
        }
    }

    @Override
    public void insert(Dept dept){
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);

        String name = dept.getName();
        DeptLog deptLog = new DeptLog();
        deptLog.setCreateTime(LocalDateTime.now());
        deptLog.setDescription("执行新增部门操作："+name);
        deptLogService.insert(deptLog);
    }

    @Override
    public void update(Dept dept){
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);

        String name = dept.getName();
        DeptLog deptLog = new DeptLog();
        deptLog.setCreateTime(LocalDateTime.now());
        deptLog.setDescription("执行修改部门操作："+name);
        deptLogService.insert(deptLog);
    }
}
