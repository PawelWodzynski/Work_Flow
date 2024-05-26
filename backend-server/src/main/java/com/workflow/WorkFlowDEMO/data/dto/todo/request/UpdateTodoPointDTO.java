package com.workflow.WorkFlowDEMO.data.dto.todo.request;

import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.ContentValidation;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.NotNullIdValidation;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.NumberValidation;

public class UpdateTodoPointDTO {

    @NotNullIdValidation
    private Integer todoPointId;
    @ContentValidation
    private String content;
    @NumberValidation
    private Integer toDayNumber;

    public UpdateTodoPointDTO(Integer todoPointId, String content, Integer toDayNumber) {
        this.todoPointId = todoPointId;
        this.content = content;
        this.toDayNumber = toDayNumber;
    }

    public Integer getTodoPointId() {
        return todoPointId;
    }

    public void setTodoPointId(Integer todoPointId) {
        this.todoPointId = todoPointId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getToDayNumber() {
        return toDayNumber;
    }

    public void setToDayNumber(Integer toDayNumber) {
        this.toDayNumber = toDayNumber;
    }
}
