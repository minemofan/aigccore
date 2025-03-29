package org.agent.aigccore.basic.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public enum CalendarCycleEnum {
    EVERY_DAY("每天，execTime时间执行"),
    WEEKLY_NUM("每周x，execTime时间执行"),
    MONTH_NUM("每月x号，execTime时间执行（29、30、31均表示当月最后一天执行！）"),
    MANY_DAYS("间隔x天，execTime时间执行"),
    ;

    private String code;

    private String desc;

    CalendarCycleEnum(String desc) {
        this.code = name();
        this.desc = desc;
    }
}
