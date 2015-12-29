/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : soahw

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-12-30 05:37:31
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
INSERT INTO `b_balance` VALUES ('1', '1', '800', '0');
INSERT INTO `b_balance` VALUES ('2', '2', '200', '0');

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
  `ispay` int(11) DEFAULT NULL,
  `money` double(255,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `O_CUSTOMERID` (`customerid`),
  KEY `O_PRODUCTID` (`productid`),
  CONSTRAINT `O_CUSTOMERID` FOREIGN KEY (`customerid`) REFERENCES `c_customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `O_PRODUCTID` FOREIGN KEY (`productid`) REFERENCES `p_product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of o_order
-- ----------------------------
INSERT INTO `o_order` VALUES ('6', '1', '1', '10', '2015-12-30', '2', '100');
INSERT INTO `o_order` VALUES ('7', '1', '1', '10', '2015-12-30', '2', '100');

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
INSERT INTO `p_product` VALUES ('1', 'gg', '-10', 'ggg', '10');
INSERT INTO `p_product` VALUES ('2', 'qq', '20', 'qq', '66');
