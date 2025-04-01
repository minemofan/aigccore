package org.agent.aigccore.utils;

import org.agent.aigccore.basic.enums.EnvEnum;

public class HostUtil {

    public static String getDefaultProd() {
        return EnvEnum.PROD.getCode();
    }
}
