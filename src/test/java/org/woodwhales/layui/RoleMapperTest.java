package org.woodwhales.layui;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.woodwhales.layui.entity.User;
import org.woodwhales.layui.repository.UserRepository;

import java.util.List;

@SpringBootTest
public class RoleMapperTest {

	@Autowired
	private UserRepository roleUserMapper;

	@Test
	void testQuery() {
		List<User> roleUsers = roleUserMapper.selectList(null);
		roleUsers.forEach(System.out::println);
	}
}
