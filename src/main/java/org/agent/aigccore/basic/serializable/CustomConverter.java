package org.agent.aigccore.basic.serializable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.agent.aigccore.utils.StringUtil;
import org.mapstruct.Named;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class CustomConverter {

    public static String map(JSONPObject jo) {
        return Optional.ofNullable(jo).map(j -> j.toJSONString()).orElse(null);
    }

    public static Long toLong(Date date) {
        return Optional.ofNullable(date).map(Date::getTime).orElse(null);
    }

    public static Date toDate(Long timeStamp) {
        return Optional.ofNullable(timeStamp).map(x -> new Date(timeStamp)).orElse(null);
    }

    @Named("mapToString")
    public static String mapToString(Map<String, String> map) {
        return Optional.ofNullable(map).map(JSON::toJSONString).orElse(StringUtil.EMPTY);
    }

    @Named("listToString")
    public static String listToString(List<String> list) {
        return StringUtil.convertStrByComma(list);
    }

    @Named("strSplitToList")
    public static List<String> strSplitToList(String s) {
        return StringUtil.convertListByComma(s);
    }

}
