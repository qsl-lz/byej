/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : service_js_20220218_3927

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2022-03-02 16:24:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for app_menu
-- ----------------------------
DROP TABLE IF EXISTS `app_menu`;
CREATE TABLE `app_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(20) DEFAULT NULL COMMENT '菜单名称',
  `href` varchar(255) DEFAULT NULL COMMENT '路由地址',
  `create_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(255) DEFAULT NULL COMMENT '更新时间',
  `roil_id` varchar(255) DEFAULT NULL COMMENT '角色集',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=234 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of app_menu
-- ----------------------------
INSERT INTO `app_menu` VALUES ('217', '房间管理', 'login_href/idx_app_fang_jian', '2022-01-10 21:21:35', '2022-01-10 21:21:35', '');
INSERT INTO `app_menu` VALUES ('218', '留言管理', 'login_href/idx_app_liu_yan', '2022-01-10 21:21:35', '2022-01-10 21:21:35', '');
INSERT INTO `app_menu` VALUES ('219', '菜单管理', 'login_href/idx_app_menu', '2022-01-10 21:21:35', '2022-01-10 21:21:35', '');
INSERT INTO `app_menu` VALUES ('220', '民宿管理', 'login_href/idx_app_min_su', '2022-01-10 21:21:35', '2022-01-10 21:21:35', '');
INSERT INTO `app_menu` VALUES ('221', '订单管理', 'login_href/idx_app_order', '2022-01-10 21:21:35', '2022-01-10 21:21:35', '');
INSERT INTO `app_menu` VALUES ('222', '体温管理', 'login_href/idx_app_ti_wen', '2022-01-10 21:21:35', '2022-01-10 21:21:35', '');
INSERT INTO `app_menu` VALUES ('223', '用户管理', 'login_href/idx_app_user', '2022-01-10 21:21:35', '2022-01-10 21:21:35', '');
INSERT INTO `app_menu` VALUES ('224', '行程管理', 'login_href/idx_app_xing_cheng', '2022-01-10 21:21:35', '2022-01-10 21:21:35', '');
INSERT INTO `app_menu` VALUES ('225', '', 'login_href/idx_sys_user', '2022-01-10 21:21:35', '2022-01-10 21:21:35', '');
INSERT INTO `app_menu` VALUES ('226', '菜单管理', 'login_href/idx_app_menu', '2022-03-02 11:41:00', '2022-03-02 11:41:00', '');
INSERT INTO `app_menu` VALUES ('227', '体温管理', 'login_href/idx_app_ti_wen', '2022-03-02 11:41:00', '2022-03-02 11:41:00', '');
INSERT INTO `app_menu` VALUES ('228', '用户管理', 'login_href/idx_app_user', '2022-03-02 11:41:00', '2022-03-02 11:41:00', '');
INSERT INTO `app_menu` VALUES ('229', '行程管理', 'login_href/idx_app_xing_cheng', '2022-03-02 11:41:00', '2022-03-02 11:41:00', '');
INSERT INTO `app_menu` VALUES ('230', '紧急通知', 'login_href/idx_notice_manage', '2022-03-02 11:41:00', '2022-03-02 11:41:00', '');
INSERT INTO `app_menu` VALUES ('231', '地图数据管理', 'login_href/idx_province_num_manage', '2022-03-02 11:41:00', '2022-03-02 11:41:00', '');
INSERT INTO `app_menu` VALUES ('232', '景区区域管理', 'login_href/idx_region_manage', '2022-03-02 11:41:00', '2022-03-02 11:41:00', '');
INSERT INTO `app_menu` VALUES ('233', '', 'login_href/idx_sys_user', '2022-03-02 11:41:00', '2022-03-02 11:41:00', '');

-- ----------------------------
-- Table structure for app_ti_wen
-- ----------------------------
DROP TABLE IF EXISTS `app_ti_wen`;
CREATE TABLE `app_ti_wen` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `u_id` varchar(255) DEFAULT NULL COMMENT '用户id',
  `tw_name` varchar(255) DEFAULT NULL COMMENT '体温',
  `tw_time` varchar(255) DEFAULT NULL COMMENT '体温添加时间',
  `tw_note` varchar(255) DEFAULT NULL COMMENT '体温备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='体温管理';

