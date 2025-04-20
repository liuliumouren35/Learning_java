package com.batis.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.batis.demo.mapper.UserMapper;
import com.batis.demo.pojo.User;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testList() {
		List<User> users = userMapper.list();
		// 使用Stream流输出用户信息
		users.stream()
			.forEach(user -> System.out.println("用户ID: " + user.getId() + 
				", 姓名: " + user.getName() + 
				", 年龄: " + user.getAge() + 
				", 性别: " + user.getGender() + 
				", 电话: " + user.getPhone()));
		
		// 也可以使用更复杂的Stream操作，例如过滤和排序
		System.out.println("\n按年龄排序后的用户:");
		users.stream()
			.sorted((u1, u2) -> u1.getAge() - u2.getAge())
			.forEach(user -> System.out.println(user.getName() + " - " + user.getAge() + "岁"));
	}

}
