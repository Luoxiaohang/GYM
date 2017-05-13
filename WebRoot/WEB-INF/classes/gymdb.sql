/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : gymdb

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2016-06-16 08:37:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `aId` int(11) unsigned NOT NULL auto_increment,
  `aName` varchar(255) default NULL,
  `aPassword` varchar(255) default NULL,
  `idCardNo` varchar(255) default NULL,
  `birthdate` varchar(255) default NULL,
  `power` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `phone` varchar(255) default NULL,
  `status` varchar(255) default NULL,
  `aEntry` varchar(255) default NULL,
  PRIMARY KEY  (`aId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin', null, null, '2', null, null, null, null);
INSERT INTO `admin` VALUES ('2', 'sdf', 'khjk', 'gdf', '2016-06-15 08:00', '1', 'hgfh', 'hg', '0', '2016-6-15 22:18:54');
INSERT INTO `admin` VALUES ('3', 'd\'f', 'dfg', 'dbf', '2016-06-15 08:00', '1', 'dfg', 'dfg', '1', '2016-6-15 22:32:19');

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
  `eId` int(11) NOT NULL auto_increment,
  `eTypeId` int(11) default NULL,
  `buyDate` datetime default NULL,
  `buyCost` decimal(10,0) default NULL,
  `eFee` varchar(255) default NULL,
  `status` varchar(255) default NULL,
  `borrowCount` int(11) NOT NULL,
  PRIMARY KEY  (`eId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment` VALUES ('1', '1', '2016-06-15 08:00:00', '5', '3', '0', '0');
INSERT INTO `equipment` VALUES ('2', '2', '2016-06-15 08:00:00', '5', '3', '0', '0');
INSERT INTO `equipment` VALUES ('3', '2', '2016-06-15 08:00:00', '5', '3', '1', '0');
INSERT INTO `equipment` VALUES ('4', '1', '2016-06-15 08:00:00', '5', '6', '1', '0');

-- ----------------------------
-- Table structure for equipmentrent
-- ----------------------------
DROP TABLE IF EXISTS `equipmentrent`;
CREATE TABLE `equipmentrent` (
  `eRentId` int(11) NOT NULL auto_increment,
  `eId` int(11) default NULL,
  `uId` int(11) default NULL,
  `borrowBegin` varchar(255) default NULL,
  `borrowEnd` varchar(255) default NULL,
  `borrowFee` varchar(255) default NULL,
  `status` varchar(255) default NULL,
  PRIMARY KEY  (`eRentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of equipmentrent
-- ----------------------------
INSERT INTO `equipmentrent` VALUES ('1', '3', '2013117011', '2016-06-16 15:00', '2016-06-16 19:00', '12.0', '1');

-- ----------------------------
-- Table structure for equipmenttype
-- ----------------------------
DROP TABLE IF EXISTS `equipmenttype`;
CREATE TABLE `equipmenttype` (
  `eTypeId` int(11) NOT NULL,
  `eTypeName` varchar(255) NOT NULL,
  PRIMARY KEY  (`eTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of equipmenttype
-- ----------------------------
INSERT INTO `equipmenttype` VALUES ('1', '乒乓球');
INSERT INTO `equipmenttype` VALUES ('2', '篮球');
INSERT INTO `equipmenttype` VALUES ('3', '足球');

-- ----------------------------
-- Table structure for financial
-- ----------------------------
DROP TABLE IF EXISTS `financial`;
CREATE TABLE `financial` (
  `fId` int(11) NOT NULL,
  `fOut` varchar(255) default NULL,
  `fIn` varchar(255) default NULL,
  `fInType` varchar(255) default NULL,
  `notes` varchar(255) default NULL,
  `date` datetime default NULL,
  PRIMARY KEY  (`fId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of financial
-- ----------------------------

-- ----------------------------
-- Table structure for ground
-- ----------------------------
DROP TABLE IF EXISTS `ground`;
CREATE TABLE `ground` (
  `gId` int(11) unsigned NOT NULL auto_increment,
  `gName` varchar(255) default NULL,
  `tId` int(11) default NULL,
  `gFee` varchar(255) default NULL,
  `gStatus` varchar(255) default NULL,
  `gRemark` varchar(255) default NULL,
  `tName` varchar(255) default NULL,
  PRIMARY KEY  (`gId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ground
-- ----------------------------
INSERT INTO `ground` VALUES ('1', 'yiyi', '1', '15', '1', 'sdgf', null);
INSERT INTO `ground` VALUES ('2', 'sdf', '1', '5', '0', 'sdgf', null);
INSERT INTO `ground` VALUES ('3', 'sdf', '1', '5', '1', 'sdgf', null);
INSERT INTO `ground` VALUES ('4', 'sdf', '1', '5', '0', 'sdgf', null);

-- ----------------------------
-- Table structure for groundbook
-- ----------------------------
DROP TABLE IF EXISTS `groundbook`;
CREATE TABLE `groundbook` (
  `bId` int(11) unsigned NOT NULL auto_increment,
  `uId` int(11) default NULL,
  `gId` int(11) default NULL,
  `bDate` datetime default NULL,
  `bStartTime` datetime default NULL,
  `bEndTime` datetime default NULL,
  `bFee` varchar(255) default NULL,
  `bStatus` varchar(255) default NULL,
  PRIMARY KEY  (`bId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of groundbook
-- ----------------------------
INSERT INTO `groundbook` VALUES ('2', '2013117011', '1', '2016-06-16 00:23:14', '2016-06-16 08:00:00', '2016-06-16 10:00:00', '30.0', '1');
INSERT INTO `groundbook` VALUES ('3', '2013117011', '1', '2016-06-16 00:23:59', '2016-06-16 10:00:00', '2016-06-16 12:00:00', '30.0', '1');

-- ----------------------------
-- Table structure for groundtype
-- ----------------------------
DROP TABLE IF EXISTS `groundtype`;
CREATE TABLE `groundtype` (
  `tId` int(11) NOT NULL,
  `tName` varchar(255) default NULL,
  PRIMARY KEY  (`tId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of groundtype
-- ----------------------------
INSERT INTO `groundtype` VALUES ('1', '篮球场');
INSERT INTO `groundtype` VALUES ('2', '足球场');
INSERT INTO `groundtype` VALUES ('3', '排球场');

-- ----------------------------
-- Table structure for match
-- ----------------------------
DROP TABLE IF EXISTS `match`;
CREATE TABLE `match` (
  `mId` int(11) NOT NULL,
  `mName` varchar(255) default NULL,
  `mDate` datetime default NULL,
  `aId` int(11) default NULL,
  `text` varchar(255) default NULL,
  `status` varchar(255) default NULL,
  PRIMARY KEY  (`mId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of match
-- ----------------------------

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `nId` int(11) NOT NULL,
  `nTitle` varchar(255) default NULL,
  `nText` varchar(255) default NULL,
  `nDate` datetime default NULL,
  `aId` int(11) default NULL,
  PRIMARY KEY  (`nId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL auto_increment,
  `uId` int(12) unsigned default NULL,
  `uName` varchar(255) default NULL,
  `uPassword` varchar(255) default NULL,
  `uEmail` varchar(255) default NULL,
  `uIdCard` varchar(255) default NULL,
  `uPhone` varchar(255) default NULL,
  `date` varchar(255) default NULL,
  `status` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '2013117011', '罗小航', '456789', 'luo_xiaohang@163.com', '2752357', '10088', '2016-6-16 0:01:38', '1');
