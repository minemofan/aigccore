package org.agent.aigccore.dao.impl;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.agent.aigccore.dao.TaskFlowOrderRepository;
import org.agent.aigccore.dao.mappers.TaskFlowOrderMapper;
import org.agent.aigccore.model.bo.TaskFlowOrderBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.agent.aigccore.model.bo.TaskFlowOrderBO.convert;

@Slf4j
@Setter
@Component
public class TaskFlowOrderRepositoryImpl implements TaskFlowOrderRepository {

    @Autowired
    private TaskFlowOrderMapper taskFlowOrderMapper;

    @Override
    public TaskFlowOrderBO load(String id, boolean lock) {
        if (lock) {
            return convert.formPO(taskFlowOrderMapper.lock(id));
        }
        return convert.formPO(taskFlowOrderMapper.load(id));
    }
}
