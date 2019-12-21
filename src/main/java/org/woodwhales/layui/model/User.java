package org.woodwhales.layui.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private String name;
	private String mobile;
	private String email;
	private String status;
	private List<City> cityList;
	
}
