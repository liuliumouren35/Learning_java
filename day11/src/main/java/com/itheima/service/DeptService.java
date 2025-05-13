package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {
    /**
     * 查询全部部门数据
     * @return
     */
    List<Dept> list();

    /**
     * 删除部门
     * @param id
     */
    void delete(Integer id);

    /**
     * 新增部门
     * @param dept
     */
    void add(Dept dept);

    /**
     * 根据部门id查询部门
     * @param id
     * @return
     */
    Dept getById(Integer id);

    /**
     * 更新部门
     * @param dept
     */
    void update(Dept dept);

    /*
     * 根据部门删除部门下的员工
     * @param id
     */
    void deleteEmpByDeptId(Integer id);
    
    
}
