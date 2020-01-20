package org.woodwhales.layui.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("role_user")
public class RoleUser {
	@TableId(type = IdType.AUTO)
    private Long id;
	
	/**
     * 用户编号
     */
    private String userCode;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 角色类型：0-超级管理员，1-系统管理员，2-普通用户（默认值）
     */
    private Integer roleType;

    /**
     * 用户状态：0-未启用，1-启用，2-已注销
     */
    private Integer status;
}
