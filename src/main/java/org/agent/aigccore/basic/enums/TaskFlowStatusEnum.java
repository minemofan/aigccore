package org.agent.aigccore.basic.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public enum TaskFlowStatusEnum {
    WAIT("等待调度"),
    INIT("待执行"),
    ABORT("挂起"),
    SUCCESS("执行成功"),
    DELETE("删除"),
    ;

    private String code;

    private String desc;

    TaskFlowStatusEnum(String desc) {
        this.code = name();
        this.desc = desc;
    }
}
