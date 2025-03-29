package org.agent.aigccore.basic.serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

public abstract class BaseSerializableObject implements Serializable {

    private static final long serialVersionUID = -20250329211688999L;

    private static final Collection<String> FIELD_NAMES = new HashSet<>();

    private static String[] excludeFieldNames = new String[0];

    @Override
    public String toString() {
        return toString(this);
    }

    /**
     * 过滤字段输出
     *
     * @param obj
     * @return
     */
    public static String toString(Object obj) {
        if (FIELD_NAMES.isEmpty()) {
            return ReflectionToStringBuilder.toString(obj, ToStringStyle.SHORT_PREFIX_STYLE);
        } else {
            return new ReflectionToStringBuilder(obj, ToStringStyle.SHORT_PREFIX_STYLE)
                    .setExcludeFieldNames(excludeFieldNames).toString();
        }
    }

    /**
     * 添加过滤字段
     * @param fieldNames
     */
    public synchronized static void addAllFilterField(Collection<String> fieldNames){
        FIELD_NAMES.addAll(fieldNames);
        excludeFieldNames = FIELD_NAMES.toArray(new String[0]);
    }
}
