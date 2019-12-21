package org.woodwhales.layui.controller.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDetailVO {
	private String userId;
	private String name;
	private String mobile;
	private String email;
	private List<RoleTypeVO> roleTypeList;
}
