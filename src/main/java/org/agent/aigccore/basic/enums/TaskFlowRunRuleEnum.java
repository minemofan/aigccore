package org.agent.aigccore.basic.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public enum TaskFlowRunRuleEnum {
    DEFAULT("单次执行"),
    ;

    private String code;

    private String desc;

    TaskFlowRunRuleEnum(String desc) {
        this.code = name();
        this.desc = desc;
    }
}