-- ----------------------------
-- Records of app_ti_wen
-- ----------------------------
INSERT INTO `app_ti_wen` VALUES ('1', '3', '35.5', '2022-1-11 17:36:19', '阿斯顿发送到');
INSERT INTO `app_ti_wen` VALUES ('2', '4', '37.5', '2022-01-11 22:48:02', '运动过后');
INSERT INTO `app_ti_wen` VALUES ('3', '4', '36.5', '2022-01-11 22:58:04', '阿斯顿发水电费');
INSERT INTO `app_ti_wen` VALUES ('4', '4', '37', '2022-01-11 22:58:10', null);
INSERT INTO `app_ti_wen` VALUES ('5', '5', '36.8', '2022-01-11 23:22:19', null);
INSERT INTO `app_ti_wen` VALUES ('6', '3', '36.7', '2022-03-02 14:07:33', '正常');
INSERT INTO `app_ti_wen` VALUES ('7', '3', '36.8', '2022-03-02 16:23:56', '正常');

-- ----------------------------
-- Table structure for app_user
-- ----------------------------
DROP TABLE IF EXISTS `app_user`;
CREATE TABLE `app_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(255) DEFAULT NULL COMMENT '账号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `signature` varchar(255) DEFAULT NULL COMMENT '个性签名',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `is_yc` int(2) DEFAULT NULL COMMENT '是否异常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户管理';

-- ----------------------------
-- Records of app_user
-- ----------------------------
INSERT INTO `app_user` VALUES ('1', '999', '1', '啊哈哈哈', '2', null, null, '2');
INSERT INTO `app_user` VALUES ('2', 'qqq', '1', '测试账号', '1', null, null, '1');
INSERT INTO `app_user` VALUES ('3', 'cs1', '1', '张老师', '1', '啥地方沙发', '12345678910', '2');
INSERT INTO `app_user` VALUES ('4', 'cs2', '1', '李大哥', '1', '这是我第一个签名', '12345678910', null);
INSERT INTO `app_user` VALUES ('5', '12345678910', '1', '握手大哥', '1', '这是一个个星期那么', '12345678910', '1');
INSERT INTO `app_user` VALUES ('6', 'cs55', '1', '张三', null, null, null, null);

-- ----------------------------
-- Table structure for app_xing_cheng
-- ----------------------------
DROP TABLE IF EXISTS `app_xing_cheng`;
CREATE TABLE `app_xing_cheng` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `u_id` varchar(255) DEFAULT NULL COMMENT '用户id',
  `xc_name` varchar(255) DEFAULT NULL COMMENT '行程地名',
  `xing_cheng_time` varchar(255) DEFAULT NULL COMMENT '行程时间',
  `is_yc` int(2) DEFAULT NULL,
  `create_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='行程管理';

-- ----------------------------
-- Records of app_xing_cheng
-- ----------------------------
INSERT INTO `app_xing_cheng` VALUES ('1', '3', '南充', '2022-01-11', null, null);
INSERT INTO `app_xing_cheng` VALUES ('2', '4', '南京', '2022-01-12', null, null);
INSERT INTO `app_xing_cheng` VALUES ('3', '4', '阿斯顿发', '2022-01-12', null, null);
INSERT INTO `app_xing_cheng` VALUES ('4', '5', '南京', '2022-01-12', null, null);
INSERT INTO `app_xing_cheng` VALUES ('5', '3', '贵州', '2022-03-17', null, null);
INSERT INTO `app_xing_cheng` VALUES ('6', '3', '北京-谷阳', '2022-02-28', null, null);

-- ----------------------------
-- Table structure for notice_manage
-- ----------------------------
DROP TABLE IF EXISTS `notice_manage`;
CREATE TABLE `notice_manage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='紧急通知';

-- ----------------------------
-- Records of notice_manage
-- ----------------------------
INSERT INTO `notice_manage` VALUES ('1', '因疫情原因，暂停开放', '因国内疫情原因，本景区暂停开放', '2022-03-02 13:40:20');
INSERT INTO `notice_manage` VALUES ('2', '紧急封园的通知', '因为在观月楼发现一例确诊病例，请大家暂时到广场集合，参加核酸检验', '2022-03-02 14:55:23');
INSERT INTO `notice_manage` VALUES ('3', '紧急通知', '因特殊原因，马上关闭玻璃栈道，进行维修', '2022-03-02 16:22:35');

-- ----------------------------
-- Table structure for province_num_manage
-- ----------------------------
DROP TABLE IF EXISTS `province_num_manage`;
CREATE TABLE `province_num_manage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(10) DEFAULT NULL COMMENT '省份',
  `value` int(10) DEFAULT NULL COMMENT '人数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='地图数据管理';

