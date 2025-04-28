package com.itheima.controller;

import com.itheima.pojo.Result;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;

/**
 * 部门管理Controller
 */
@Slf4j
@RestController
public class DeptController {

  @Autowired
  private DeptService deptService;
  
  //查询部门列表
  @GetMapping("/depts")
  public Result list(){
    log.info("查询全部部门数据");
    //调用service查询部门列表
    List<Dept> depts = deptService.list();
    return Result.success(depts);
  }
}
