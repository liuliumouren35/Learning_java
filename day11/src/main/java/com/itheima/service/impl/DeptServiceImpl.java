package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    private EmpMapper empMapper;

    
    /**
     * 查询全部部门
     */
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }
    /**
     * 删除部门
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        deptMapper.deleteById(id);//删除部门
        empMapper.deleteEmpByDeptId(id);//删除部门下的员工
    }
    /**
     * 新增部门
     */
    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }
    /**
     * 根据部门id查询部门
     */
    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }
    /**
     * 更新部门
     */
    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
    /**
     * 根据部门id删除部门下的员工
     */
    @Override
    @Transactional
    public void deleteEmpByDeptId(Integer id) {
        empMapper.deleteEmpByDeptId(id);
    }
}
