package com.batis.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import com.batis.demo.pojo.Emp;



@Mapper
public interface EmpMapper {

  //根据ID删除数据
  @Delete("DELETE FROM emp WHERE id = #{id}")
   public int  deleteById(Integer id);

   //插入数据
   @Options(useGeneratedKeys = true, keyProperty = "id")
   @Insert("INSERT INTO emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) VALUES (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
   public void  insert(Emp emp);

   //更新数据
   @Options(useGeneratedKeys = true, keyProperty = "id")
   @Update("UPDATE emp SET username = #{username}, name = #{name}, gender = #{gender}, image = #{image}, job = #{job}, entrydate = #{entrydate}, dept_id = #{deptId}, create_time = #{createTime}, update_time = #{updateTime} WHERE id = #{id}")
   public void update(Emp emp); 
  
}
