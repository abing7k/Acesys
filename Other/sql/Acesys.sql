/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : acesys

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 02/11/2022 22:58:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mailtb
-- ----------------------------
INSERT INTO `mailtb` VALUES (1, 'admin@163.com', 'C2008119521', 'guest@163.com');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem`  (
                              `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '表示订单项ID，是自动递增的主键',
                              `ordersid` int(0) NULL DEFAULT NULL COMMENT '表示订单ID',
                              `productid` int(0) NULL DEFAULT NULL COMMENT '表示商品ID',
                              `quantity` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示商品质量',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orderitem
-- ----------------------------

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
                           `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '表示订单ID，是自动递增的主键',
                           `usrid` int(0) NULL DEFAULT NULL COMMENT '表示客户标识号',
                           `datetime` date NULL DEFAULT NULL COMMENT '表示生成订单的时间',
                           `del_flag` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '1代表删除,0代表未删除',
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------

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
                            `del_flag` int(0) NULL DEFAULT NULL COMMENT '1表示删除,0表示未删除',
                            `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示分子结构图片路径名称',
                            `newproduct` int(0) NULL DEFAULT NULL COMMENT '表示是否是新产品',
                            `price1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示普通用户价格',
                            `price2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示会员优惠价格',
                            `realstock` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示实际库存',
                            `stock` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示库存',
                            `cas` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示化学文摘登记号 ',
                            `catalogno` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示药品类别',
                            `mdlint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示药品分类',
                            `formula` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示化学方程式',
                            `weight` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '重量',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------

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
                              `role` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '表示用户权限标志1.普通注册用户2.高权限用户3.管理员',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, '普通注册用户');
INSERT INTO `user_role` VALUES (2, '高权限用户');
INSERT INTO `user_role` VALUES (3, '管理员');

-- ----------------------------
-- Table structure for usr
-- ----------------------------
DROP TABLE IF EXISTS `usr`;
CREATE TABLE `usr`  (
                        `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '表示用户ID标识号，是自动递增的主键',
                        `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示用户名称',
                        `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示用户密码(加密后)',
                        `companyname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示用户公司名称',
                        `city` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示用户生活城市',
                        `job` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示用户工作',
                        `tel` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示用户电话',
                        `email` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示用户电子邮件地址',
                        `country` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示用户国家',
                        `zip` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示地区邮政编码',
                        `companyaddress` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示用户公司地址',
                        `superuser` int(0) NULL DEFAULT NULL COMMENT '表示用户权限标志1.普通注册用户2.高权限用户3.管理员',
                        `note` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示备注',
                        `fullname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示全名',
                        `title` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示称呼',
                        `del_flag` int(0) NULL DEFAULT NULL COMMENT '1代表删除, 0代表未删除',
                        PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usr
-- ----------------------------
INSERT INTO `usr` VALUES (1, 'admin', '123456', 'aa', 'aa', 'aa', '135', '22', 'aa', 'aa', 'aa', 3, 'aa', 'aa0', 'aa', 0);
INSERT INTO `usr` VALUES (2, 'lixing', 'lixing', 'ascent', '', '', '123456', 'lixing@163.com', '', '', 'ascent', 2, '', '', '', 0);
INSERT INTO `usr` VALUES (3, 'ascent', 'ascent', '', '', '', '123456', 'lixing@163.com', '', '', '', 1, '', '', '', 0);
INSERT INTO `usr` VALUES (4, 'shang', 'shang', 'ascent', '', '', '1213', 'lixing051116@163.com', '', '100085', '', 1, '', 'dfdf', '', 0);

SET FOREIGN_KEY_CHECKS = 1;
