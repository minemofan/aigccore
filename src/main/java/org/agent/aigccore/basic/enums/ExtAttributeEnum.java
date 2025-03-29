package org.agent.aigccore.basic.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExtAttributeEnum {

    FLAG("标识"),

    ;

    private String code;

    private String desc;

    ExtAttributeEnum(String desc) {
        this.code = name();
        this.desc = desc;
    }
}
