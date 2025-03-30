package org.agent.aigccore.dao;

import org.agent.aigccore.basic.enums.ExecSystemEnum;
import org.agent.aigccore.basic.enums.TaskFlowStatusEnum;
import org.agent.aigccore.basic.enums.TaskFlowTypeEnum;
import org.agent.aigccore.model.bo.TaskFlowOrderBO;

import java.util.List;

public interface TaskFlowOrderRepository {

    TaskFlowOrderBO load(String id, boolean lock);

    int updateChainInfo(String id, String rootTaskId, List<String> runUpstreamTask, List<String> runDownstreamTask, String terminalTaskId, String extInfo);

    List<TaskFlowOrderBO> page(TaskFlowStatusEnum status, ExecSystemEnum execSystem, int offset, int pageSize);

    List<TaskFlowOrderBO> pageWhitelistBizType(TaskFlowStatusEnum status, ExecSystemEnum execSystem, List<String> bizTypeWhitelist, int offset, int pageSize);

    List<TaskFlowOrderBO> query(TaskFlowTypeEnum bizType, String bizId, String userId);
}