-- ----------------------------
-- Records of province_num_manage
-- ----------------------------
INSERT INTO `province_num_manage` VALUES ('1', '北京', '100');
INSERT INTO `province_num_manage` VALUES ('2', '天津', '123');
INSERT INTO `province_num_manage` VALUES ('3', '上海', '452');
INSERT INTO `province_num_manage` VALUES ('4', '重庆', '242');
INSERT INTO `province_num_manage` VALUES ('5', '河北', '124');
INSERT INTO `province_num_manage` VALUES ('6', '河南', '234');
INSERT INTO `province_num_manage` VALUES ('7', '云南', '234');
INSERT INTO `province_num_manage` VALUES ('8', '辽宁', '467');
INSERT INTO `province_num_manage` VALUES ('9', '黑龙江', '623');
INSERT INTO `province_num_manage` VALUES ('10', '湖南', '23');
INSERT INTO `province_num_manage` VALUES ('11', '安徽', '345');
INSERT INTO `province_num_manage` VALUES ('12', '山东', '456');
INSERT INTO `province_num_manage` VALUES ('13', '新疆', '452');
INSERT INTO `province_num_manage` VALUES ('14', '江苏', '523');
INSERT INTO `province_num_manage` VALUES ('15', '浙江', '234');
INSERT INTO `province_num_manage` VALUES ('16', '江西', '453');
INSERT INTO `province_num_manage` VALUES ('17', '湖北', '325');
INSERT INTO `province_num_manage` VALUES ('18', '广西', '856');
INSERT INTO `province_num_manage` VALUES ('19', '甘肃', '450');
INSERT INTO `province_num_manage` VALUES ('20', '山西', '343');
INSERT INTO `province_num_manage` VALUES ('21', '内蒙古', '66');
INSERT INTO `province_num_manage` VALUES ('22', '陕西', '345');
INSERT INTO `province_num_manage` VALUES ('23', '吉林', '234');
INSERT INTO `province_num_manage` VALUES ('24', '福建', '25');
INSERT INTO `province_num_manage` VALUES ('25', '贵州', '57');
INSERT INTO `province_num_manage` VALUES ('26', '广东', '35');
INSERT INTO `province_num_manage` VALUES ('27', '青海', '62');
INSERT INTO `province_num_manage` VALUES ('28', '西藏', '783');
INSERT INTO `province_num_manage` VALUES ('29', '四川', '23');
INSERT INTO `province_num_manage` VALUES ('30', '宁夏', '546');
INSERT INTO `province_num_manage` VALUES ('31', '海南', '346');
INSERT INTO `province_num_manage` VALUES ('32', '台湾', '456');
INSERT INTO `province_num_manage` VALUES ('33', '香港', '87');
INSERT INTO `province_num_manage` VALUES ('34', '澳门', '456');

-- ----------------------------
-- Table structure for region_manage
-- ----------------------------
DROP TABLE IF EXISTS `region_manage`;
CREATE TABLE `region_manage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '区域名称',
  `a_status` int(2) DEFAULT NULL COMMENT '状态（1正常2维修3封闭）',
  `a_num` int(10) DEFAULT NULL COMMENT '游客数量',
  `yc_num` int(10) DEFAULT NULL COMMENT '异常游客数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='景区区域管理';

-- ----------------------------
-- Records of region_manage
-- ----------------------------
INSERT INTO `region_manage` VALUES ('1', '广场', '1', '6500', '0');
INSERT INTO `region_manage` VALUES ('2', '观月楼', '1', '0', '0');
INSERT INTO `region_manage` VALUES ('3', '动物园', '1', '1250', '2');
INSERT INTO `region_manage` VALUES ('4', '展览厅', '1', '5201', '0');
INSERT INTO `region_manage` VALUES ('5', '玻璃栈道', '1', '5620', '6');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统ID',
  `USERNAME` varchar(50) NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(50) NOT NULL COMMENT '密码',
  `NAME` varchar(50) DEFAULT NULL COMMENT '昵称',
  `role_id` int(11) NOT NULL COMMENT '角色',
  `create_time` varchar(20) NOT NULL COMMENT '建立时间',
  `update_time` varchar(20) DEFAULT NULL COMMENT '更新时间',
  `signature` varchar(255) DEFAULT NULL COMMENT '签名',
  `student_number` varchar(50) DEFAULT NULL COMMENT '学号',
  `sex` int(2) DEFAULT NULL COMMENT '性别',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '1', '测试', '3', '', '2020-02-21 17:05:59', null, null, null, null);
INSERT INTO `sys_user` VALUES ('34', '2', '2', '张三', '1', '2021-04-09 14:23:51', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('35', '3', '3', '李四', '2', '2021-04-09 14:59:56', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('36', 'test', '1', '奥斯卡鲁大师', '3', '2022-01-11 17:40:26', null, '啥登录卡和静安寺烤肉饭说的', null, null, null);
INSERT INTO `sys_user` VALUES ('38', 'cs56', '1', '测试', '3', '2022-03-02 16:23:11', null, null, null, null, null);
