package org.woodwhales.layui.service.dto;

import java.util.Collections;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.baomidou.mybatisplus.core.metadata.IPage;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PageDTO<T> {

	private PageDTO() {}
	
	// 结果集
	private List<T> records;
	
	// 当前总记录数
	private long total;
	
	// 每页记录数
	private long pageSize;
	
	// 当前页
	private long current;
	
	public static <T, E> PageDTO<T> build(IPage<E> page, List<T> records) {
		PageDTO<T> pageDTO = new PageDTO<T>();
		pageDTO.setTotal(page.getTotal());
		pageDTO.setPageSize(page.getSize());
		pageDTO.setCurrent(page.getCurrent());
		pageDTO.setRecords(CollectionUtils.isEmpty(page.getRecords()) ? Collections.emptyList() : records);
		return pageDTO;
	}
	
}


