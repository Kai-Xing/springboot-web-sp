package com.it.springbootwebsp.mapper;

import com.it.springbootwebsp.pojo.DeptLog;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DeptLogMapper {

    @Insert("insert into dept_log(create_time, description) values (#{createTime}, #{description})")
    void insert(DeptLog deptLog);

}
