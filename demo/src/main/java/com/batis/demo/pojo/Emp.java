package com.batis.demo.pojo;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
  private Integer id;
  private String username;
  private String password;
  private String name;
  private Short gender;
  private String image;
  private Short job;
  private LocalDate entrydate;
  private Integer deptId;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;
  
  
}
