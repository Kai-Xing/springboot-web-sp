package com.it.springbootwebsp.mapper;

import com.it.springbootwebsp.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EmpMapper {
//    //查询总记录数
//    @Select("select count(*) from emp")
//    public Long count();
//
//    @Select("select * from emp limit #{start}, #{pageSize}")
//    public List<Emp> page(Integer start, Integer pageSize);

    //员工信息查询
    public List<Emp> list(String name, Integer gender, Integer job, Integer deptId, LocalDateTime begin, LocalDateTime end);

    //批量删除员工
    public Integer delete(List<Integer> ids);

    //新增员工
    @Insert("insert into emp(username, name, gender, job, dept_id, entrydate, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{job}, #{deptId}, #{entrydate}, #{createTime}, #{updateTime})")
    public Integer insert(Emp emp);

    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    Integer update(Emp emp);

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);

    //根据部门id删除部门下员工数据
    @Delete("delete from emp where dept_id = #{id}")
    Integer deleteByDeptId(Integer id);

}
