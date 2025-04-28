package com.itheima.service;

import java.util.List;

import com.itheima.pojo.Dept;

/**
 * 部门管理
 */
public interface DeptService {
  //查询全部部门数据
  List <Dept> list();
}
