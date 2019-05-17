/*
 Navicat MySQL Data Transfer

 Source Server         : 192.168.1.73
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : 192.168.1.73:3306
 Source Schema         : boot-setting

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 17/05/2019 19:04:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ucas_bus_column
-- ----------------------------
DROP TABLE IF EXISTS `ucas_bus_column`;
CREATE TABLE `ucas_bus_column`  (
  `sid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `name_` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字段属性名称',
  `type_` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据类型',
  `length` int(11) NULL DEFAULT NULL COMMENT '属性长度',
  `decimal_` int(11) NULL DEFAULT NULL COMMENT '精度',
  `required` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否必填',
  `primary_` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否主键',
  `default_value` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '默认值',
  `comment_` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注释',
  `create_dt` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_dt` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `bus_table_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表id',
  `version` int(10) NULL DEFAULT NULL COMMENT '版本',
  `state` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `delete_flag` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标识',
  `code_` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据库字段名',
  `desc_` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ucas_bus_column
-- ----------------------------
INSERT INTO `ucas_bus_column` VALUES ('1128201087795462144', '案卷主键', 'varchar', 64, NULL, '2', '2', '1', '案卷主键', '2019-05-14 07:31:15', NULL, '2019-05-15 15:00:23', NULL, '1128247509081260032', 7, '1', '1', 'arch_sid', NULL);
INSERT INTO `ucas_bus_column` VALUES ('1128231035390263296', '工程主键', 'varchar', 64, NULL, '2', '2', '1', '工程主键', '2019-05-14 09:30:15', NULL, '2019-05-15 11:09:00', NULL, NULL, 7, '1', '2', 'eng_sid', NULL);

-- ----------------------------
-- Table structure for ucas_bus_column_validate
-- ----------------------------
DROP TABLE IF EXISTS `ucas_bus_column_validate`;
CREATE TABLE `ucas_bus_column_validate`  (
  `sid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_dt` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_dt` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(10) NULL DEFAULT NULL COMMENT '版本号',
  `delete_flag` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标识(1:未删除,2:已删除)',
  `state` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态(1:启用,2:禁用)',
  `validate_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字段验证名称',
  `validate_content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字段验证内容',
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ucas_bus_column_validate
-- ----------------------------
INSERT INTO `ucas_bus_column_validate` VALUES ('1127841750308618240', NULL, '2019-05-13 07:43:22', NULL, '2019-05-13 16:55:00', 3, '2', '1', '邮箱验证', '^([a-z0-9A-Z]+[-|\\\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-zA-Z]{2,}$');
INSERT INTO `ucas_bus_column_validate` VALUES ('1127861664335527936', NULL, '2019-05-13 09:02:30', NULL, '2019-05-13 18:33:24', 3, '2', '1', '身份验证', '(^\\\\d{18}$)|(^\\\\d{15}$)');
INSERT INTO `ucas_bus_column_validate` VALUES ('1127861819851931648', NULL, '2019-05-13 09:03:07', NULL, '2019-05-13 16:59:51', 2, '1', '1', '电话号码验证', '^((13[0-9])|(15[^4,\\\\D])|(17[0-9])|(18[0,5-9]))\\\\d{8}$');

-- ----------------------------
-- Table structure for ucas_bus_column_validate_relationship
-- ----------------------------
DROP TABLE IF EXISTS `ucas_bus_column_validate_relationship`;
CREATE TABLE `ucas_bus_column_validate_relationship`  (
  `sid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `column_sid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务字段ID',
  `column_validate_sid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务字段验证器ID',
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ucas_bus_column_widget
-- ----------------------------
DROP TABLE IF EXISTS `ucas_bus_column_widget`;
CREATE TABLE `ucas_bus_column_widget`  (
  `sid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `widget_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '控件名称',
  `widget_type` int(10) NULL DEFAULT NULL COMMENT '控件类型',
  `widget_value` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '控件值',
  `widget_sett` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '控件设置',
  `dict_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典编码',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_dt` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_dt` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(10) NULL DEFAULT NULL COMMENT '版本号',
  `delete_flag` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标识(1:未删除,2:已删除)',
  `state` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态(1:启用,2:禁用)',
  `value_source` int(10) NULL DEFAULT NULL COMMENT '值来源(1:本地，2：数据库)',
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ucas_bus_column_widget
-- ----------------------------
INSERT INTO `ucas_bus_column_widget` VALUES ('1128125994792648704', '单行文本', 1, '', '', '', NULL, '2019-05-14 02:32:51', NULL, NULL, 1, '1', '1', 1);
INSERT INTO `ucas_bus_column_widget` VALUES ('1128126323928072192', '多行文本', 1, '', '', '', NULL, '2019-05-14 02:34:10', NULL, NULL, 1, '1', '1', 1);
INSERT INTO `ucas_bus_column_widget` VALUES ('1128131456191823872', '下拉框', 1, '', 'width=200;height=120;', '1', NULL, '2019-05-14 02:54:33', NULL, '2019-05-14 12:08:31', 4, '1', '1', 2);
INSERT INTO `ucas_bus_column_widget` VALUES ('1128146951620132864', '复选框', 1, '{\'key\':\'value\'}', 'width=200;height=120;', '', NULL, '2019-05-14 03:56:08', NULL, '2019-05-14 12:05:55', 2, '1', '1', 1);

-- ----------------------------
-- Table structure for ucas_bus_column_widget_relationship
-- ----------------------------
DROP TABLE IF EXISTS `ucas_bus_column_widget_relationship`;
CREATE TABLE `ucas_bus_column_widget_relationship`  (
  `sid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `column_widget_sid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务字段控件ID',
  `column_sid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务字段ID',
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ucas_bus_data_source
-- ----------------------------
DROP TABLE IF EXISTS `ucas_bus_data_source`;
CREATE TABLE `ucas_bus_data_source`  (
  `sid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `name_` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `ip_` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主机IP',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `passwd` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `port_` int(11) NULL DEFAULT NULL COMMENT '端口',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_dt` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_dt` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `state` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `delete_flag` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标识',
  `version` int(11) NULL DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ucas_bus_data_source
-- ----------------------------
INSERT INTO `ucas_bus_data_source` VALUES ('1128513987386933248', '城建档案数据库', '192.168.1.74', 'root', '123456', 3306, NULL, '2019-05-15 04:14:36', NULL, '2019-05-15 12:15:48', '1', '1', 3);

-- ----------------------------
-- Table structure for ucas_bus_form_relation
-- ----------------------------
DROP TABLE IF EXISTS `ucas_bus_form_relation`;
CREATE TABLE `ucas_bus_form_relation`  (
  `sid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `bus_object_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务对象id',
  `bus_form_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务表单id',
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ucas_bus_form_relation
-- ----------------------------
INSERT INTO `ucas_bus_form_relation` VALUES ('1129312786040619008', '1128607216279093248', '1129305113568083968');

-- ----------------------------
-- Table structure for ucas_bus_object_relation
-- ----------------------------
DROP TABLE IF EXISTS `ucas_bus_object_relation`;
CREATE TABLE `ucas_bus_object_relation`  (
  `sid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `bus_object_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务对象id',
  `parent_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父类id',
  `path` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路径',
  `depath` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '深度',
  `rela_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关系类型:(1:一对一,2:一对多)',
  `table_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表类型(1:主表,2:从表)',
  `rela_text` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '关系字段文本',
  `bus_table_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务表id',
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ucas_bus_object_relation
-- ----------------------------
INSERT INTO `ucas_bus_object_relation` VALUES ('1129291104412368896', '1128607216279093248', NULL, '/erms_biz_arch_info', '1', '', '1', NULL, '1128247509081260032');
INSERT INTO `ucas_bus_object_relation` VALUES ('1129292411789508608', '1128607216279093248', '1129291104412368896', '/erms_biz_arch_info/erms_biz_arch_204', '2', '2', '2', NULL, '1129277126441304064');

-- ----------------------------
-- Table structure for ucas_bus_table
-- ----------------------------
DROP TABLE IF EXISTS `ucas_bus_table`;
CREATE TABLE `ucas_bus_table`  (
  `sid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `name_` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表名',
  `comment_` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_dt` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_dt` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `version` int(10) NULL DEFAULT NULL COMMENT '版本号',
  `state` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态(1:启用,2:禁用)',
  `delete_flag` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标识(1:未删除,2:已删除)',
  `code_` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表编码',
  `entity_` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '实体名称',
  `data_source_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据源ID',
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ucas_bus_table
-- ----------------------------
INSERT INTO `ucas_bus_table` VALUES ('1128247509081260032', '案卷表', '案卷实体对象', '2019-05-14 10:35:43', NULL, '2019-05-14 18:54:45', NULL, 4, '1', '2', 'erms_biz_arch_info', 'ArchInfo', NULL);
INSERT INTO `ucas_bus_table` VALUES ('1128253174663217152', '工程基础信息表', '工程基础信息表', '2019-05-14 10:58:13', NULL, NULL, NULL, 1, '1', '1', 'erms_biz_eng_base_info', 'EngBaseInfo', '1128513987386933248');
INSERT INTO `ucas_bus_table` VALUES ('1129277126441304064', '204科室', '204科室处理案卷', '2019-05-17 06:47:03', NULL, NULL, NULL, 1, '1', '1', 'erms_biz_arch_204', 'ArchInfo204', NULL);

-- ----------------------------
-- Table structure for ucase_bus_from
-- ----------------------------
DROP TABLE IF EXISTS `ucase_bus_from`;
CREATE TABLE `ucase_bus_from`  (
  `sid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `name_` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `alias` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '别名',
  `from_text` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '表单内容',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_dt` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_dt` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(10) NULL DEFAULT NULL COMMENT '版本号',
  `state` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `delete_flag` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标识',
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ucase_bus_from
-- ----------------------------
INSERT INTO `ucase_bus_from` VALUES ('1129305113568083968', '204科室表单', 'key_204', '', NULL, '2019-05-17 08:38:15', NULL, NULL, 1, '1', '1');

-- ----------------------------
-- Table structure for ucase_bus_object
-- ----------------------------
DROP TABLE IF EXISTS `ucase_bus_object`;
CREATE TABLE `ucase_bus_object`  (
  `sid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `key_` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '唯一值',
  `name_` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名字',
  `desc_` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_dt` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_dt` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `version` int(10) NULL DEFAULT NULL COMMENT '版本号',
  `state` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态(1:启用,2:禁用)',
  `delete_flag` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标识(1:未删除,已删除)',
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ucase_bus_object
-- ----------------------------
INSERT INTO `ucase_bus_object` VALUES ('1128607216279093248', 'zh_202', '202科室业务', '202科室业务', '2019-05-15 10:25:04', NULL, '2019-05-17 14:35:56', NULL, 3, '1', '2');
INSERT INTO `ucase_bus_object` VALUES ('1128825858522480640', 'zh_201', '201科室业务', '201科室业务', '2019-05-16 00:53:52', NULL, NULL, NULL, 1, '1', '1');

SET FOREIGN_KEY_CHECKS = 1;
