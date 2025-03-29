package org.agent.aigccore.model.bo;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.agent.aigccore.basic.Global;
import org.agent.aigccore.basic.enums.TaskFlowRunRuleEnum;
import org.agent.aigccore.basic.enums.TaskFlowSplitTypeEnum;
import org.agent.aigccore.basic.enums.TaskFlowStatusEnum;
import org.agent.aigccore.basic.enums.TaskFlowTypeEnum;
import org.agent.aigccore.basic.serializable.BaseExtInfoBaseDBModel;
import org.agent.aigccore.basic.serializable.CustomConverter;
import org.agent.aigccore.model.dto.TaskFlowRunRuleMode;
import org.agent.aigccore.model.po.TaskFlowOrderPO;
import org.agent.aigccore.utils.StringUtil;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Setter
@Getter
public class TaskFlowOrderBO extends BaseExtInfoBaseDBModel {
    // ====== 基础信息
    private String bizId;
    private TaskFlowTypeEnum bizType;
    private String name;
    private TaskFlowStatusEnum status;
    private String userId;
    private TaskFlowSplitTypeEnum splitType;
    private Map<String, Object> chainData;

    // ====== 运行模式
    private TaskFlowRunRuleEnum runRule;
    private TaskFlowRunRuleMode runRuleMode;

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
    private List<String> runUpstreamTask;
    private List<String> runDownstreamTask;

    // ====== 外部业务信息
    private String chainAlias;
    private String outBizId;
    private String outBizFlag;
    private Map<String, Object> outBizData;
    private String source = Global.APP_NAME;


    // ====== 其他
    private String env;
    private String dt;
    private String execSystem;
    private Integer autoTrigger;


    // ============================== 转换器
    public static Convert convert = Mappers.getMapper(Convert.class);

    @Mapper(uses = CustomConverter.class)
    @DecoratedWith(AbstractDecoder.class)
    public interface Convert {
        @Mappings({@Mapping(target = "runRuleMode", ignore = true)
                , @Mapping(target = "runUpstreamTask", ignore = true)
                , @Mapping(target = "runDownstreamTask", ignore = true)
                , @Mapping(target = "chainData", ignore = true)
                , @Mapping(target = "outBizData", ignore = true)})
        TaskFlowOrderBO formPO(TaskFlowOrderPO po);

        @Mappings({@Mapping(target = "runRuleMode", ignore = true)
                , @Mapping(target = "runUpstreamTask", ignore = true)
                , @Mapping(target = "runDownstreamTask", ignore = true)
                , @Mapping(target = "chainData", ignore = true)
                , @Mapping(target = "outBizData", ignore = true)})
        TaskFlowOrderPO toPO(TaskFlowOrderBO bo);
    }

    public static abstract class AbstractDecoder implements Convert {
        private final Convert convert;

        public AbstractDecoder(Convert convert) {
            this.convert = convert;
        }

        @Override
        public TaskFlowOrderBO formPO(TaskFlowOrderPO po) {
            TaskFlowOrderBO bo = convert.formPO(po);
            if (Objects.nonNull(bo)) {
                bo.setName(StringUtil.isBlank(po.getName()) ? bo.getBizType().getDesc() : po.getName());
                bo.setChainData(JSON.parseObject(po.getChainData(), Map.class));
                bo.setOutBizData(JSON.parseObject(po.getOutBizData(), Map.class));
                bo.setRunUpstreamTask(StringUtil.convertListByComma(po.getRunUpstreamTask()));
                bo.setRunDownstreamTask(StringUtil.convertListByComma(po.getRunDownstreamTask()));
                bo.setRunRuleMode(JSON.parseObject(po.getRunRuleMode(), TaskFlowRunRuleMode.class));
            }
            return bo;
        }

        @Override
        public TaskFlowOrderPO toPO(TaskFlowOrderBO bo) {
            TaskFlowOrderPO po = convert.toPO(bo);
            if (Objects.nonNull(po)) {
                po.setChainData(JSON.toJSONString(bo.getChainData()));
                po.setOutBizData(JSON.toJSONString(bo.getOutBizData()));
                po.setRunUpstreamTask(StringUtil.convertStrByComma(bo.getRunUpstreamTask()));
                po.setRunDownstreamTask(StringUtil.convertStrByComma(bo.getRunDownstreamTask()));
                po.setRunRuleMode(JSON.toJSONString(bo.getRunRuleMode()));
            }
            return po;
        }
    }
}
