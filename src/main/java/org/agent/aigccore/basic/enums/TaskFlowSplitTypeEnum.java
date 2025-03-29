package org.agent.aigccore.basic.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.agent.aigccore.utils.FormatUtil;

@Slf4j
@Getter
@AllArgsConstructor
public enum TaskFlowSplitTypeEnum {
    SINGLE("单库模式"),
    MULTIPLE("分库模式"),
    ;

    private String code;

    private String desc;

    TaskFlowSplitTypeEnum(String desc) {
        this.code = name();
        this.desc = desc;
    }
}
