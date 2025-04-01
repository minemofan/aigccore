package org.agent.aigccore.dao.impl;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.agent.aigccore.basic.enums.ExecSystemEnum;
import org.agent.aigccore.basic.enums.TaskFlowStatusEnum;
import org.agent.aigccore.basic.enums.TaskFlowTypeEnum;
import org.agent.aigccore.dao.TaskFlowOrderRepository;
import org.agent.aigccore.dao.mappers.TaskFlowOrderMapper;
import org.agent.aigccore.model.bo.TaskFlowOrderBO;
import org.agent.aigccore.model.po.TaskFlowOrderPO;
import org.agent.aigccore.utils.HostUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public void updateChainInfo(String id, String rootTaskId
            , List<String> runUpstreamTask, List<String> runDownstreamTask, String terminalTaskId, String extInfo) {
        int num = taskFlowOrderMapper.updateChainInfo(id, rootTaskId, runUpstreamTask, runDownstreamTask, terminalTaskId, extInfo);
        log.info("[TaskFlowOrderRepository.updateChainInfo] 更新成功！num={}", num);
    }

    @Override
    public List<TaskFlowOrderBO> page(TaskFlowStatusEnum status, ExecSystemEnum execSystem, int offset, int pageSize) {
        List<TaskFlowOrderPO> pos = taskFlowOrderMapper.page(status.getCode()
                , HostUtil.getDefaultProd(), execSystem.getCode(), offset, pageSize);
        log.info("[TaskFlowOrderRepository.page] 召回数量={}", pos.size());
        return pos.stream().map(po -> convert.formPO(po)).collect(Collectors.toList());
    }

    @Override
    public List<TaskFlowOrderBO> pageWhitelistBizType(TaskFlowStatusEnum status
            , ExecSystemEnum execSystem, List<String> bizTypeWhitelist, int offset, int pageSize) {
        List<TaskFlowOrderPO> pos = taskFlowOrderMapper.pageWhitelistBizType(status.getCode()
                , HostUtil.getDefaultProd(), execSystem.getCode(), bizTypeWhitelist, offset, pageSize);
        log.info("[TaskFlowOrderRepository.pageWhitelistBizType] 召回数量={}", pos.size());
        return pos.stream().map(po -> convert.formPO(po)).collect(Collectors.toList());
    }

    @Override
    public List<TaskFlowOrderBO> query(TaskFlowTypeEnum bizType, String bizId, String userId) {
        List<TaskFlowOrderPO> pos = taskFlowOrderMapper.query(bizType.getCode(), bizId, userId);
        log.info("[TaskFlowOrderRepository.query] 召回数量={}", pos.size());
        return pos.stream().map(po -> convert.formPO(po)).collect(Collectors.toList());
    }

    /**
     * @param orderBO
     */
    private void checkDataIntegrality(TaskFlowOrderBO orderBO) {

    }
}
