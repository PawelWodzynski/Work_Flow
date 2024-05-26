package com.workflow.WorkFlowDEMO.data.dto.todo.request;

import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.ContentValidation;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.NotNullIdValidation;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.NumberValidation;

public class AddTodoExtendedPointRequestDTO {

    @ContentValidation
    private String content;
    @NumberValidation
    private Integer pointOrder;
    @NotNullIdValidation
    private Integer todoPointId;

    public AddTodoExtendedPointRequestDTO(String content, Integer pointOrder, Integer todoPointId) {
        this.content = content;
        this.pointOrder = pointOrder;
        this.todoPointId = todoPointId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPointOrder() {
        return pointOrder;
    }

    public void setPointOrder(Integer pointOrder) {
        this.pointOrder = pointOrder;
    }

    public Integer getTodoPointId() {
        return todoPointId;
    }

    public void setTodoPointId(Integer todoPointId) {
        this.todoPointId = todoPointId;
    }
}
