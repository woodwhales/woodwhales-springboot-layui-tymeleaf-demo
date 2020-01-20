package org.woodwhales.layui.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.woodwhales.layui.entity.Role;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface RoleRepository extends BaseMapper<Role> {
	
	@Select("select * from admin_role as r, admin_user_role as rl where rl.role_id = r.id and rl.user_id = #{userId}")
	List<Role> selectRoleListByUserId(Long userId);
	
	@Select("select * from admin_role as r, admin_user_role as rl where rl.role_id = r.id and rl.user_code = #{userCode}")
	List<Role> selectRoleListByUserCode(String userCode);
	
}
