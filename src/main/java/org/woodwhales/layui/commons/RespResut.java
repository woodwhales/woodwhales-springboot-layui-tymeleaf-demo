package org.woodwhales.layui.commons;

import lombok.Data;

@Data
public class RespResut<T> {

	private Integer code;
	private String msg;
	private T data;
	
	public static <T> RespResut<T> success(T data) {
		RespResut<T> respResut = new RespResut<T>();
		respResut.setCode(0);
		respResut.setMsg("response successed");
		respResut.setData(data);
		return respResut;
	}
	
	public static <T> RespResut<T> error(Integer code, String msg) {
		RespResut<T> respResut = new RespResut<T>();
		respResut.setCode(code);
		respResut.setMsg(msg);
		respResut.setData(null);
		return respResut;
	}
	
	public static <T> RespResut<T> error(String msg) {
		RespResut<T> respResut = new RespResut<T>();
		respResut.setCode(-1);
		respResut.setMsg(msg);
		respResut.setData(null);
		return respResut;
	}
}
