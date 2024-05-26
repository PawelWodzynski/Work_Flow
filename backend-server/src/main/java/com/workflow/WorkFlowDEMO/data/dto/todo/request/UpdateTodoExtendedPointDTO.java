package com.workflow.WorkFlowDEMO.data.dto.todo.request;

import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.ContentValidation;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.NotNullIdValidation;

public class UpdateTodoExtendedPointDTO {
    @NotNullIdValidation
    private Integer todoExtendedPointId;
    @ContentValidation
    private String content;

    public UpdateTodoExtendedPointDTO(Integer todoExtendedPointId, String content) {
        this.todoExtendedPointId = todoExtendedPointId;
        this.content = content;
    }

    public Integer getTodoExtendedPointId() {
        return todoExtendedPointId;
    }

    public void setTodoExtendedPointId(Integer todoExtendedPointId) {
        this.todoExtendedPointId = todoExtendedPointId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
