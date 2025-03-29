package org.agent.aigccore.model.bo;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.agent.aigccore.basic.serializable.BaseExtInfoBaseDBModel;
import org.agent.aigccore.basic.serializable.CustomConverter;
import org.agent.aigccore.model.po.TaskFlowOrderPO;
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
    private String bizType;
    private String name;
    private String status;
    private String userId;
    private String splitType;
    private Map<String, Object> data;

    // ====== 运行模式
    private String runMode;
    private String runModeRule;

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
    private String source;


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
        @Mappings({@Mapping(target = "runModeRule", ignore = true)
                , @Mapping(target = "runUpstreamTask", ignore = true)
                , @Mapping(target = "runDownstreamTask", ignore = true)
                , @Mapping(target = "data", ignore = true)
                , @Mapping(target = "outBizData", ignore = true)})
        TaskFlowOrderBO formPO(TaskFlowOrderPO po);

        @Mappings({@Mapping(target = "runModeRule", ignore = true)
                , @Mapping(target = "runUpstreamTask", ignore = true)
                , @Mapping(target = "runDownstreamTask", ignore = true)
                , @Mapping(target = "data", ignore = true)
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
                bo.setData(JSON.parseObject(po.getData(), Map.class));
                bo.setOutBizData(JSON.parseObject(po.getOutBizData(), Map.class));
            }
            return bo;
        }

        @Override
        public TaskFlowOrderPO toPO(TaskFlowOrderBO bo) {
            return null;
        }
    }
}
