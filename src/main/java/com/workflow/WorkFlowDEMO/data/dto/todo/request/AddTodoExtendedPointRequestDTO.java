package com.workflow.WorkFlowDEMO.data.dto.todo.request;

import com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.extendedPoint.dto.AddExtendedPointRequestDtoContentValidation;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.extendedPoint.dto.AddExtendedPointRequestDtoPointOrderValidation;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.extendedPoint.dto.AddExtendedPointRequestDtoTodoPointIdValidation;

@AddExtendedPointRequestDtoContentValidation
@AddExtendedPointRequestDtoPointOrderValidation
@AddExtendedPointRequestDtoTodoPointIdValidation
public class AddTodoExtendedPointRequestDTO {

    private String todoExtendedPointContent;

    private Integer todoExtededPointOrder;

    private Integer todoPointId;

    public AddTodoExtendedPointRequestDTO(String todoExtendedPointContent, Integer todoExtededPointOrder, Integer todoPointId) {
        this.todoExtendedPointContent = todoExtendedPointContent;
        this.todoExtededPointOrder = todoExtededPointOrder;
        this.todoPointId = todoPointId;
    }

    public String getTodoExtendedPointContent() {
        return todoExtendedPointContent;
    }

    public void setTodoExtendedPointContent(String todoExtendedPointContent) {
        this.todoExtendedPointContent = todoExtendedPointContent;
    }

    public Integer getTodoExtededPointOrder() {
        return todoExtededPointOrder;
    }

    public void setTodoExtededPointOrder(Integer todoExtededPointOrder) {
        this.todoExtededPointOrder = todoExtededPointOrder;
    }

    public Integer getTodoPointId() {
        return todoPointId;
    }

    public void setTodoPointId(Integer todoPointId) {
        this.todoPointId = todoPointId;
    }
}
