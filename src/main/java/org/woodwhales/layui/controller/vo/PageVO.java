package org.woodwhales.layui.controller.vo;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.woodwhales.layui.service.dto.PageDTO;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PageVO<T> {
	
	private PageVO() {}
	
	private int code;
	
	private String msg;
	
	private long count;
	
	private long page;
	
	private List<T> data;
	
	public static <T> PageVO<T> build(PageDTO<T> pageDTO) {
		PageVO<T> pageVO = new PageVO<T>();
		pageVO.setCode(0)
				.setMsg(StringUtils.EMPTY)
				.setCount(pageDTO.getTotal())
				.setPage(pageDTO.getCurrent())
				.setData(pageDTO.getRecords());
		return pageVO;
	}
}
