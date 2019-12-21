package org.woodwhales.layui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class City {
	private String id;
	private String name;
	
	public static City newInstance(String id, String name) {
		return City.builder().id(id).name(name).build();
	}
}
