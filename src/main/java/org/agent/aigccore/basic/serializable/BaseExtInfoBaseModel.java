package org.agent.aigccore.basic.serializable;

import lombok.Getter;
import lombok.Setter;
import org.agent.aigccore.basic.enums.ExtAttributeEnum;

import java.util.Map;

@Setter
@Getter
public class BaseExtInfoBaseModel extends BaseSerializableObject{

    /**
     * 扩展信息
     * @see ExtAttributeEnum
     */
    private Map<String, Object> extInfo;

}
