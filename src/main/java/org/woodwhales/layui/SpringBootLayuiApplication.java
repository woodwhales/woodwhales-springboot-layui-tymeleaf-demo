package org.woodwhales.layui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("org.woodwhales.layui.mapper.**")
@SpringBootApplication
public class SpringBootLayuiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLayuiApplication.class, args);
	}

}
