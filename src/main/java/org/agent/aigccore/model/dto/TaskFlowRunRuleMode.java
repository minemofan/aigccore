package org.agent.aigccore.model.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.agent.aigccore.basic.enums.CalendarCycleEnum;

@Slf4j
@Data
public class TaskFlowRunRuleMode {

    /**
     * 每次执行间隔（单位：分钟）
     */
    private Integer execIntervalMinute = 30;

    /**
     * 系统自动填写-执行描述
     */
    private String execDesc;

    /**
     * 执行时间（格式：HHmmss）
     */
    private String execTime;

    /**
     * 运行周期类型，默认：每天
     * @see CalendarCycleEnum
     */
    private String calendarCycle;

    /**
     * 执行周期类型，对应的规则
     */
    private String calendarCycleNum;
}
