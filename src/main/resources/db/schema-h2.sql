DROP TABLE IF EXISTS `admin_user`;
DROP TABLE IF EXISTS `admin_role`;

CREATE TABLE `admin_user`
(
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `user_code` varchar(100) NOT NULL COMMENT '用户编号',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `mobile` varchar(12) NOT NULL DEFAULT '0' COMMENT '手机号',
  `email` varchar(100) NOT NULL COMMENT '邮箱',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '用户状态：0-停用，1-启用，2-已注销',
  `gmt_created` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_code` (`user_code`),
  UNIQUE KEY `email` (`email`)
);


CREATE TABLE `admin_role`
(
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色主键',
  `role_code` varchar(100) NOT NULL COMMENT '用户编号',
  `name` varchar(50) NOT NULL COMMENT '角色名称',
  `sort` tinyint(2) NOT NULL DEFAULT '1' COMMENT '排序序号',
  `description` varchar(300) NULL DEFAULT '' COMMENT '描述',
  `gmt_created` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_code` (`role_code`)
);

CREATE TABLE `admin_user_role`
(
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户角色表主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户表主键',
  `role_id` bigint(20) NOT NULL COMMENT '角色表主键',
  `gmt_created` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
);