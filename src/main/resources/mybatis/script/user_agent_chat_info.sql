SET NAMES utf8mb4;
SET
    FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user_agent_chat_info
-- ----------------------------
DROP TABLE IF EXISTS `t_user_agent_chat_info`;
CREATE TABLE `t_user_agent_chat_info`
(
    `id`            bigint        NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gmt_create`    timestamp     NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_create`    timestamp     NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `ext_info`      varchar(255)  NULL COMMENT '扩展信息',
    `user_id`       varchar(32)   NOT NULL COMMENT '用户ID',
    `agent`         varchar(32)   NOT NULL COMMENT '智能体code',
    `recent_chat`   varchar(1024) NULL COMMENT '最近对话ChatContentModel',
    `chat_hository` text          NULL COMMENT '历史对话ChatContentModel',
    `status`        varchar(32)   NOT NULL COMMENT 'CommonStatusEnum',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

SET
    FOREIGN_KEY_CHECKS = 1;