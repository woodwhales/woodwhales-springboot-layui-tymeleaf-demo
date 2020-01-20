package org.woodwhales.layui.service.dto;

import java.util.Date;
import java.util.List;

import org.woodwhales.layui.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailDTO {

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
     * 角色
     */
    private List<Role> roles;
    
    /**
     * 用户状态：0-未启用，1-启用，2-已注销
     */
    private Byte status;
    
    /**
     * 创建时间
     */
    private Date gmtCreated;

    /**
     *  更新时间
     */
    private Date gmtModified;
}
