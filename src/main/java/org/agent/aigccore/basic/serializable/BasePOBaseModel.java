package org.agent.aigccore.basic.serializable;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class BasePOBaseModel implements Serializable {
    private static final long serialVersionUID = -20250329211688666L;
    private Long id;
    private Date gmtCreate;
    private Date gmtModified;
    private String extInfo;
}
