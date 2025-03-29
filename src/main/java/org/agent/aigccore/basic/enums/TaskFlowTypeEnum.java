package org.agent.aigccore.basic.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.agent.aigccore.utils.FormatUtil;

@Slf4j
@Getter
@AllArgsConstructor
public enum TaskFlowTypeEnum {

    FLAG("标识"),

    ;

    private String code;

    private String desc;

    TaskFlowTypeEnum(String desc) {
        this.code = name();
        this.desc = desc;
    }

    /**
     * @param code
     * @return
     */
    public static TaskFlowTypeEnum codeOf(String code) {
        for (TaskFlowTypeEnum t : TaskFlowTypeEnum.values()) {
            if (t.getCode().equals(code)) {
                return t;
            }
        }
        throw new IllegalArgumentException(FormatUtil.format("[{0}]不是合法的枚举值", code));
    }
}
