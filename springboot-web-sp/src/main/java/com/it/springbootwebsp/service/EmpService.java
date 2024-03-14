package com.it.springbootwebsp.service;

import com.it.springbootwebsp.pojo.Emp;
import com.it.springbootwebsp.pojo.PageBean;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface EmpService {

    PageBean page(Integer page, Integer pageSize, String name, Integer gender, Integer job,
                  Integer deptId, LocalDateTime begin, LocalDateTime end);

    Integer delete(List<Integer> ids);

    Integer save(Emp emp);

    Emp getById(Integer id);

    Integer update(Emp emp);

    Emp login(Emp emp);
}
