package org.agent.aigccore.basic.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public enum ExecSystemEnum {
    AIGC_CORE("AIGC_CORE"),
    ;

    private String code;

    private String desc;

    ExecSystemEnum(String desc) {
        this.code = name();
        this.desc = desc;
    }
}
