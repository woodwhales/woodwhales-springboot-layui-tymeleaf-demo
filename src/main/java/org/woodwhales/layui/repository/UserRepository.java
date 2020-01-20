package org.woodwhales.layui.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.woodwhales.layui.entity.User;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface UserRepository extends BaseMapper<User> {
	
	@Select("select * from admin_user as u, admin_user_role as rl where rl.role_id = r.id and rl.role_id = #{roleId}")
	List<User> selectUserListByRoleId(Long roleId);
	
	@Select("select * from admin_user as u, admin_user_role as rl where rl.role_id = r.id and rl.role_code = #{roleCode}")
	List<User> selectUserListByRoleCode(String roleCode);
	
}