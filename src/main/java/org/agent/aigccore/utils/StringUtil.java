package org.agent.aigccore.utils;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.agent.aigccore.basic.Global;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class StringUtil extends StringUtils {

    /**
     * @param val
     * @return
     */
    public static List<String> convertListByComma(String val) {
        if (isBlank(val)) {
            return Splitter.on(Global.COMMA).splitToList(val);
        }
        return Lists.newArrayList();
    }

    /**
     *
     * @param list
     * @return
     */
    public static String convertStrByComma(List<String> list) {
        if (!CollectionUtils.isEmpty(list)) {
            return StringUtil.join(list, Global.COMMA);
        }
        return null;
    }
}
