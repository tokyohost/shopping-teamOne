/*
 Navicat MySQL Data Transfer

 Source Server         : 显卡数据库
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : 118.24.74.234:3306
 Source Schema         : xiankadatabase

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 27/11/2019 14:34:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Order
-- ----------------------------
DROP TABLE IF EXISTS `Order`;
CREATE TABLE `Order`  (
  `Order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单号',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '订单归属的用户id',
  `Total_amount` float(255, 3) NULL DEFAULT NULL COMMENT '金额总计',
  `order_date` datetime NULL DEFAULT '2000-01-17 00:00:00' COMMENT '下单时间',
  `order_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '已下单' COMMENT '订单状态',
  `uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单唯一识别码',
  PRIMARY KEY (`Order_id`) USING BTREE,
  INDEX `userid_f`(`user_id`) USING BTREE,
  INDEX `uuid`(`uuid`) USING BTREE,
  CONSTRAINT `userid_f` FOREIGN KEY (`user_id`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 60 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of Order
-- ----------------------------
INSERT INTO `Order` VALUES (49, 10, 414.800, '2019-11-24 17:52:16', '已签收', '7240c27e78964b0ba9af83ad637d061f');
INSERT INTO `Order` VALUES (50, 10, 2939.300, '2019-11-24 17:53:01', '已签收', '4781207961cf48c9b01430245b3d7647');
INSERT INTO `Order` VALUES (51, 10, 2939.300, '2019-11-24 23:21:01', '已签收', '0d43fa069b16460bb06821d29c95cc05');
INSERT INTO `Order` VALUES (52, 10, 2939.300, '2019-11-25 15:47:15', '已签收', '3d681ae5c5034e8aac9e5150c7121ffb');
INSERT INTO `Order` VALUES (53, 10, 520.866, '2019-11-25 19:01:25', '未处理', '2e1e011fc2574e0faae30a969c6e262a');
INSERT INTO `Order` VALUES (54, 10, 10347.866, '2019-11-25 19:05:58', '已签收', '15c12e401a8c4431b5cd1485445dc2b5');
INSERT INTO `Order` VALUES (55, 10, 8817.900, '2019-11-25 19:07:49', '已签收', 'f235a6a11e734c26be6c6534ff909b05');
INSERT INTO `Order` VALUES (56, 10, 2939.300, '2019-11-25 19:10:14', '已签收', 'b1ff37b2d2c049449ec1d1180ff251bc');
INSERT INTO `Order` VALUES (57, 10, 764.983, '2019-11-25 19:22:21', '已提交订单，折扣为8.5折', 'b72c6f4f8ce74aee827f539fafddccbf');
INSERT INTO `Order` VALUES (58, 10, 4469.266, '2019-11-26 10:27:45', '已签收', '59b3405334dd4ad99207b6b9aaea6a1d');
INSERT INTO `Order` VALUES (59, 6, 3458.000, '2019-11-27 14:19:50', '已提交订单，折扣为10.0折', '3a63c227f2d24ad0b0f5539ac0b3c5cf');

-- ----------------------------
-- Table structure for Order_item
-- ----------------------------
DROP TABLE IF EXISTS `Order_item`;
CREATE TABLE `Order_item`  (
  `Oid` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单项id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '订单项归属用户id',
  `product_id` int(11) NULL DEFAULT NULL COMMENT '当前订单项商品Id',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '商品下单数',
  `order_Subtotal` float(255, 3) NULL DEFAULT NULL COMMENT '金额小计',
  `uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单表唯一识别码',
  PRIMARY KEY (`Oid`) USING BTREE,
  INDEX `productidf`(`product_id`) USING BTREE,
  INDEX `useridf`(`user_id`) USING BTREE,
  INDEX `orderf`(`uuid`) USING BTREE,
  CONSTRAINT `orderf` FOREIGN KEY (`uuid`) REFERENCES `Order` (`uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `productidf` FOREIGN KEY (`product_id`) REFERENCES `product_item` (`pid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `useridf` FOREIGN KEY (`user_id`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of Order_item
-- ----------------------------
INSERT INTO `Order_item` VALUES (42, 10, 3, 1, 488.000, '7240c27e78964b0ba9af83ad637d061f');
INSERT INTO `Order_item` VALUES (43, 10, 2, 1, 3458.000, '4781207961cf48c9b01430245b3d7647');
INSERT INTO `Order_item` VALUES (44, 10, 2, 1, 3458.000, '0d43fa069b16460bb06821d29c95cc05');
INSERT INTO `Order_item` VALUES (45, 10, 2, 1, 3458.000, '3d681ae5c5034e8aac9e5150c7121ffb');
INSERT INTO `Order_item` VALUES (46, 10, 3, 2, 1799.960, '2e1e011fc2574e0faae30a969c6e262a');
INSERT INTO `Order_item` VALUES (47, 10, 2, 3, 10374.000, '2e1e011fc2574e0faae30a969c6e262a');
INSERT INTO `Order_item` VALUES (48, 10, 3, 2, 1799.960, '15c12e401a8c4431b5cd1485445dc2b5');
INSERT INTO `Order_item` VALUES (49, 10, 2, 3, 10374.000, '15c12e401a8c4431b5cd1485445dc2b5');
INSERT INTO `Order_item` VALUES (50, 10, 2, 3, 10374.000, 'f235a6a11e734c26be6c6534ff909b05');
INSERT INTO `Order_item` VALUES (51, 10, 2, 1, 3458.000, 'b1ff37b2d2c049449ec1d1180ff251bc');
INSERT INTO `Order_item` VALUES (52, 10, 3, 1, 899.980, 'b72c6f4f8ce74aee827f539fafddccbf');
INSERT INTO `Order_item` VALUES (53, 10, 3, 2, 1799.960, '59b3405334dd4ad99207b6b9aaea6a1d');
INSERT INTO `Order_item` VALUES (54, 10, 2, 1, 3458.000, '59b3405334dd4ad99207b6b9aaea6a1d');
INSERT INTO `Order_item` VALUES (55, 6, 2, 1, 3458.000, '3a63c227f2d24ad0b0f5539ac0b3c5cf');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `cart_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车id',
  `user_id` int(11) NOT NULL COMMENT '购物车归属的用户id',
  `product_id` int(11) NOT NULL COMMENT '购物车内商品id',
  `cart_date` datetime NOT NULL COMMENT '加入商品时间',
  `pnum` int(11) NOT NULL COMMENT '购物车内单件商品数量',
  PRIMARY KEY (`cart_id`) USING BTREE,
  INDEX `userf`(`user_id`) USING BTREE,
  INDEX `productf`(`product_id`) USING BTREE,
  CONSTRAINT `productf` FOREIGN KEY (`product_id`) REFERENCES `product_item` (`pid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `userf` FOREIGN KEY (`user_id`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES (1, 5, 2, '2019-11-25 00:00:00', 3);
INSERT INTO `cart` VALUES (17, 10, 2, '2019-11-26 22:26:49', 1);

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品分类id',
  `cname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品分类名字',
  `cxinhao` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品类型',
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES (2, '败家之眼', 'AMD');
INSERT INTO `product_category` VALUES (3, '华硕', 'Nvidia');

-- ----------------------------
-- Table structure for product_item
-- ----------------------------
DROP TABLE IF EXISTS `product_item`;
CREATE TABLE `product_item`  (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `pname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名字',
  `pclassifyid` int(255) NOT NULL DEFAULT 1 COMMENT '商品分类',
  `pdate` date NULL DEFAULT NULL COMMENT '商品生产日期',
  `Suppliers` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'ç½‘ç«™ä¾›åº”' COMMENT '供应商',
  `pnumber` int(255) NULL DEFAULT 0 COMMENT '商品数量',
  `price` float(254, 2) NULL DEFAULT 0.00 COMMENT '商品价格',
  `descw` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品详情',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片路径',
  `is_delete` int(255) NOT NULL DEFAULT 0 COMMENT '商品是否删除',
  PRIMARY KEY (`pid`) USING BTREE,
  INDEX `product_cid`(`pclassifyid`) USING BTREE,
  CONSTRAINT `product_cid` FOREIGN KEY (`pclassifyid`) REFERENCES `product_category` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of product_item
-- ----------------------------
INSERT INTO `product_item` VALUES (2, 'GT 2080ti', 3, '2019-11-22', '商家直供测试修改    ', 972, 3458.00, '有钱你就上！测试修改    ', 'ROG2080.jpg', 0);
INSERT INTO `product_item` VALUES (3, 'RX 580', 2, '2019-11-23', '本站供应        ', 979, 899.98, 'AMD YES!!!!  测试      ', 'amdRX580.jpg', 0);
INSERT INTO `product_item` VALUES (4, 'test', 3, '2019-11-26', 'test', 1, 888.00, 'test ', 'test', 1);
INSERT INTO `product_item` VALUES (5, 'FoxTheFuckBug', 3, '2019-11-26', 'fuck', 888, 999.00, 'fuck ', 'fuck', 1);
INSERT INTO `product_item` VALUES (6, 'foxisTrue?', 2, '2019-11-26', 'fuck', 12, 12.00, 'fuck ', 'fuck', 1);
INSERT INTO `product_item` VALUES (7, '测试添加商品', 2, '2019-11-26', '李某', 99, 0.10, '不要钱，大甩卖！ ', 'gitsdk.png', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(255) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `upasswd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `uemail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `usex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `uphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `uaddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `balance` float(255, 0) UNSIGNED NULL DEFAULT 0 COMMENT '余额',
  `discount` tinyint(1) NULL DEFAULT 100 COMMENT '折扣',
  `integral` int(255) NULL DEFAULT 0 COMMENT '积分',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (5, 'lixuehui', '123', '123@qq.com', '男', '2019-11-07', '17790520134', '江苏省连云港市', 1000, 100, 0);
INSERT INTO `user` VALUES (6, 'test', '123', 'null', '男', NULL, 'null', '连云港', 96541, 100, 3458);
INSERT INTO `user` VALUES (7, 'test1', '123', '1234567@qq.com', '男', NULL, 'null', '江苏省', 0, 100, 0);
INSERT INTO `user` VALUES (8, 'test4', '123123', '123123@qq.com', '男', NULL, '17790520134', '花果山', 0, 100, 0);
INSERT INTO `user` VALUES (9, 'test5', '123123', '123123@qq', '男', NULL, '', '', 0, 100, 0);
INSERT INTO `user` VALUES (10, 'test7', '123123', '123123@qq.com', '男', '2000-01-01', '17790520134', '中国四川省南充市蓬安县抚琴大道98号', 10343, 85, 89656);
INSERT INTO `user` VALUES (11, 'zhoutao', '123456', 'zhoutao@qq.com', '男', NULL, '123456', '625', 0, 100, 0);
INSERT INTO `user` VALUES (12, 'cxp', '123', 'null', '女', NULL, 'null', 'skjldhg', 0, 100, 0);
INSERT INTO `user` VALUES (13, 'testz', '123', '123', '男', NULL, '22', '23', 0, 100, 0);
INSERT INTO `user` VALUES (14, 'cxp', '123', 'null', '女', NULL, 'null', 'kjgp', 0, 100, 0);
INSERT INTO `user` VALUES (15, 'null', 'null', 'null', 'null', NULL, 'null', 'null', 0, 100, 0);
INSERT INTO `user` VALUES (16, 'cxp', '123', 'null', '女', NULL, 'null', 'sdgh', 0, 100, 0);

SET FOREIGN_KEY_CHECKS = 1;
