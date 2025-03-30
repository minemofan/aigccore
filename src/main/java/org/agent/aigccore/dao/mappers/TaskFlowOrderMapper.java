package org.agent.aigccore.dao.mappers;

import org.agent.aigccore.model.po.TaskFlowOrderPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface TaskFlowOrderMapper {

    /**
     * 根据 ID 查询任务流订单
     * @param id 任务流订单 ID
     * @return 任务流订单实体
     */
    TaskFlowOrderPO load(@Param("id") String id);

    /**
     * 根据 ID 查询任务流订单
     * @param id 任务流订单 ID
     * @return 任务流订单实体
     */
    TaskFlowOrderPO lock(@Param("id") String id);

    /**
     * 根据 bizId 和 bizType 查询任务流订单列表
     * @param bizId 业务 ID
     * @param bizType 业务类型
     * @return 任务流订单列表
     */
    List<TaskFlowOrderPO> loadUK(@Param("bizId") String bizId, @Param("bizType") String bizType);

    /**
     * 新增任务流订单
     * @param taskFlowOrderPO 任务流订单实体
     * @return 插入记录数
     */
    int insert(TaskFlowOrderPO taskFlowOrderPO);

    /**
     * 更新任务流订单
     * @param taskFlowOrderPO 任务流订单实体
     * @return 更新记录数
     */
    int update(TaskFlowOrderPO taskFlowOrderPO);

    /**
     * 根据 ID 删除任务流订单
     * @param id 任务流订单 ID
     * @return 删除记录数
     */
    int delete(@Param("id") Long id);
}