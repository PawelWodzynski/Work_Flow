package com.workflow.WorkFlowDEMO.data.dto.todo.request;

import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.BooleanValidation;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.NotNullIdValidation;

public class ChangeCompletedTodoPointDTO {
    @NotNullIdValidation
    private Integer todoPointId;
    @BooleanValidation
    private Boolean completed;

    public ChangeCompletedTodoPointDTO(Integer todoPointId, Boolean completed) {
        this.todoPointId = todoPointId;
        this.completed = completed;
    }

    public Integer getTodoPointId() {
        return todoPointId;
    }

    public void setTodoPointId(Integer todoPointId) {
        this.todoPointId = todoPointId;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
