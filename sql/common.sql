create database goods_exchange;
grant all privileges on goods_exchange.* to 'web'@'%' identified by '654321';

flush privileges;

-- ----------------------------
-- 用户表
-- ----------------------------

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(64) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT 'MD5加密后密码',
  `imei` varchar(32) DEFAULT '' COMMENT '手机设备唯一标识码',
  `email` varchar(64) NOT NULL COMMENT '邮箱地址',
  `email_key` varchar(64) NOT NULL COMMENT '邮箱验证key',
  `is_verify` varchar(64) NOT NULL COMMENT '邮箱是否验证通过， 1-未验证，2-已验证',
  `account_type` tinyint(1) unsigned DEFAULT '0' COMMENT '账号类型1->网站账号 2->facebook 3->google',
  `thirdparty_account_key` varchar(64) NOT NULL COMMENT '第三方账号登陆key',
  `user_level` tinyint(1) unsigned DEFAULT '1' COMMENT '用户评价等级：1-一级，2-二级',
  `user_score` int(10) unsigned DEFAULT '0' COMMENT '用户评价积分',
  `user_level_name` varchar(64) NOT NULL COMMENT '用户等级名字',
  `state` tinyint(1) unsigned DEFAULT '0' COMMENT '用户状态 0->正常 1->被封',
  `is_admin` tinyint(1) unsigned DEFAULT '2' COMMENT '是否管理员 1->是 2->不是',
  `del_flag` tinyint(1) unsigned DEFAULT '0' COMMENT '删除标记 0->正常 1->删除',
  `updated_at` int(10) unsigned DEFAULT '0' COMMENT '更新时间',
  `created_at` int(10) unsigned DEFAULT '0' COMMENT '时间',
  PRIMARY KEY (`id`),
  KEY `users_imei` (`imei`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户表';


-- ----------------------------
-- 用户日志表
-- ----------------------------

DROP TABLE IF EXISTS `user_log`;
CREATE TABLE `user_log` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` int(10) unsigned DEFAULT '0' COMMENT '用户id',
  `type` char(1) DEFAULT '0' COMMENT '类型0-后台.1-app',
  `created_at` int(10) unsigned DEFAULT '0' COMMENT '时间',
  `remote_addr` varchar(255) DEFAULT NULL COMMENT 'ip地址',
  `request_uri` varchar(255) DEFAULT NULL COMMENT '请求的url',
  `method` varchar(5) DEFAULT NULL COMMENT 'get还是post请求',
  `params` text COMMENT '请求时候的参数',
  `exception` text COMMENT '如果有异常，对应的异常信息',
  PRIMARY KEY (`id`),
  KEY `user_log_user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户日志表';


-- ----------------------------
-- 分类表categories
-- ----------------------------

DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '中文名字',
  `ename` varchar(20) DEFAULT NULL COMMENT '英文名称',
  `category_id` int(10) unsigned DEFAULT '0' COMMENT '分类id',
  `ename_path` varchar(100) DEFAULT NULL COMMENT '层级路径',
  `level` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '等级',
  `ordinal` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '排序字段',
  `disable_state` tinyint(4) NOT NULL COMMENT '启用状态：0->默认启用，1->禁用',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '默认0，删除1',
  `updated_at` int(10) DEFAULT NULL COMMENT '更新时间',
  `created_at` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- 关键字表attribute
-- ----------------------------

DROP TABLE IF EXISTS `attribute`;
CREATE TABLE `attribute` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `category_id` int(10) unsigned DEFAULT '0' COMMENT '分类id',
  `name` varchar(20) NOT NULL DEFAULT '属性名字',
  `attribute_type` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '属性类型 0-系统， 1-用户添加',
  `attribute_number` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '属性次数 用户添加这个属性次数',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '默认0，删除1',
  `updated_at` int(10) DEFAULT NULL DEFAULT '0' COMMENT '更新时间',
  `created_at` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- 需求表requirements
-- ----------------------------

DROP TABLE IF EXISTS `requirements`;
CREATE TABLE `requirements` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned DEFAULT '0' COMMENT '用户id',
  `category_id` int(10) unsigned DEFAULT '0' COMMENT '分类id',
  `description` varchar(128) NOT NULL DEFAULT '' COMMENT '描述',
  `attributes` varchar(128) NOT NULL DEFAULT '' COMMENT '属性，格式为：属性id:属性值id;属性id:属性值id',
  `pics` varchar(64) NOT NULL COMMENT '需求图片，以逗号分割',
  `urls` varchar(64) NOT NULL COMMENT '需求url，以逗号分割',
  `state` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '需求状态 0-下线状态，1-上线状态，2-锁定状态',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '默认0，删除1',
  `updated_at` int(10) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `created_at` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- 物品表goods
-- ----------------------------

DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned DEFAULT '0' COMMENT '用户id',
  `category_id` int(10) unsigned DEFAULT '0' COMMENT '分类id',
  `description` varchar(128) NOT NULL DEFAULT '' COMMENT '描述',
  `attributes` varchar(128) NOT NULL DEFAULT '' COMMENT '属性，格式为：属性id:属性值id;属性id:属性值id',
  `pics` varchar(64) NOT NULL COMMENT '需求图片，以逗号分割',
  `urls` varchar(64) NOT NULL COMMENT '需求url，以逗号分割',
  `numbers` int(10) unsigned DEFAULT '0' COMMENT '物品数量',
  `state` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '物品状态 0-下线状态，1-上线状态, 2-锁定状态',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '默认0，删除1',
  `updated_at` int(10) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `created_at` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- 需求物品表
-- ----------------------------

DROP TABLE IF EXISTS `requirements_goods`;
CREATE TABLE `requirements_goods` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned DEFAULT '0' COMMENT '用户id',
  `requirement_id` int(10) unsigned DEFAULT '0' COMMENT '需求id',
  `goods_id` int(10) unsigned DEFAULT '0' COMMENT '物品id',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '默认0，删除1',
  `updated_at` int(10) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `created_at` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- message 消息表
-- ----------------------------

DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `send_user_id` int(10) unsigned DEFAULT '0' COMMENT '发送私信用户id',
  `send_user_name` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '发送私信用户名字',
  `receive_user_id` int(10) unsigned DEFAULT '0' COMMENT '接收私信用户id',
  `receive_user_name` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '接收私信用户名字',
  `content` varchar(128) NOT NULL DEFAULT '' COMMENT '消息内容',
  `type` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '消息类型 0 -用户发送私信，1-系统发送通知',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '默认0，删除1',
  `updated_at` int(10) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `created_at` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- 配对表
-- ----------------------------

DROP TABLE IF EXISTS `match`;
CREATE TABLE `match` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `requirement_id` int(10) unsigned DEFAULT '0' COMMENT '需求id',
  `requirement_user_id` int(10) unsigned DEFAULT '0' COMMENT '需求对应用户id',
  `goods_id` int(10) unsigned DEFAULT '0' COMMENT '物品id',
  `goods_user_id` int(10) unsigned DEFAULT '0' COMMENT '物品对应用户id',
  `type` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '配对类型 0-单方面配对成功 1-双方面配对成功',
  `match_id` int(10) unsigned DEFAULT '0' COMMENT '双方面配对成功的时候对应配对id',
  `state` tinyint(1) unsigned DEFAULT '0' COMMENT '状态 0-匹配成功 1-锁定',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '默认0，删除1',
  `updated_at` int(10) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `created_at` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- 交换表 当双方都申请锁定过后插入这个表
-- ----------------------------

DROP TABLE IF EXISTS `exchange`;
CREATE TABLE `exchange` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `match_id` int(10) unsigned DEFAULT '0' COMMENT '配对id',
  `match_user_id` int(10) unsigned DEFAULT '0' COMMENT '配对对应用户id',
  `matched_id` int(10) unsigned DEFAULT '0' COMMENT '配对id',
  `matched_user_id` int(10) unsigned DEFAULT '0' COMMENT '配对对应用户id',
  `state` tinyint(1) unsigned DEFAULT '0' COMMENT '状态 0-单方面锁定， 1-双方面锁定',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '默认0，删除1',
  `updated_at` int(10) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `created_at` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- evaluate 评价记录表
-- ----------------------------

DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned DEFAULT '0' COMMENT '评价用户id',
  `goods_id` int(10) unsigned DEFAULT '0' COMMENT '对应商品id',
  `exchange_id` int(10) unsigned DEFAULT '0' COMMENT '对应的交换id',
  `content` varchar(128) NOT NULL DEFAULT '' COMMENT '评价内容',
  `type` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '评价类型 0-好评 1-中评 2-差评',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '默认0，删除1',
  `updated_at` int(10) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `created_at` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- evaluate 评价上述表
-- ----------------------------

DROP TABLE IF EXISTS `evaluate_above`;
CREATE TABLE `evaluate_above` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned DEFAULT '0' COMMENT '分发用户id',
  `evaluate_id` int(10) unsigned DEFAULT '0' COMMENT '评价id',
  `content` varchar(128) NOT NULL DEFAULT '' COMMENT '留言内容',
  `state` tinyint(1) unsigned DEFAULT '0' COMMENT '上述状态 0-上述成功， 1-驳回上述',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '默认0，删除1',
  `updated_at` int(10) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `created_at` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- inform 举报表
-- ----------------------------

DROP TABLE IF EXISTS `inform`;
CREATE TABLE `inform` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned DEFAULT '0' COMMENT '举报用户id',
  `goods_id` int(10) unsigned DEFAULT '0' COMMENT '物品id',
  `informed_user_id` int(10) unsigned DEFAULT '0' COMMENT '被举报物品对应的用户id',
  `content` varchar(128) NOT NULL DEFAULT '' COMMENT '举报内容',
  `type` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '举报类型 0-物品与描述不符 1-虚假欺诈信息',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '默认0，删除1',
  `updated_at` int(10) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `created_at` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



