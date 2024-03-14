package com.it.springbootwebsp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;
    private String username;
    private Integer password;
    private String name;
    private Integer gender;
    private String image;
    private Integer job;
    private Integer deptId;
    private LocalDate entrydate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
