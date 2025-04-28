package com.itheima.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
 
  @Autowired
  private DeptMapper deptMapper;

  @Override
  public List<Dept> list() {
    return deptMapper.list();
  }

}
