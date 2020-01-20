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
@TableName("admin_role")
public class Role {

	@TableId(type = IdType.AUTO)
    private Long id;
	
	/**
     * 角色编号
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String name;
    
    /**
     * 排序序号
     */
    private Byte sort;
    
    /**
     * 描述
     */
    private String description;
    
    /**
     * 创建时间
     */
    private Date gmtCreated;
    
    /**
     *  更新时间
     */
    private Date gmtModified;

}
