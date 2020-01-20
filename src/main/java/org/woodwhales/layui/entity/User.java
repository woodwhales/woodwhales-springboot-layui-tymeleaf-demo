package org.woodwhales.layui.entity;

import java.util.Date;

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
@TableName("admin_user")
public class User {
	
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
