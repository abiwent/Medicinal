/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : medicinal

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 18/12/2019 11:33:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for m_input
-- ----------------------------
DROP TABLE IF EXISTS `m_input`;
CREATE TABLE `m_input`  (
  `iuuid` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '入库单号',
  `mno` int(11) NOT NULL COMMENT '药品单号',
  `mcount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '入库数量',
  `idate` datetime(0) DEFAULT NULL COMMENT '入库时间',
  `iuser` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登记者',
  PRIMARY KEY (`iuuid`) USING BTREE,
  INDEX `user`(`iuser`) USING BTREE,
  INDEX `no`(`mno`) USING BTREE,
  CONSTRAINT `no` FOREIGN KEY (`mno`) REFERENCES `m_pro` (`mno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user` FOREIGN KEY (`iuser`) REFERENCES `m_user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of m_input
-- ----------------------------
INSERT INTO `m_input` VALUES ('191218101201631', 2, '50', '2019-12-18 00:00:00', 'user03');
INSERT INTO `m_input` VALUES ('191218112439195', 6, '20', '2019-12-18 00:00:00', 'user03');
INSERT INTO `m_input` VALUES ('191218112742566', 6, '20', '2019-12-18 00:00:00', 'user03');

-- ----------------------------
-- Table structure for m_output
-- ----------------------------
DROP TABLE IF EXISTS `m_output`;
CREATE TABLE `m_output`  (
  `ouuid` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '入库单号',
  `mno` int(11) NOT NULL COMMENT '药品单号',
  `mcount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '入库数量',
  `odate` datetime(0) DEFAULT NULL COMMENT '入库时间',
  `ouser` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登记者',
  PRIMARY KEY (`ouuid`) USING BTREE,
  INDEX `user`(`ouser`) USING BTREE,
  INDEX `no`(`mno`) USING BTREE,
  CONSTRAINT `m_output_ibfk_1` FOREIGN KEY (`mno`) REFERENCES `m_pro` (`mno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `m_output_ibfk_2` FOREIGN KEY (`ouser`) REFERENCES `m_user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of m_output
-- ----------------------------
INSERT INTO `m_output` VALUES ('191218101046589', 2, '50', '2019-12-18 00:00:00', 'user03');

-- ----------------------------
-- Table structure for m_pro
-- ----------------------------
DROP TABLE IF EXISTS `m_pro`;
CREATE TABLE `m_pro`  (
  `mno` int(11) NOT NULL COMMENT '药品序号',
  `mname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '药品名字',
  `mprice` int(10) DEFAULT NULL COMMENT '药品价格',
  `msellprice` int(10) DEFAULT NULL COMMENT '药品售价',
  `mmadetime` datetime(0) NOT NULL COMMENT '药品生产日期',
  `mcount` int(11) DEFAULT NULL COMMENT '药品数量',
  PRIMARY KEY (`mno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of m_pro
-- ----------------------------
INSERT INTO `m_pro` VALUES (1, '999感冒灵', 50, 55, '2019-12-17 00:00:00', 50);
INSERT INTO `m_pro` VALUES (2, '复方阿胶丸', 24, 65, '2019-12-06 00:00:00', 22);
INSERT INTO `m_pro` VALUES (3, '维生素D', 90, 100, '2019-12-06 00:00:00', 10);
INSERT INTO `m_pro` VALUES (4, '止咳糖浆', 21, 25, '2019-12-07 00:00:00', 20);
INSERT INTO `m_pro` VALUES (5, '钙尔奇钙片', 5, 55, '2019-12-11 00:00:00', 22);
INSERT INTO `m_pro` VALUES (6, '测试药品', 50, 100, '2019-12-16 00:00:00', 240);

-- ----------------------------
-- Table structure for m_table
-- ----------------------------
DROP TABLE IF EXISTS `m_table`;
CREATE TABLE `m_table`  (
  `tuuid` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单号',
  `mno` int(11) DEFAULT NULL COMMENT '药品编号',
  `mname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '药品名称',
  `mprice` int(11) DEFAULT NULL COMMENT '进价',
  `msellprice` int(10) DEFAULT NULL COMMENT '售价',
  `tput` int(11) DEFAULT NULL COMMENT '出库或入库数量',
  `tid` int(11) DEFAULT NULL COMMENT '0/1标记出入库',
  `tuser` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管理员',
  `tdate` datetime(0) DEFAULT NULL COMMENT '单号时间',
  PRIMARY KEY (`tuuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for m_user
-- ----------------------------
DROP TABLE IF EXISTS `m_user`;
CREATE TABLE `m_user`  (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of m_user
-- ----------------------------
INSERT INTO `m_user` VALUES ('user03', '111111');

-- ----------------------------
-- Triggers structure for table m_input
-- ----------------------------
DROP TRIGGER IF EXISTS `input`;
delimiter ;;
CREATE DEFINER = `root`@`localhost` TRIGGER `input` AFTER INSERT ON `m_input` FOR EACH ROW BEGIN
UPDATE m_pro SET mcount=mcount+new.mcount WHERE mno=new.mno;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table m_input
-- ----------------------------
DROP TRIGGER IF EXISTS `in`;
delimiter ;;
CREATE DEFINER = `root`@`localhost` TRIGGER `in` AFTER UPDATE ON `m_input` FOR EACH ROW BEGIN
UPDATE m_pro SET mcount=mcount+new.mcount WHERE mno=new.mno;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table m_input
-- ----------------------------
DROP TRIGGER IF EXISTS `deletein`;
delimiter ;;
CREATE DEFINER = `root`@`localhost` TRIGGER `deletein` AFTER DELETE ON `m_input` FOR EACH ROW BEGIN
UPDATE m_pro SET mcount=mcount-old.mcount WHERE mno=old.mno;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table m_output
-- ----------------------------
DROP TRIGGER IF EXISTS `output`;
delimiter ;;
CREATE DEFINER = `root`@`localhost` TRIGGER `output` AFTER INSERT ON `m_output` FOR EACH ROW BEGIN
UPDATE m_pro SET mcount=mcount-new.mcount WHERE mno=new.mno;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table m_output
-- ----------------------------
DROP TRIGGER IF EXISTS `out`;
delimiter ;;
CREATE DEFINER = `root`@`localhost` TRIGGER `out` AFTER UPDATE ON `m_output` FOR EACH ROW BEGIN
UPDATE m_pro SET mcount=mcount-new.mcount WHERE mno=new.mno;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table m_output
-- ----------------------------
DROP TRIGGER IF EXISTS `delete`;
delimiter ;;
CREATE DEFINER = `root`@`localhost` TRIGGER `delete` AFTER DELETE ON `m_output` FOR EACH ROW BEGIN
UPDATE m_pro SET mcount=mcount+old.mcount WHERE mno=old.mno;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
