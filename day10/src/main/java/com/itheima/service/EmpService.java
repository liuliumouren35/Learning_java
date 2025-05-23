package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {
    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize,String name, Short gender,LocalDate begin,LocalDate end);
    

    /**
     * 批量删除
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 修改员工信息
     * @param emp
     */
    void update(Emp emp);
    
    /**
     * 根据ID查询员工
     * @param id 员工ID
     * @return 员工对象
     */
    Emp getById(Integer id);
}
