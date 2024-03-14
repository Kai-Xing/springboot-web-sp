package com.it.springbootwebsp.service;

import com.it.springbootwebsp.pojo.Dept;

import java.util.List;


public interface DeptService {

    public List<Dept> list();
    public Integer delete(Integer id);
    public Integer insert(Dept dept);
    public Integer update(Dept dept);
}
