package com.it.springbootwebsp.service;

import com.it.springbootwebsp.pojo.Dept;

import java.util.List;


public interface DeptService {

    public List<Dept> list();
    public void delete(Integer id) throws Exception;
    public void insert(Dept dept);
    public void update(Dept dept);
}
