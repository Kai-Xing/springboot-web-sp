package com.it.springbootwebsp.mapper;

import com.it.springbootwebsp.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("select * from tb_dept")
    List<Dept> list();

    @Delete("delete from tb_dept where id = #{id}")
    Integer delete(Integer id);

    @Insert("insert into tb_dept(name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime})")
    Integer insert(Dept dept);

    Integer update(Dept dept);
}
