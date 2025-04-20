package com.batis.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import com.batis.demo.pojo.Emp;
import com.batis.demo.mapper.EmpMapper;
import java.time.LocalDateTime;


@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private EmpMapper empMapper;

	@Test
	public void testDeleteById() {
		int result = empMapper.deleteById(16);
		System.out.println("删除结果: " + result);
	}

	@Test
	public void testInsert() {
		Emp emp = new Emp();
		emp.setUsername("test3");
		emp.setName("测试3");
		emp.setGender((short) 1);
		emp.setImage("test3.jpg");
		emp.setJob((short) 1);
		emp.setEntrydate(LocalDate.now());
		emp.setDeptId(1);
		emp.setCreateTime(LocalDateTime.now());
		emp.setUpdateTime(LocalDateTime.now());
		empMapper.insert(emp);
		System.out.println("插入结果: " + emp);
		System.out.println("插入结果: " + emp.getId());
		
	}

}
