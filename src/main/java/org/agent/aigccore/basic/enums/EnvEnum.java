package org.agent.aigccore.basic.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public enum EnvEnum {

    PROD("PROD"),
    ;

    private String code;

    private String desc;

    EnvEnum(String desc) {
        this.code = name();
        this.desc = desc;
    }
}
