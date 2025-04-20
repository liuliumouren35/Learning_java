package com.batis.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import com.batis.demo.pojo.User;

@Mapper//在启动类上添加@MapperScan("com.batis.demo.mapper")注解
public interface UserMapper {
  //查询全部的用户信息
  @Select("SELECT * FROM user")
  public List<User> list();
}
