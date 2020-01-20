package org.woodwhales.layui.controller.request.user;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestParams {

	private String name;
	
	private long page = 1;
	
	private long limit = 10;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date startTime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date endTime;
	
}
