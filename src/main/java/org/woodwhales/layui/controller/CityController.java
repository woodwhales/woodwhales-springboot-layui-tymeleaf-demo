package org.woodwhales.layui.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.woodwhales.layui.commons.RespResut;
import org.woodwhales.layui.controller.vo.CityVO;
import org.woodwhales.layui.model.City;

import com.google.common.collect.Lists;

@Controller
@RequestMapping("/city")
public class CityController {

	private static List<City> cityList = Lists.newArrayList();
	
	static {
		cityList.add(City.newInstance("01", "北京"));
		cityList.add(City.newInstance("02", "上海"));
		cityList.add(City.newInstance("03", "广州"));
		cityList.add(City.newInstance("04", "深圳"));
		cityList.add(City.newInstance("05", "成都"));
		cityList.add(City.newInstance("07", "重庆"));
		cityList.add(City.newInstance("08", "武汉"));
	}
	
	@ResponseBody
	@GetMapping("/listAll")
	public Object listAll() {
		
		List<CityVO> cityVOs = cityList.stream()
										.map(this::convertFor)
										.collect(Collectors.toList());
		
		return RespResut.success(cityVOs);
	}
	
	private CityVO convertFor(City city) {
		CityVO cityVO = new CityVO();
		cityVO.setName(city.getName());
		cityVO.setValue(city.getId());
		return cityVO;
	}
}
