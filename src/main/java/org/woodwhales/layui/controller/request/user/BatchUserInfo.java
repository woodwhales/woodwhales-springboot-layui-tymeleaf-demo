package org.woodwhales.layui.controller.request.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchUserInfo {
	private String name;
	private String mobile;
	private String email;
	private String roleTypeList;
}
