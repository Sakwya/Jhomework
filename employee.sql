/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80100
 Source Host           : localhost:3306
 Source Schema         : user

 Target Server Type    : MySQL
 Target Server Version : 80100
 File Encoding         : 65001

 Date: 20/10/2023 09:08:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `menu_id` int NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`menu_id`) USING BTREE,
  UNIQUE INDEX `menu_id`(`menu_id`) USING BTREE,
  UNIQUE INDEX `menu_name`(`menu_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of menu
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `account` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` char(40) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `email` varchar(40) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `password`(`password`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1,'KEYLUN','张吉惟',SHA('000001'),'il6iag77bfd5m@foxmail.com');
INSERT INTO `user` VALUES (2,'magi34','林国瑞',SHA('000002'),'zif6d6et@qq.com');
INSERT INTO `user` VALUES (3,'114514beastman','林玫书',SHA('000003'),'riss7@163.com');
INSERT INTO `user` VALUES (4,'Keard','林雅南',SHA('000004'),'gyqwfofu09@126.com');
INSERT INTO `user` VALUES (5,'danticat420','江奕云',SHA('000005'),'atz4rl@outlook.com');
INSERT INTO `user` VALUES (6,'amoskandy','刘柏宏',SHA('000006'),'daln2hq3shi@hotmail.com');
INSERT INTO `user` VALUES (7,'chenge150','阮建安',SHA('000007'),'by7a388e30@foxmail.com');
INSERT INTO `user` VALUES (8,'北极熊教官','林子帆',SHA('000008'),'vneew8erx@qq.com');
INSERT INTO `user` VALUES (9,'Fate','夏志豪',SHA('000009'),'n2ovhiya4e62u@163.com');
INSERT INTO `user` VALUES (10,'Prototype','吉茹定',SHA('000010'),'t1wf4@126.com');
INSERT INTO `user` VALUES (11,'sogeth','李中冰',SHA('000011'),'9jldo4cqp2xa2@outlook.com');
INSERT INTO `user` VALUES (12,'akaicoat123','黄文隆',SHA('000012'),'uja25nz@hotmail.com');
INSERT INTO `user` VALUES (13,'Kchaos','谢彦文',SHA('000013'),'nxg9k2m3qxa@foxmail.com');
INSERT INTO `user` VALUES (14,'RepStormy','傅智翔',SHA('000014'),'u02ucwdwg@qq.com');
INSERT INTO `user` VALUES (15,'mare_mio','洪振霞',SHA('000015'),'nqcbcjj0@163.com');
INSERT INTO `user` VALUES (16,'carradio2014','刘姿婷',SHA('000016'),'l77oy9f57@126.com');
INSERT INTO `user` VALUES (17,'deepdarkpzj','荣姿康',SHA('000017'),'g5d0zd1@outlook.com');
INSERT INTO `user` VALUES (18,'Pokom','昌致盈',SHA('000018'),'7rkatd@hotmail.com');
INSERT INTO `user` VALUES (19,'白衣使者','方一强',SHA('000019'),'jvhynmgycmcca@foxmail.com');
INSERT INTO `user` VALUES (20,'yyyun','黎芸贵',SHA('000020'),'ss53zdyq0x9v@qq.com');
INSERT INTO `user` VALUES (21,'tmta','郑伊雯',SHA('000021'),'6zriyui@163.com');
INSERT INTO `user` VALUES (22,'ks33saber','雷进宝',SHA('000022'),'hzups32m8k@126.com');
INSERT INTO `user` VALUES (23,'Diana2046','吴美隆',SHA('000023'),'nubsi8h@outlook.com');
INSERT INTO `user` VALUES (24,'Teacher152','吴心真',SHA('000024'),'16waq@hotmail.com');
INSERT INTO `user` VALUES (25,'anidownloader123','王美珠',SHA('000025'),'lwrfrx54@foxmail.com');
INSERT INTO `user` VALUES (26,'b217285','郭芳天',SHA('000026'),'pemtsap9vdxiwl@qq.com');
INSERT INTO `user` VALUES (27,'yingtingyishu','李雅惠',SHA('000027'),'vswcj@163.com');
INSERT INTO `user` VALUES (28,'MotherEmperor','陈文婷',SHA('000028'),'j4x8cnfa1d@126.com');
INSERT INTO `user` VALUES (29,'Lewd-Lewd','曹敏',SHA('000029'),'2obfotuah60@outlook.com');
INSERT INTO `user` VALUES (30,'Fruit','王依婷',SHA('000030'),'sec3aeir6p5hf@hotmail.com');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  UNIQUE INDEX `user_id`(`user_id`) USING BTREE,
  UNIQUE INDEX `role_id`(`role_id`) USING BTREE,
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_role
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  UNIQUE INDEX `role_id`(`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `role_id` int NOT NULL,
  `menu_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE,
  UNIQUE INDEX `role_id`(`role_id`) USING BTREE,
  UNIQUE INDEX `menu_id`(`menu_id`) USING BTREE,
  CONSTRAINT `role_menu_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `role_menu_ibfk_2` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for spring_session
-- ----------------------------
DROP TABLE IF EXISTS `spring_session`;
CREATE TABLE `spring_session`  (
  `PRIMARY_ID` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `SESSION_ID` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `CREATION_TIME` bigint NOT NULL,
  `LAST_ACCESS_TIME` bigint NOT NULL,
  `MAX_INACTIVE_INTERVAL` int NOT NULL,
  `EXPIRY_TIME` bigint NOT NULL,
  `PRINCIPAL_NAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`PRIMARY_ID`) USING BTREE,
  UNIQUE INDEX `SPRING_SESSION_IX1`(`SESSION_ID`) USING BTREE,
  INDEX `SPRING_SESSION_IX2`(`EXPIRY_TIME`) USING BTREE,
  INDEX `SPRING_SESSION_IX3`(`PRINCIPAL_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of spring_session
-- ----------------------------

-- ----------------------------
-- Table structure for spring_session_attributes
-- ----------------------------
DROP TABLE IF EXISTS `spring_session_attributes`;
CREATE TABLE `spring_session_attributes`  (
  `SESSION_PRIMARY_ID` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL,
  PRIMARY KEY (`SESSION_PRIMARY_ID`, `ATTRIBUTE_NAME`) USING BTREE,
  CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `spring_session` (`PRIMARY_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of spring_session_attributes
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
