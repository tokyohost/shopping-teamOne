/*
MySQL Data Transfer
Source Host: localhost
Source Database: shop
Target Host: localhost
Target Database: shop
Date: 2013/6/14 17:24:38
*/
-- ----------------------------
-- Table structure for cart_item_sx
-- ----------------------------
CREATE TABLE `cart_item` (
  `id` int(11) NOT NULL,
  `amount` int(11) default NULL,
  `cost` float default NULL,
  `book_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for cart_order_sx
-- ----------------------------
CREATE TABLE `cart_order` (
  `id` int(11) NOT NULL,
  `status` varchar(12) default NULL,
  `odate` varchar(30) default NULL,
  `user_id` int(11) NOT NULL,
  `cost` double(10,2) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for cart_product_sx
-- ----------------------------
CREATE TABLE `cart_book` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `description` varchar(500) default NULL,
  `price` float default NULL,
  `img` varchar(50) default NULL,
  `book_type_id` int(11) NOT NULL ,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for cart_product_type
-- ----------------------------
CREATE TABLE `book_type` (
  `book_type_name` varchar(50) default NULL,
  `id` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for cart_user_sx
-- ----------------------------
CREATE TABLE `cart_user` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `address` varchar(512) default NULL,
  `postcode` varchar(10) default NULL,
  `email` varchar(32) default NULL,
  `phone` varchar(32) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;


-- ----------------------------
-- Table structure for order_id
-- ----------------------------
CREATE TABLE `order_id` (
  `oid` int(10) NOT NULL,
  PRIMARY KEY  (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for orderitem_id
-- ----------------------------
CREATE TABLE `orderitem_id` (
  `oid` int(10) NOT NULL,
  PRIMARY KEY  (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `cart_item` VALUES ('1', '1', '50.500000', '1', '5');
INSERT INTO `cart_item` VALUES ('2', '1', '35.000000', '4', '5');
INSERT INTO `cart_item` VALUES ('3', '2', '68.000000', '2', '5');
INSERT INTO `cart_item` VALUES ('4', '1', '50.500000', '1', '6');
INSERT INTO `cart_item` VALUES ('5', '1', '34.000000', '2', '6');
INSERT INTO `cart_item` VALUES ('6', '1', '35.000000', '5', '6');
INSERT INTO `cart_item` VALUES ('7', '1', '35.000000', '5', '7');
INSERT INTO `cart_item` VALUES ('8', '1', '50.500000', '1', '7');
INSERT INTO `cart_item` VALUES ('9', '2', '70.000000', '4', '7');
INSERT INTO `cart_item` VALUES ('10', '1', '34.000000', '2', '7');
INSERT INTO `cart_item` VALUES ('11', '1', '35.000000', '5', '8');
INSERT INTO `cart_item` VALUES ('12', '1', '50.500000', '1', '8');
INSERT INTO `cart_item` VALUES ('13', '2', '70.000000', '4', '8');
INSERT INTO `cart_item` VALUES ('14', '1', '34.000000', '2', '8');
INSERT INTO `cart_item` VALUES ('15', '1', '35.000000', '5', '9');
INSERT INTO `cart_item` VALUES ('16', '1', '50.500000', '1', '9');
INSERT INTO `cart_item` VALUES ('17', '2', '70.000000', '4', '9');
INSERT INTO `cart_item` VALUES ('18', '1', '34.000000', '2', '9');
INSERT INTO `cart_item` VALUES ('19', '1', '50.500000', '1', '10');
INSERT INTO `cart_item` VALUES ('20', '1', '34.000000', '2', '10');
INSERT INTO `cart_item` VALUES ('21', '1', '50.500000', '1', '11');
INSERT INTO `cart_item` VALUES ('22', '1', '34.000000', '2', '11');
INSERT INTO `cart_item` VALUES ('23', '2', '70.000000', '5', '12');
INSERT INTO `cart_item` VALUES ('25', '1', '35.000000', '4', '13');
INSERT INTO `cart_item` VALUES ('26', '2', '68.000000', '2', '13');
INSERT INTO `cart_item` VALUES ('27', '1', '50.500000', '1', '13');
INSERT INTO `cart_order` VALUES ('1', '未付款', '2013-59-17  13:59:43', '1', '4.00');
INSERT INTO `cart_order` VALUES ('2', '未付款', '2013-35-03  22:35:30', '1', '41.00');
INSERT INTO `cart_order` VALUES ('3', '未付款', '2013-34-04  09:34:43', '1', '12.00');
INSERT INTO `cart_order` VALUES ('4', '未付款', '2013-57-13  14:57:16', '1', '190.50');
INSERT INTO `cart_order` VALUES ('5', '未付款', '2013-13-13  16:13:39', '1', '153.50');
INSERT INTO `cart_order` VALUES ('6', '未付款', '2013-26-13  16:26:53', '1', '119.50');
INSERT INTO `cart_order` VALUES ('7', '未付款', '2013-46-14  10:46:41', '1', '189.50');
INSERT INTO `cart_order` VALUES ('8', '未付款', '2013-50-14  10:50:42', '1', '189.50');
INSERT INTO `cart_order` VALUES ('9', '未付款', '2013-52-14  10:52:41', '1', '189.50');
INSERT INTO `cart_order` VALUES ('10', '未付款', '2013-54-14  10:54:44', '1', '84.50');
INSERT INTO `cart_order` VALUES ('11', '未付款', '2013-57-14  10:57:35', '1', '84.50');
INSERT INTO `cart_order` VALUES ('12', '未付款', '2013-59-14  10:59:41', '1', '307.00');
INSERT INTO `cart_order` VALUES ('13', '未付款', '2013-27-14  15:27:31', '1', '153.50');
INSERT INTO `cart_book` VALUES ('1', 'j2ee', 'J2EE指南对于广大的Java程序员来说是一份不可或缺的资料了。这篇导论对于初次碰到J2EE的程序员来说有着同样的作用。它与Java指南一样都是一例子为中心。 这篇指南是为爱好开发和部署J2EE应用程序的程序员准备的。它包括了组成J2EE平台的技术以及描述如何开发J2EE组件并部署在J2EE软件开发包上。 ', '50.5', 'j2ee.jpg','1');
INSERT INTO `cart_book` VALUES ('2', 'javaWeb', '本书将开发技术与开发环境相结合，既要讲明Web设计的过程，又要突出Eclipse开发工具对Web设计的支持，所以从全书布局上体现了以下设计思路：在熟悉Eclipse 开发环境和掌握Web设计基本技术的基础上，进一步加强和学习Web架构的设计，学习测试理论和测试方法，掌握在开发过程中进行版本控制的意义和实现手段。利用Eclipse所具备的丰富的开发内涵进行Web设计是一个循序渐进并不断学习的过程，所以本书在内容的选取和安排上，不但考虑教学要求，更遵循以基础为重、不断拓展的原则.', '34', 'java Web.jpg','1');
INSERT INTO `cart_book` VALUES ('3', 'MySql实用教程', '本书以当前最流行的MySQL5.1作为平台，分为四部分：MySQL（含习题）、实验、客户端/MySQL综合应用实习和附录；比较系统地介绍MySQL的功能，同时系统介绍Linux下PHP、Windows下ASP.NET（C≠）、JSP（JavaBean）和Visualc++与MySQL的应用方法。', '35', 'mySql.jpg','1');
INSERT INTO `cart_book` VALUES ('4', 'Java实用教程', '本教程包含了实用教程、习题、实验、综合应用实习等几个部分。内容主要包括Java基本程序设计、Java图形界面设计、JBuilder数据库和多媒体应用程序设计。实用教程一般在讲解内容后紧跟实例,并且实例程序一般均上机调试通过,实验部分通过实例先一步一步引导读者进行操作,然后提出问题让读者思考和在原来基础上自己进行操作和编程练习;实习部分是综合训练实际解决问题的能力。本教程各部分层次清楚,并依据教学特点进行精心编排,方便用户根据自己需要进行选择。', '35', 'javasy.jpg','1');
INSERT INTO `book_type` VALUES ('高等数学', '1');
INSERT INTO `book_type` VALUES ('计算机', '2');
INSERT INTO `book_type` VALUES ('英语', '3');
INSERT INTO `cart_user` VALUES ('6', 'lgt', '123', '成都市高新区西区大道    ', '611743    ', '114721311@qq.com    ', '123456789    ');
INSERT INTO `cart_user` VALUES ('7', 'test', '123', 'test  ', '123456  ', 'test@qq.com  ', '12345678  ');
INSERT INTO `order_id` VALUES ('13');
INSERT INTO `orderitem_id` VALUES ('27');


