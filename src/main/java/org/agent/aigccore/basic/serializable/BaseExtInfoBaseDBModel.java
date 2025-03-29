package org.agent.aigccore.basic.serializable;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Setter
@Getter
public class BaseExtInfoBaseDBModel extends BaseExtInfoBaseModel {

    private Long id;
    private Date gmtCreate;
    private Date gmtModified;

    /**
     * @return
     */
    public String getIdStr() {
        return Objects.isNull(id) ? null : String.valueOf(id);
    }
}
