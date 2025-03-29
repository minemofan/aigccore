DROP TABLE IF EXISTS `aigc_task_flow_order`;
CREATE TABLE `aigc_task_flow_order`
(
    `id`                    bigint(20) unsigned              NOT NULL AUTO_INCREMENT COMMENT '主键',
    `gmt_create`            timestamp                        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`          timestamp                        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `status`                varchar(64) COLLATE utf8mb4_bin           DEFAULT NULL COMMENT '任务状态TaskFlowStatusEnum',
    `ext_info`              varchar(24576) COLLATE utf8mb4_bin        DEFAULT NULL COMMENT '扩展信息',
    `name`                  varchar(256) COLLATE utf8mb4_bin          DEFAULT NULL COMMENT '默认TaskFlowTypeEnum#desc',
    `biz_id`                varchar(256) COLLATE utf8mb4_bin NOT NULL COMMENT '业务ID',
    `biz_type`              varchar(128) COLLATE utf8mb4_bin NOT NULL COMMENT '业务类型TaskFlowTypeEnum',
    `exec_num`              int(11)                                   DEFAULT NULL COMMENT '执行次数',
    `fail_num`              smallint(6)                               DEFAULT NULL COMMENT '失败次数',
    `start_exec_time`       timestamp                        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '执行开始时间',
    `last_exec_time`        timestamp                        NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '最后执行时间',
    `deadline_exec_time`    timestamp                        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '执行截止时间',
    `run_mode`              varchar(64) COLLATE utf8mb4_bin  NOT NULL DEFAULT 'DEFAULT' COMMENT '运行模式TaskFlowRunModeEnum',
    `run_mode_rule`         varchar(4096) COLLATE utf8mb4_bin         DEFAULT NULL COMMENT '运行规则TaskFlowRunModeRule',
    `root_task_id`          varchar(128) COLLATE utf8mb4_bin          DEFAULT NULL COMMENT '根taskflowId',
    `root_task_type`        varchar(256) COLLATE utf8mb4_bin          DEFAULT NULL COMMENT '根taskflow类型',
    `run_upstream_task`     varchar(128) COLLATE utf8mb4_bin          DEFAULT NULL COMMENT '运行时依赖的上游节点(id逗号分隔)',
    `run_downstream_task`   varchar(128) COLLATE utf8mb4_bin          DEFAULT NULL COMMENT '运行时待激活的下游节点(id逗号分隔)',
    `out_biz_id`            varchar(256) COLLATE utf8mb4_bin          DEFAULT NULL COMMENT '外部业务ID（剧本等）',
    `out_biz_flag`          varchar(256) COLLATE utf8mb4_bin          DEFAULT NULL COMMENT '外部业务标志',
    `out_biz_data`          varchar(65535) COLLATE utf8mb4_bin        DEFAULT NULL COMMENT '外部业务数据',
    `env`                   varchar(32) COLLATE utf8mb4_bin           DEFAULT 'PROD' COMMENT '环境隔离标，默认PROD',
    `user_id`               varchar(128) COLLATE utf8mb4_bin NOT NULL COMMENT '用户ID',
    `data_version`          varchar(128) COLLATE utf8mb4_bin          DEFAULT NULL COMMENT '依赖数据版本（用于支持重跑数据）',
    `source`                varchar(256) COLLATE utf8mb4_bin          DEFAULT NULL COMMENT '来源（策略等）',
    `exec_system`           varchar(256) COLLATE utf8mb4_bin          DEFAULT 'aigccore' COMMENT '业务运行系统，默aigccore',
    `first_exec_time`       timestamp                        NULL     DEFAULT NULL COMMENT '首次执行时间',
    `terminal_task_id`      varchar(128) COLLATE utf8mb4_bin          DEFAULT NULL COMMENT '终端节点',
    `terminal_task_type`    varchar(256) COLLATE utf8mb4_bin          DEFAULT NULL COMMENT '终端节点TYPE',
    `auto_trigger`          tinyint(4)                                DEFAULT NULL COMMENT '自动触发，默认自动触发',
    `content_security_data` varchar(65535) COLLATE utf8mb4_bin        DEFAULT NULL COMMENT '安全相关结果',
    `chain_code`            varchar(128) COLLATE utf8mb4_bin          DEFAULT NULL COMMENT '链节点code',
    `private_node_data`     text COLLATE utf8mb4_bin                  DEFAULT NULL COMMENT '节点私有数据',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_aigc_task_flow_order_env` (`biz_id`, `biz_type`, `env`, `user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT = '开放统一调度引擎流水'
  COLLATE = utf8mb4_0900_ai_ci;
SET FOREIGN_KEY_CHECKS = 1;