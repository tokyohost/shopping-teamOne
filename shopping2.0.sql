CREATE TABLE `product_category` (
`cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品分类id',
`cname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品分类名字',
`cxinhao` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品类型',
PRIMARY KEY (`cid`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 2
AVG_ROW_LENGTH = 0
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
KEY_BLOCK_SIZE = 0
MAX_ROWS = 0
MIN_ROWS = 0
ROW_FORMAT = Compact;
CREATE TABLE `user` (
`uid` int(255) NOT NULL AUTO_INCREMENT COMMENT '用户id',
`uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
`upasswd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
`uemail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
`usex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
`birthday` date NULL DEFAULT NULL COMMENT '出生日期',
`uphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
`uaddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
`balance` float(255,0) UNSIGNED NULL DEFAULT 0 COMMENT '余额',
`discount` tinyint(1) NULL DEFAULT 100 COMMENT '折扣',
`integral` int(255) NULL DEFAULT 0 COMMENT '积分',
PRIMARY KEY (`uid`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 5
AVG_ROW_LENGTH = 0
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
KEY_BLOCK_SIZE = 0
MAX_ROWS = 0
MIN_ROWS = 0
ROW_FORMAT = Compact;
CREATE TABLE `product_item` (
`pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
`pname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名字',
`pclassifyid` int(255) NOT NULL DEFAULT 1 COMMENT '商品分类',
`pdate` date NULL DEFAULT NULL COMMENT '商品生产日期',
`Suppliers` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'ç½‘ç«™ä¾›åº”' COMMENT '供应商',
`pnumber` int(255) NULL DEFAULT 0 COMMENT '商品数量',
`price` float(254,0) NULL DEFAULT 0 COMMENT '商品价格',
PRIMARY KEY (`pid`) ,
INDEX `product_cid` (`pclassifyid` ASC) USING BTREE
)
ENGINE = InnoDB
AUTO_INCREMENT = 2
AVG_ROW_LENGTH = 0
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
KEY_BLOCK_SIZE = 0
MAX_ROWS = 0
MIN_ROWS = 0
ROW_FORMAT = Compact;
CREATE TABLE `cart` (
`cart_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车id',
`user_id` int(11) NOT NULL COMMENT '购物车归属的用户id',
`product_id` int(11) NOT NULL COMMENT '购物车内商品id',
`cart_date` date NOT NULL COMMENT '加入商品时间',
`pnum` int(11) NOT NULL COMMENT '购物车内单件商品数量',
PRIMARY KEY (`cart_id`) ,
INDEX `userf` (`user_id` ASC) USING BTREE,
INDEX `productf` (`product_id` ASC) USING BTREE
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
AVG_ROW_LENGTH = 0
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
KEY_BLOCK_SIZE = 0
MAX_ROWS = 0
MIN_ROWS = 0
ROW_FORMAT = Compact;
CREATE TABLE `Order` (
`Order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单号',
`user_id` int(11) NULL DEFAULT NULL COMMENT '订单归属的用户id',
`Total_amount` float(255,3) NULL DEFAULT NULL COMMENT '金额总计',
`order_date` date NULL DEFAULT '2000-01-17' COMMENT '下单时间',
`order_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '已下单' COMMENT '订单状态',
`uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单唯一识别码',
PRIMARY KEY (`Order_id`) ,
INDEX `userid_f` (`user_id` ASC) USING BTREE,
INDEX `uuid` (`uuid` ASC) USING BTREE
)
ENGINE = InnoDB
AUTO_INCREMENT = 18
AVG_ROW_LENGTH = 0
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
KEY_BLOCK_SIZE = 0
MAX_ROWS = 0
MIN_ROWS = 0
ROW_FORMAT = Compact;
CREATE TABLE `Order_item` (
`Oid` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单项id',
`user_id` int(11) NULL DEFAULT NULL COMMENT '订单项归属用户id',
`product_id` int(11) NULL DEFAULT NULL COMMENT '当前订单项商品Id',
`order_num` int(11) NULL DEFAULT NULL COMMENT '商品下单数',
`order_Subtotal` float(255,3) NULL DEFAULT NULL COMMENT '金额小计',
`uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单表唯一识别码',
PRIMARY KEY (`Oid`) ,
INDEX `productidf` (`product_id` ASC) USING BTREE,
INDEX `useridf` (`user_id` ASC) USING BTREE,
INDEX `orderf` (`uuid` ASC) USING BTREE
)
ENGINE = InnoDB
AUTO_INCREMENT = 8
AVG_ROW_LENGTH = 0
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
KEY_BLOCK_SIZE = 0
MAX_ROWS = 0
MIN_ROWS = 0
ROW_FORMAT = Compact;

ALTER TABLE `product_item` ADD CONSTRAINT `product_cid` FOREIGN KEY (`pclassifyid`) REFERENCES `product_category` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `cart` ADD CONSTRAINT `productf` FOREIGN KEY (`product_id`) REFERENCES `product_item` (`pid`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `cart` ADD CONSTRAINT `userf` FOREIGN KEY (`user_id`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `Order` ADD CONSTRAINT `userid_f` FOREIGN KEY (`user_id`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `Order_item` ADD CONSTRAINT `useridf` FOREIGN KEY (`user_id`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `Order_item` ADD CONSTRAINT `productidf` FOREIGN KEY (`product_id`) REFERENCES `product_item` (`pid`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `Order_item` ADD CONSTRAINT `orderf` FOREIGN KEY (`uuid`) REFERENCES `Order` (`uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT;

