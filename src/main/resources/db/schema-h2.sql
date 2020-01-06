DROP TABLE IF EXISTS `role_user`;

CREATE TABLE `role_user`
(
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `user_code` varchar(100) NOT NULL COMMENT '用户编号',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `mobile` varchar(12) NOT NULL DEFAULT '0' COMMENT '手机号',
  `email` varchar(100) NOT NULL COMMENT '邮箱',
  `role_type` int(2) NOT NULL DEFAULT '2' COMMENT '角色类型：0-超级管理员，1-系统管理员，2-普通用户（默认值）',
  `status` int(2) NOT NULL DEFAULT '0' COMMENT '用户状态：0-停用，1-启用，2-已注销',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_code` (`user_code`),
  UNIQUE KEY `email` (`email`)
);