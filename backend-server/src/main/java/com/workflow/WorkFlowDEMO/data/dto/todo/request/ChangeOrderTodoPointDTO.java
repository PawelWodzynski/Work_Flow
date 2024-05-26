package com.workflow.WorkFlowDEMO.data.dto.todo.request;

import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.NotNullIdValidation;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.NumberValidation;

public class ChangeOrderTodoPointDTO {
    @NotNullIdValidation
    private Integer todoPointId;
    @NumberValidation
    private Integer order;

    public ChangeOrderTodoPointDTO(Integer todoPointId, Integer order) {
        this.todoPointId = todoPointId;
        this.order = order;
    }

    public Integer getTodoPointId() {
        return todoPointId;
    }

    public void setTodoPointId(Integer todoPointId) {
        this.todoPointId = todoPointId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
