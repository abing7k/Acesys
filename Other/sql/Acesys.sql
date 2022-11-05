/*
 Navicat Premium Data Transfer

 Source Server         : acesys
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : 47.99.49.255:3307
 Source Schema         : acesys

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 05/11/2022 18:26:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for can_registered
-- ----------------------------
DROP TABLE IF EXISTS `can_registered`;
CREATE TABLE `can_registered`  (
                                   `registered` int(0) NULL DEFAULT NULL COMMENT '能否注册,1代表能, 0代表不能',
                                   `id` int(0) NOT NULL AUTO_INCREMENT,
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of can_registered
-- ----------------------------
INSERT INTO `can_registered` VALUES (1, 1);

-- ----------------------------
-- Table structure for mailtb
-- ----------------------------
DROP TABLE IF EXISTS `mailtb`;
CREATE TABLE `mailtb`  (
                           `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '表示邮件ID，是自动递增的主键',
                           `fromaddress` varchar(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示发邮件地址',
                           `frompassword` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示发邮件密码',
                           `toaddress` varchar(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示收邮件地址',
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mailtb
-- ----------------------------
INSERT INTO `mailtb` VALUES (1, '2773243141@qq.com', '2773243141@qq.com', '2773243141@qq.com');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
                         `id` int(0) NOT NULL,
                         `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                         `del_flag` int(0) NULL DEFAULT 0,
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '/admin/**', 0);
INSERT INTO `menu` VALUES (2, '/vip/**', 0);

-- ----------------------------
-- Table structure for menu_role
-- ----------------------------
DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role`  (
                              `id` int(0) NOT NULL,
                              `rid` int(0) NOT NULL,
                              `mid` int(0) NOT NULL,
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_role
-- ----------------------------
INSERT INTO `menu_role` VALUES (1, 1, 1);
INSERT INTO `menu_role` VALUES (2, 2, 2);

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem`  (
                              `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '表示订单项ID，是自动递增的主键',
                              `oid` int(0) NULL DEFAULT NULL COMMENT '表示订单ID',
                              `pid` int(0) NULL DEFAULT NULL COMMENT '表示商品ID',
                              `number` float(50, 0) NULL DEFAULT NULL COMMENT '表示商品质量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES (1, 1, 1, 1);
INSERT INTO `orderitem` VALUES (2, 3, 1, 1);
INSERT INTO `orderitem` VALUES (3, 4, 1, 1);
INSERT INTO `orderitem` VALUES (4, 5, 1, 0);
INSERT INTO `orderitem` VALUES (5, 6, 1, 0);
INSERT INTO `orderitem` VALUES (6, 7, 1, 0);
INSERT INTO `orderitem` VALUES (7, 8, 1, 1);
INSERT INTO `orderitem` VALUES (8, 9, 2, 2);
INSERT INTO `orderitem` VALUES (9, 10, 1, 12);
INSERT INTO `orderitem` VALUES (10, 11, 2, 2);
INSERT INTO `orderitem` VALUES (11, 12, 1, 1);
INSERT INTO `orderitem` VALUES (12, 13, 2, 2);
INSERT INTO `orderitem` VALUES (13, 14, 2, 2);
INSERT INTO `orderitem` VALUES (14, 15, 2, 2);
INSERT INTO `orderitem` VALUES (15, 17, 2, 4);
INSERT INTO `orderitem` VALUES (16, 18, 2, 5);
INSERT INTO `orderitem` VALUES (17, 19, 1, 1);
INSERT INTO `orderitem` VALUES (18, 20, 1, 12);
INSERT INTO `orderitem` VALUES (19, 25, 1, 3);
INSERT INTO `orderitem` VALUES (20, 28, 2, 7);
INSERT INTO `orderitem` VALUES (21, 29, 2, 8);
INSERT INTO `orderitem` VALUES (22, 30, 2, 9);
INSERT INTO `orderitem` VALUES (23, 32, 1, 10);
INSERT INTO `orderitem` VALUES (24, 33, 3, 1);
INSERT INTO `orderitem` VALUES (25, 34, 1, 20);
INSERT INTO `orderitem` VALUES (26, 35, 2, 1);
INSERT INTO `orderitem` VALUES (27, 36, 4, 5);
INSERT INTO `orderitem` VALUES (28, 37, 1, 6);
INSERT INTO `orderitem` VALUES (29, 38, 1, 12);
INSERT INTO `orderitem` VALUES (30, 39, 1, 1);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
                           `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '表示订单ID，是自动递增的主键',
                           `uid` int(0) NULL DEFAULT NULL COMMENT '表示客户标识号',
                           `datetime` date NULL DEFAULT NULL COMMENT '表示生成订单的时间',
                           `del_flag` int(0) NULL DEFAULT 0 COMMENT '1代表删除,0代表未删除',
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, 1, '2022-11-04', 0);
INSERT INTO `orders` VALUES (3, 1, '2022-11-04', 1);
INSERT INTO `orders` VALUES (4, NULL, '2022-11-04', 0);
INSERT INTO `orders` VALUES (5, 2, '2022-11-05', 1);
INSERT INTO `orders` VALUES (6, 2, '2022-11-05', 1);
INSERT INTO `orders` VALUES (7, 2, '2022-11-05', 1);
INSERT INTO `orders` VALUES (8, 2, '2022-11-05', 1);
INSERT INTO `orders` VALUES (9, 2, '2022-11-05', 1);
INSERT INTO `orders` VALUES (12, NULL, '2022-11-05', 0);
INSERT INTO `orders` VALUES (13, 2, '2022-11-05', 1);
INSERT INTO `orders` VALUES (14, 2, '2022-11-05', 1);
INSERT INTO `orders` VALUES (15, 2, '2022-11-05', 1);
INSERT INTO `orders` VALUES (16, 2, '2022-11-05', 0);
INSERT INTO `orders` VALUES (17, 2, '2022-11-05', 1);
INSERT INTO `orders` VALUES (18, 2, '2022-11-05', 0);
INSERT INTO `orders` VALUES (19, 2, '2022-11-05', 1);
INSERT INTO `orders` VALUES (20, NULL, '2022-11-05', 0);
INSERT INTO `orders` VALUES (21, 2, '2022-11-05', 0);
INSERT INTO `orders` VALUES (22, 2, '2022-11-05', 0);
INSERT INTO `orders` VALUES (23, 2, '2022-11-05', 0);
INSERT INTO `orders` VALUES (24, 2, '2022-11-05', 0);
INSERT INTO `orders` VALUES (25, 2, '2022-11-05', 1);
INSERT INTO `orders` VALUES (26, 2, '2022-11-05', 0);
INSERT INTO `orders` VALUES (27, 2, '2022-11-05', 0);
INSERT INTO `orders` VALUES (28, 2, '2022-11-05', 1);
INSERT INTO `orders` VALUES (29, 2, '2022-11-05', 1);
INSERT INTO `orders` VALUES (30, 2, '2022-11-05', 0);
INSERT INTO `orders` VALUES (31, 2, '2022-11-05', 0);
INSERT INTO `orders` VALUES (32, 2, '2022-11-05', 0);
INSERT INTO `orders` VALUES (33, 2, '2022-11-05', 1);
INSERT INTO `orders` VALUES (34, 2, '2022-11-05', 1);
INSERT INTO `orders` VALUES (35, 2, '2022-11-05', 1);
INSERT INTO `orders` VALUES (36, 2, '2022-11-05', 1);
INSERT INTO `orders` VALUES (37, 2, '2022-11-05', 1);
INSERT INTO `orders` VALUES (38, NULL, '2022-11-05', 0);
INSERT INTO `orders` VALUES (39, NULL, '2022-11-05', 0);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
                            `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '表示商品ID标识号，是自动递增的主键',
                            `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示药品类别',
                            `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示备注',
                            `product_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示商品编号',
                            `productname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示药品名称',
                            `del_flag` int(0) NULL DEFAULT 0 COMMENT '1表示删除,0表示未删除',
                            `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示分子结构图片路径名称',
                            `newproduct` int(0) NULL DEFAULT NULL COMMENT '表示是否是新产品',
                            `price1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示普通用户价格',
                            `price2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示会员优惠价格',
                            `realstock` float(255, 0) NULL DEFAULT NULL COMMENT '表示实际库存',
  `stock` float(255, 0) NULL DEFAULT NULL COMMENT '表示库存',
  `cas` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示化学文摘登记号 ',
  `catalogno` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示药品类别',
  `mdlint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示药品分类',
  `formula` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示化学方程式',
  `weight` float(255, 0) NULL DEFAULT NULL COMMENT '重量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '西药', '1', '1', '产1', 0, 'http://110.40.220.17:18001/group1/M00/00/00/CgAMDWNlMfGAEBZtAAG5YQF40YI483.PNG', 1, '123', '123', 24, 23, '13', 'RGFDG', '132', '34C', 23);
INSERT INTO `product` VALUES (2, '2', '2', '2', '产品2', 0, 'http://110.40.220.17:18001/group1/M00/00/00/CgAMDWNlHBOAX6-IAAAljlGqn0k532.png', 1, '666', '665', 100, 100, 'cas', 'cateongno', 'mdl', 'formula', 99);
INSERT INTO `product` VALUES (3, '1', '123', '1', '213', 0, 'http://110.40.220.17:18001/group1/M00/00/00/CgAMDWNlHBOAX6-IAAAljlGqn0k532.png', 1, '1232', '123', 23, 213, '21', '2343', '123', '21324', 22);
INSERT INTO `product` VALUES (4, 'wedaw', '34c135', 'wedaw', '214324', 1, 'http://110.40.220.17:18001/group1/M00/00/00/CgAMDWNlLRGAOEArAAG5YQF40YI990.PNG', 1, '100', '80', 100, 100, '431c5', 'wrrct', 'erer', 'etre ret', 95);
INSERT INTO `product` VALUES (5, '1', '1', '1', '1', 1, 'http://110.40.220.17:18001/group1/M00/00/00/CgAMDWNlLg-AGqu0AAG5YQF40YI036.PNG', 1, '100', '100', 123123, 123, '12325', '12324', '2314', '23434', 98);
INSERT INTO `product` VALUES (6, '西药', '123', '1', '2324', 0, 'http://110.40.220.17:18001/group1/M00/00/00/CgAMDWNmNxeAUFtJAA5ivhYPtDU375.png', 1, '213', '123', 213, 23, '23213', '12', '214', '124', 23);
INSERT INTO `product` VALUES (7, '546', '234', '3435', '234', 0, '', 1, '23', '22', 24, 34, '244', '56666666', '54657', '657', 243);
INSERT INTO `product` VALUES (8, '546', '234', '3435', '234', 0, 'http://110.40.220.17:18001/group1/M00/00/00/CgAMDWNmN3aAWib3AA5ivhYPtDU876.png', 1, '23', '22', 24, 34, '244', '56666666', '54657', '657', 243);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
                         `id` int(0) NOT NULL AUTO_INCREMENT,
                         `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                         `nameZh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'ROLE_admin', '管理员');
INSERT INTO `role` VALUES (2, 'ROLE_vip', '会员');

-- ----------------------------
-- Table structure for shop_cart
-- ----------------------------
DROP TABLE IF EXISTS `shop_cart`;
CREATE TABLE `shop_cart`  (
                              `id` int(0) NOT NULL AUTO_INCREMENT,
                              `pid` int(0) NULL DEFAULT NULL,
                              `uid` int(0) NULL DEFAULT NULL,
                              `number` float NULL DEFAULT NULL,
                              `del_flag` int(0) NULL DEFAULT 0,
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop_cart
-- ----------------------------
INSERT INTO `shop_cart` VALUES (1, 1, 1, 2, 1);
INSERT INTO `shop_cart` VALUES (2, 2, 2, 9, 1);
INSERT INTO `shop_cart` VALUES (4, 1, 2, 1, 1);
INSERT INTO `shop_cart` VALUES (13, 1, 2, 10, 1);
INSERT INTO `shop_cart` VALUES (14, 3, 2, 1, 1);
INSERT INTO `shop_cart` VALUES (15, 3, 2, 1, 1);
INSERT INTO `shop_cart` VALUES (16, 3, 2, 1, 1);
INSERT INTO `shop_cart` VALUES (17, 1, 2, 20, 1);
INSERT INTO `shop_cart` VALUES (18, 4, 2, 5, 1);
INSERT INTO `shop_cart` VALUES (19, 1, 2, 6, 1);

-- ----------------------------
-- Table structure for user_product
-- ----------------------------
DROP TABLE IF EXISTS `user_product`;
CREATE TABLE `user_product`  (
                                 `id` int(0) NOT NULL AUTO_INCREMENT,
                                 `usrid` int(0) NULL DEFAULT NULL,
                                 `productid` int(0) NULL DEFAULT NULL,
                                 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_product
-- ----------------------------

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
                              `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
                              `uid` int(0) NOT NULL,
                              `rid` int(0) NOT NULL,
                              `del_flag` int(0) NOT NULL DEFAULT 0,
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1, 1);
INSERT INTO `user_role` VALUES (2, 2, 2, 0);
INSERT INTO `user_role` VALUES (3, 3, 2, 0);
INSERT INTO `user_role` VALUES (5, 5, 1, 0);
INSERT INTO `user_role` VALUES (6, 6, 1, 1);
INSERT INTO `user_role` VALUES (7, 7, 1, 1);
INSERT INTO `user_role` VALUES (8, 8, 1, 0);
INSERT INTO `user_role` VALUES (10, 13, 1, 0);
INSERT INTO `user_role` VALUES (11, 14, 1, 0);
INSERT INTO `user_role` VALUES (12, 15, 1, 1);
INSERT INTO `user_role` VALUES (13, 17, 1, 1);
INSERT INTO `user_role` VALUES (14, 19, 1, 1);
INSERT INTO `user_role` VALUES (15, 20, 1, 1);
INSERT INTO `user_role` VALUES (16, 21, 1, 1);
INSERT INTO `user_role` VALUES (17, 22, 1, 1);

-- ----------------------------
-- Table structure for usr
-- ----------------------------
DROP TABLE IF EXISTS `usr`;
CREATE TABLE `usr`  (
                        `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '表示用户ID标识号，是自动递增的主键',
                        `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示用户名称',
                        `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示用户密码(加密后)',
                        `companyname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示用户公司名称',
                        `city` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示用户生活城市',
                        `job` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示用户工作',
                        `tel` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示用户电话',
                        `email` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示用户电子邮件地址',
                        `country` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示用户国家',
                        `zip` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示地区邮政编码',
                        `companyaddress` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示用户公司地址',
                        `note` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示备注',
                        `fullname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示全名',
                        `title` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示称呼',
                        `del_flag` int(0) NULL DEFAULT 0 COMMENT '1代表删除, 0代表未删除',
                        PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usr
-- ----------------------------
INSERT INTO `usr` VALUES (1, 'admin', '$2a$10$ogvUqZZAxrBwrmVI/e7.SuFYyx8my8d.9zJ6bs9lPKWvbD9eefyCe', 'aa', 'aa', 'aa', '135', '22', 'aa', 'aa', 'aa', 'aa', 'aa0', 'aa', 0);
INSERT INTO `usr` VALUES (2, 'vip', '$2a$10$ogvUqZZAxrBwrmVI/e7.SuFYyx8my8d.9zJ6bs9lPKWvbD9eefyCe', 'aa', 'aa', 'aa', '13525738519', '', 'aa', 'aa4444', 'aa', 'aa', 'aa0', 'aa', 0);
INSERT INTO `usr` VALUES (3, 'b', '$2a$10$ogvUqZZAxrBwrmVI/e7.SuFYyx8my8d.9zJ6bs9lPKWvbD9eefyCe', 'ascent', '', '', '123456', 'lixing@163.com', '', '', '', '', '', '', 0);
INSERT INTO `usr` VALUES (5, '66', NULL, 'aa', 'aa', 'aa', '135', '22', 'aa', 'aa', 'aa', 'aa', 'aa0', 'aa', 0);
INSERT INTO `usr` VALUES (6, '666', NULL, 'aa', 'aa', 'aa', '135', '22', 'aa', 'aa', 'aa', 'aa', 'aa0', 'aa', 1);
INSERT INTO `usr` VALUES (7, '7', '7', '7', '7', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `usr` VALUES (8, '6666', '$2a$10$njOJzOpZP3NPyHRLAV6UCut9acHgSF/4gacWlTNRvhAeLpxz.Ts5q', 'aa', 'aa', 'aa', '135', '22', 'aa', 'aa', 'aa', 'aa', 'aa0', 'aa', 0);
INSERT INTO `usr` VALUES (10, '1232323', '$2a$10$IPN5GUUIzklT9z8APZ7Y7.XG4fJuXMzneYnjuuCHd9IKCtRkQIMti', '', '233', '12324', '13403945947', '2773243141@qq.com', '中国', '466000', '河南省周口市', '1232', '143545', '1346', 0);
INSERT INTO `usr` VALUES (11, '2132144', '$2a$10$pojSawFd/evY7jHgWpVE0Or09yJnJUVTIi/47Q12N2NzbOe9V6Vfq', '1534regfr', '周口市', '1314', '13403945947', '2773243141@qq.com', '中国', '466000', '河南省周口市', '213de', '143656', '431111114', 0);
INSERT INTO `usr` VALUES (12, '21324', '$2a$10$/FlIW5WKYTkvWw27TWzTVes2nHkIPa4D1T15wOn.xkjHxE9Hvrpla', '1534regfr', '周口市', '2cdesf', '13403945947', '2773243141@qq.com', '中国', '466000', '河南省周口市', 'sdsgfg', 'c43tv', '21x33r', 0);
INSERT INTO `usr` VALUES (13, '1', '$2a$10$WnMDjfsp2w5./JE0xQndI.9jww/Sl5stPKmtF7aEHgFHyzjUBYLKK', '1534regfr', '周口市', 'dfsaf', '13403945947', '2773243141@qq.com', '中国', '466000', '河南省周口市', 'sefraewf', '324ewfa', 'sfdsvzd', 0);
INSERT INTO `usr` VALUES (14, '1', '$2a$10$yweLl6yv50bT9i9oTBWQjeBQAbt01R6Y5S6TbH5bqU991LPHxItzi', '1534regfr', '周口市', '', '13403945947', '2773243141@qq.com', '中国', '466000', '河南省周口市', '', 'a2ce', 'dsfd', 0);
INSERT INTO `usr` VALUES (15, '1', '$2a$10$fyXEw93zPD9YE8KAIEofZeudT6/lQx8U7auPWq5v6iNO7GKvUxWma', '', '', '', '', '', '', '', '', '', '', '', 1);
INSERT INTO `usr` VALUES (16, '123', '$2a$10$oAL2xBfl2nzGE6X4dFWLKe/guWjwBf.aDgLFDtAvhIX.ksg0QO.jS', '', '', '', '', '', '', '', '', '', '', '', 0);
INSERT INTO `usr` VALUES (17, '1', '$2a$10$wYcImGVtY6J.4CpL5tCm5uun28FWv247R/03eW3M4c/2APZkqdWxm', '', '', '', '', '', '', '', '', '', '', '', 1);
INSERT INTO `usr` VALUES (18, '123', '$2a$10$HmYmY8HGvcxbJ6wN7w7QKuFqF5/T7vYp6kWw3v2ItnZoU.nxT1T4K', '', '', '', '', '', '', '', '', '', '', '', 0);
INSERT INTO `usr` VALUES (19, '1', '$2a$10$QfZBURT6WahZ2TGUF2lP4ubKc2UVMB1r764C47ex.YFIxN5vJUbQq', '', '', '', '', '', '', '', '', '', '', '', 1);
INSERT INTO `usr` VALUES (20, '123', '$2a$10$NlLzTQ.1QUHQbbZy0dH8ruvEakL2AgqUt5uRJAvkryU0GCWIoTIx.', '', '', '', '', '', '', '', '', '', '', '', 1);
INSERT INTO `usr` VALUES (21, '1', '$2a$10$fXpF.0Xa0qIHacS5kWWewOeICGFzjiPNN/omgUn6hnhnDhld4RrYG', '', '', '', '', '', '', '', '', '', '', '', 1);
INSERT INTO `usr` VALUES (22, '1', '$2a$10$Ayc4q55jubgYe0eEdJh6e.tphHQ2kE2NGqzX.V/hInKzVug2J3roy', '', '', '', '', '', '', '', '', '', '', '', 1);

SET FOREIGN_KEY_CHECKS = 1;
