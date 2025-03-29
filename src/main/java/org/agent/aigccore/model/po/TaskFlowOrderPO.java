package org.agent.aigccore.model.po;

import lombok.Getter;
import lombok.Setter;
import org.agent.aigccore.basic.serializable.BasePOBaseModel;

import java.util.Date;

@Setter
@Getter
public class TaskFlowOrderPO extends BasePOBaseModel {

    // ====== 基础信息
    private String bizId;
    private String bizType;
    private String name;
    private String status;
    private String userId;
    private String splitType;
    private String chainData;

    // ====== 运行模式
    private String runRule;
    private String runRuleMode;

    // ====== 运行信息
    private Integer execNum;
    private Integer failNum;
    private Date startExecTime;
    private Date deadlineExecTime;
    private Date firstExecTime;
    private Date lastExecTime;

    // ====== 链信息
    private String rootTaskId;
    private String terminalTaskId;
    private String runUpstreamTask;
    private String runDownstreamTask;

    // ====== 外部业务信息
    private String chainAlias;
    private String outBizId;
    private String outBizFlag;
    private String outBizData;
    private String source;


    // ====== 其他
    private String env;
    private String dt;
    private String execSystem;
    private Integer autoTrigger;
}
