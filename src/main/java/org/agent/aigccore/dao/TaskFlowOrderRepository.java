package org.agent.aigccore.dao;

import org.agent.aigccore.model.bo.TaskFlowOrderBO;

public interface TaskFlowOrderRepository {

    TaskFlowOrderBO load(String id, boolean lock);


}
