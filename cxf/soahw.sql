/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : soahw

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-12-29 23:12:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `b_balance`
-- ----------------------------
DROP TABLE IF EXISTS `b_balance`;
CREATE TABLE `b_balance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) DEFAULT NULL,
  `balance` double(255,0) DEFAULT NULL,
  `prebalance` double(255,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `B_CUSTOMERID` (`customerid`),
  CONSTRAINT `B_CUSTOMERID` FOREIGN KEY (`customerid`) REFERENCES `c_customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_balance
-- ----------------------------
INSERT INTO `b_balance` VALUES ('1', '1', '20', '0');
INSERT INTO `b_balance` VALUES ('2', '2', '0', '0');

-- ----------------------------
-- Table structure for `c_customer`
-- ----------------------------
DROP TABLE IF EXISTS `c_customer`;
CREATE TABLE `c_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` varchar(50) DEFAULT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `street` varchar(100) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `zipcode` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `phonenumber` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_customer
-- ----------------------------
INSERT INTO `c_customer` VALUES ('1', 'admin', 'admin', 'admin', '11', '11', '11', '1111', '11111111');
INSERT INTO `c_customer` VALUES ('2', 'sss', 'ssss', 'sss', '11', '11', '11', '1111', '1111111');

-- ----------------------------
-- Table structure for `o_order`
-- ----------------------------
DROP TABLE IF EXISTS `o_order`;
CREATE TABLE `o_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) DEFAULT NULL,
  `productid` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `timestamp` date DEFAULT NULL,
  `toid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `O_CUSTOMERID` (`customerid`),
  KEY `O_PRODUCTID` (`productid`),
  CONSTRAINT `O_CUSTOMERID` FOREIGN KEY (`customerid`) REFERENCES `c_customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `O_PRODUCTID` FOREIGN KEY (`productid`) REFERENCES `p_product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of o_order
-- ----------------------------

-- ----------------------------
-- Table structure for `p_product`
-- ----------------------------
DROP TABLE IF EXISTS `p_product`;
CREATE TABLE `p_product` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(50) DEFAULT NULL,
  `sku` varchar(50) DEFAULT NULL,
  `manufacture` varchar(100) DEFAULT NULL,
  `cost` double(20,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_product
-- ----------------------------
