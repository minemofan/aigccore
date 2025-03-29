SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
-- mysql -u root -p
--
-- SHOW DATABASES
-- ----------------------------
-- Table structure for t_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info`
(
    `user_id`  varchar(64) NOT NULL COMMENT '账号',
    `password` varchar(32) NOT NULL COMMENT '密码',
    `name`     varchar(32) DEFAULT NULL COMMENT '姓名',
    `id_card`  varchar(32) DEFAULT NULL COMMENT '身份证',
    `status`   varchar(32) NOT NULL COMMENT 'CommonStatusEnum',
    PRIMARY KEY (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;
