package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {

    /**
     * 查询总记录数
     * @return
     */
    //@Select("select count(*) from emp")
    //public Long count();

    /**
     * 分页查询,获取列表数据
     * @param start
     * @param pageSize
     * @return
     */
    //@Select("select * from emp limit #{start},#{pageSize}")
    //public List<Emp> page(Integer start, Integer pageSize);

    /**
     * 员工信息查询
     * @return
     */
    //@Select("select * from emp")
    public List<Emp> list(String name, Short gender,LocalDate begin,LocalDate end);

    /**
     * 批量删除
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 更新员工信息
     * @param emp
     */
    void update(Emp emp);
    
    /**
     * 根据ID查询员工
     * @param id 员工ID
     * @return 员工对象
     */
    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    /**
     * 根据用户名查询员工
     * @param username 用户名
     * @return 员工对象
     */
    @Select("select * from emp where username = #{username}")
    Emp getByUsername(String username);
}
