package org.agent.aigccore.model.bo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class TaskFlowOrderBO {
    private Long id;
    private Date gmtCreate;
    private Date gmtModified;
    private String status;
    private String extInfo;
    private String name;
    private String bizId;
    private String bizType;
    private Integer execNum;
    private Integer failNum;
    private Date startExecTime;
    private Date lastExecTime;
    private Date deadlineExecTime;
    private String runMode;
    private String runModeRule;
    private String rootTaskId;
    private String rootTaskType;
    private String runUpstreamTask;
    private String runDownstreamTask;
    private String outBizId;
    private String outBizFlag;
    private String outBizData;
    private String env;
    private String userId;
    private String dataVersion;
    private String source;
    private String execSystem;
    private Date firstExecTime;
    private String terminalTaskId;
    private String terminalTaskType;
    private Integer autoTrigger;
    private String contentSecurityData;
    private String chainCode;
    private String privateNodeData;
}
