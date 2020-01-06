package org.woodwhales.layui.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoVO {
	
	private String name;
	private String mobile;
	private String email;
	private String roleTypeList;
	private String userId;
	private String errorMsg;
 	
}
