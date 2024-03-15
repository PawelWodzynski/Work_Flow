package com.workflow.WorkFlowDEMO.data.dto.todo.request;

import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.BooleanValidation;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.NotNullIdValidation;

public class ChangeCompletedExtendedPointDTO {
    @NotNullIdValidation
    private Integer todoExtendedPointId;
    @BooleanValidation
    private Boolean completed;

    public ChangeCompletedExtendedPointDTO(Integer todoExtendedPointId, Boolean completed) {
        this.todoExtendedPointId = todoExtendedPointId;
        this.completed = completed;
    }

    public Integer getTodoExtendedPointId() {
        return todoExtendedPointId;
    }

    public void setTodoExtendedPointId(Integer todoExtendedPointId) {
        this.todoExtendedPointId = todoExtendedPointId;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
