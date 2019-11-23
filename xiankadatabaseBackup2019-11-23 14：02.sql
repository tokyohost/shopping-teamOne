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

 Date: 23/11/2019 14:02:16
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
  `order_date` date NULL DEFAULT '2000-01-17' COMMENT '下单时间',
  `order_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '已下单' COMMENT '订单状态',
  `uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单唯一识别码',
  PRIMARY KEY (`Order_id`) USING BTREE,
  INDEX `userid_f`(`user_id`) USING BTREE,
  INDEX `uuid`(`uuid`) USING BTREE,
  CONSTRAINT `userid_f` FOREIGN KEY (`user_id`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of Order
-- ----------------------------
INSERT INTO `Order` VALUES (1, 9, 999.000, '2019-11-24', '已下单', 'hngvdfhgdfhdjfghdfytfhgjfhghfjhg');
INSERT INTO `Order` VALUES (4, 5, 999.000, '2019-11-24', '已下单', 'hngvdfhgdfhdjfghdfytfhgjfhghfjhg');
INSERT INTO `Order` VALUES (5, 10, 2.000, '2019-11-22', '已提交订单', '553a0fb308c847689b8bd0c6becd6dfe');
INSERT INTO `Order` VALUES (8, 10, 2.000, '2019-11-22', '已提交订单', '12495d42d4834a49adadd3d6c8b24721');
INSERT INTO `Order` VALUES (9, 10, 2.000, '2019-11-22', '已提交订单', 'a66ae3498a4947ac95dcd3f2b261df43');
INSERT INTO `Order` VALUES (10, 10, 2.000, '2019-11-22', '已提交订单', '72a50ab36b914f0fb90738ce51b93db3');
INSERT INTO `Order` VALUES (11, 10, 2.000, '2019-11-22', '已提交订单', 'c1f4f1a0e68447de976c8f91bd21f59f');
INSERT INTO `Order` VALUES (12, 10, 2.000, '2019-11-22', '已提交订单', '850fbd087b4c4fbe971e09df5653493a');
INSERT INTO `Order` VALUES (13, 10, 2.000, '2019-11-22', '已提交订单', 'a8028d3333f24a68b0fcf7762b7d1e4e');
INSERT INTO `Order` VALUES (14, 10, 2.000, '2019-11-22', '已提交订单', 'a1c9949608b946df94c937959089ec8f');
INSERT INTO `Order` VALUES (15, 10, 3.000, '2019-11-22', '已提交订单', '163c6fb7bdca48cbbdac1aff29f31e2f');
INSERT INTO `Order` VALUES (16, 10, 0.000, '2019-11-22', '已提交订单', '5faed1681a2646f68344c757c24201d8');
INSERT INTO `Order` VALUES (17, 10, 1.000, '2019-11-22', '已提交订单', 'ab2d8534520044df9978bc3c141aabf1');
INSERT INTO `Order` VALUES (18, 6, 4.000, '2019-11-23', '已提交订单', '742e07da91c9409188c5b294d23a41bf');
INSERT INTO `Order` VALUES (19, 10, 3946.000, '2019-11-23', '已提交订单', '27b4b089486f41ec91c048d97d32860a');
INSERT INTO `Order` VALUES (20, 10, 17778.000, '2019-11-23', '已提交订单', '352f2cb38ba04340b3c7fc24d26c38ac');
INSERT INTO `Order` VALUES (21, 5, 7404.000, '2019-11-23', '已提交订单', '7077deb591e34763a4b2623a0b7bc57b');

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
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of Order_item
-- ----------------------------
INSERT INTO `Order_item` VALUES (1, 10, 3, 3, 14.900, 'hngvdfhgdfhdjfghdfytfhgjfhghfjhg');
INSERT INTO `Order_item` VALUES (2, 10, 3, 1, 3458.000, 'a8028d3333f24a68b0fcf7762b7d1e4e');
INSERT INTO `Order_item` VALUES (3, 10, 3, 1, 3458.000, 'a8028d3333f24a68b0fcf7762b7d1e4e');
INSERT INTO `Order_item` VALUES (4, 10, 2, 1, 3458.000, 'a1c9949608b946df94c937959089ec8f');
INSERT INTO `Order_item` VALUES (5, 10, 3, 1, 488.000, 'a1c9949608b946df94c937959089ec8f');
INSERT INTO `Order_item` VALUES (6, 10, 2, 3, 10374.000, '163c6fb7bdca48cbbdac1aff29f31e2f');
INSERT INTO `Order_item` VALUES (7, 10, 2, 1, 3458.000, 'ab2d8534520044df9978bc3c141aabf1');
INSERT INTO `Order_item` VALUES (8, 6, 2, 3, 10374.000, '742e07da91c9409188c5b294d23a41bf');
INSERT INTO `Order_item` VALUES (9, 6, 3, 1, 488.000, '742e07da91c9409188c5b294d23a41bf');
INSERT INTO `Order_item` VALUES (10, 10, 3, 1, 488.000, '27b4b089486f41ec91c048d97d32860a');
INSERT INTO `Order_item` VALUES (11, 10, 2, 1, 3458.000, '27b4b089486f41ec91c048d97d32860a');
INSERT INTO `Order_item` VALUES (12, 10, 2, 5, 17290.000, '352f2cb38ba04340b3c7fc24d26c38ac');
INSERT INTO `Order_item` VALUES (13, 10, 3, 1, 488.000, '352f2cb38ba04340b3c7fc24d26c38ac');
INSERT INTO `Order_item` VALUES (14, 5, 3, 1, 488.000, '7077deb591e34763a4b2623a0b7bc57b');
INSERT INTO `Order_item` VALUES (15, 5, 2, 2, 6916.000, '7077deb591e34763a4b2623a0b7bc57b');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `cart_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车id',
  `user_id` int(11) NOT NULL COMMENT '购物车归属的用户id',
  `product_id` int(11) NOT NULL COMMENT '购物车内商品id',
  `cart_date` date NOT NULL COMMENT '加入商品时间',
  `pnum` int(11) NOT NULL COMMENT '购物车内单件商品数量',
  PRIMARY KEY (`cart_id`) USING BTREE,
  INDEX `userf`(`user_id`) USING BTREE,
  INDEX `productf`(`product_id`) USING BTREE,
  CONSTRAINT `productf` FOREIGN KEY (`product_id`) REFERENCES `product_item` (`pid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `userf` FOREIGN KEY (`user_id`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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
  `price` float(254, 0) NULL DEFAULT 0 COMMENT '商品价格',
  `descw` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品详情',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片路径',
  PRIMARY KEY (`pid`) USING BTREE,
  INDEX `product_cid`(`pclassifyid`) USING BTREE,
  CONSTRAINT `product_cid` FOREIGN KEY (`pclassifyid`) REFERENCES `product_category` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of product_item
-- ----------------------------
INSERT INTO `product_item` VALUES (2, 'GT 980', 3, '2019-11-22', '商家直供', 18, 3458, '有钱你就上！', 'ROG2080.jpg');
INSERT INTO `product_item` VALUES (3, 'RX 580', 2, '2019-11-23', '本站供应', 3, 488, 'AMD YES!!!!', 'amdRX580.jpg');

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
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (5, 'lixuehui', '123', '123@qq.com', '男', '2019-11-07', '17790520134', '江苏省连云港市', 0, 100, 0);
INSERT INTO `user` VALUES (6, 'test', '123', 'null', '男', NULL, 'null', '连云港', 0, 100, 0);
INSERT INTO `user` VALUES (7, 'test1', '123', '1234567@qq.com', '男', NULL, 'null', '江苏省', 0, 100, 0);
INSERT INTO `user` VALUES (8, 'test4', '123123', '123123@qq.com', '男', NULL, '17790520134', '花果山', 0, 100, 0);
INSERT INTO `user` VALUES (9, 'test5', '123123', '123123@qq', '男', NULL, '', '', 0, 100, 0);
INSERT INTO `user` VALUES (10, 'test7', '123123', '123123@qq.com', '男', '2000-01-01', '17790520134', '中国四川省南充市蓬安县抚琴大道98号', 0, 100, 0);

SET FOREIGN_KEY_CHECKS = 1;
