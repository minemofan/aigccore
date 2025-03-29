package org.agent.aigccore.utils;

import org.agent.aigccore.basic.Global;

public class FormatUtil {

    public static String format(String message, Object... params) {
        if (params != null && params.length != 0) {
            for (int i = 0; i < params.length; i++) {
                String placeholder = Global.BRACES_LEFT + i + Global.BRACES_RIGHT;
                message = message.replace(placeholder, String.valueOf(params[i]));
            }
        }
        return StringUtil.EMPTY;
    }
}
