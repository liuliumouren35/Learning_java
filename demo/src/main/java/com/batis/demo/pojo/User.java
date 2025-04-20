package com.batis.demo.pojo;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private Integer id;
  private String name;
  private Short age;
  private Short gender;
  private String phone;
  
}
