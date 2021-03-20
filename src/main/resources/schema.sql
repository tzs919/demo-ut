--DROP DATABASE IF EXISTS exampledb;
--CREATE DATABASE exampledb DEFAULT CHARACTER SET utf8;
--USE exampledb;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'tzs', '112233');
INSERT INTO `tb_user` VALUES ('2', 'laoli', '123456');