package org.woodwhales.layui.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityVO {
	 private String value;
	 private String  name;
	 private boolean selected = false;
	 private boolean disabled = false;
}
