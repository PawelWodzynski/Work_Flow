package com.workflow.WorkFlowDEMO.data.dto.todo.request;

import com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.extendedPoint.dto.AddExtendedPointRequestDtoContentValidation;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.extendedPoint.dto.AddExtendedPointRequestDtoPointOrderValidation;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.extendedPoint.dto.AddExtendedPointRequestDtoTodoPointIdValidation;

@AddExtendedPointRequestDtoContentValidation
@AddExtendedPointRequestDtoPointOrderValidation
@AddExtendedPointRequestDtoTodoPointIdValidation
public class AddTodoExtendedPointRequestDTO {

    private String content;

    private Integer pointOrder;

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
