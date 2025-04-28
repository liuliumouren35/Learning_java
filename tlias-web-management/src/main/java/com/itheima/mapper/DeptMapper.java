package com.itheima.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import com.itheima.pojo.Dept;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {

  @Select("select * from dept")
  List<Dept> list(); 

}
