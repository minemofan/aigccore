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
     *
     * @param id 任务流订单 ID
     * @return 任务流订单实体
     */
    TaskFlowOrderPO load(@Param("id") String id);

    /**
     * 根据 ID 查询任务流订单
     *
     * @param id 任务流订单 ID
     * @return 任务流订单实体
     */
    TaskFlowOrderPO lock(@Param("id") String id);

    /**
     * 根据 bizId 和 bizType 查询任务流订单列表
     *
     * @param bizId   业务 ID
     * @param bizType 业务类型
     * @return 任务流订单列表
     */
    List<TaskFlowOrderPO> loadUK(@Param("bizId") String bizId, @Param("bizType") String bizType);

    /**
     * 新增任务流订单
     *
     * @param taskFlowOrderPO 任务流订单实体
     * @return 插入记录数
     */
    int insert(TaskFlowOrderPO taskFlowOrderPO);

    /**
     * 更新任务流订单
     *
     * @param taskFlowOrderPO 任务流订单实体
     * @return 更新记录数
     */
    int update(TaskFlowOrderPO taskFlowOrderPO);

    /**
     * 根据 ID 删除任务流订单
     *
     * @param id 任务流订单 ID
     * @return 删除记录数
     */
    int delete(@Param("id") Long id);

    /**
     * 更新任务流订单的链信息
     *
     * @param id                任务流订单 ID
     * @param rootTaskId        根任务 ID
     * @param runUpstreamTask   是否运行上游任务
     * @param runDownstreamTask 是否运行下游任务
     * @param terminalTaskId    终端任务 ID
     * @param extInfo           扩展信息
     * @return 更新记录数
     */
    int updateChainInfo(
            @Param("id") Long id,
            @Param("rootTaskId") String rootTaskId,
            @Param("runUpstreamTask") Boolean runUpstreamTask,
            @Param("runDownstreamTask") Boolean runDownstreamTask,
            @Param("terminalTaskId") String terminalTaskId,
            @Param("extInfo") String extInfo
    );

    /**
     * 分页查询任务流订单
     *
     * @param status     任务流订单状态
     * @param env        环境
     * @param execSystem 执行系统
     * @param offset     偏移量
     * @param pageSize   每页数量
     * @return 任务流订单列表
     */
    List<TaskFlowOrderPO> page(
            @Param("status") String status,
            @Param("env") String env,
            @Param("execSystem") String execSystem,
            @Param("offset") int offset,
            @Param("pageSize") int pageSize
    );

    /**
     * 带白名单业务类型的分页查询任务流订单
     *
     * @param status           任务流订单状态
     * @param env              环境
     * @param execSystem       执行系统
     * @param bizTypeWhitelist 业务类型白名单
     * @param offset           偏移量
     * @param pageSize         每页数量
     * @return 任务流订单列表
     */
    List<TaskFlowOrderPO> pageWhitelistBizType(
            @Param("status") String status,
            @Param("env") String env,
            @Param("execSystem") String execSystem,
            @Param("bizTypeWhitelist") List<String> bizTypeWhitelist,
            @Param("offset") int offset,
            @Param("pageSize") int pageSize
    );

    /**
     * 根据条件查询任务流订单
     *
     * @param bizType 业务类型
     * @param bizId   业务 ID
     * @param userId  用户 ID
     * @return 任务流订单列表
     */
    List<TaskFlowOrderPO> query(
            @Param("bizType") String bizType,
            @Param("bizId") String bizId,
            @Param("userId") String userId
    );
}