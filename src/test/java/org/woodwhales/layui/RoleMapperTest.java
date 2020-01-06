package org.woodwhales.layui;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.woodwhales.layui.entity.RoleUser;
import org.woodwhales.layui.mapper.RoleUserMapper;

import java.util.List;

@SpringBootTest
public class RoleMapperTest {

	@Autowired
	private RoleUserMapper roleUserMapper;

	@Test
	void testQuery() {
		List<RoleUser> roleUsers = roleUserMapper.selectList(null);
		roleUsers.forEach(System.out::println);
	}
}
