package com.workflow.WorkFlowDEMO.data.dto.todo.request;

import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.NotNullIdValidation;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.NumberValidation;

public class ChangeOrderExtendedPointDTO {

    @NotNullIdValidation
    private Integer todoExtendedPointId;
    @NumberValidation
    private Integer order;

    public ChangeOrderExtendedPointDTO(Integer todoExtendedPointId, Integer order) {
        this.todoExtendedPointId = todoExtendedPointId;
        this.order = order;
    }

    public Integer getTodoExtendedPointId() {
        return todoExtendedPointId;
    }

    public void setTodoExtendedPointId(Integer todoExtendedPointId) {
        this.todoExtendedPointId = todoExtendedPointId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
