package com.workflow.WorkFlowDEMO.data.dto.todo.request;


import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.ContentValidation;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.NotNullIdValidation;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.NumberValidation;

public class AddTodoPointRequestDTO {

    @ContentValidation
    private String content;
    @NumberValidation
    private Integer pointOrder;
    @NumberValidation
    private Integer fromDayNumber;
    @NumberValidation
    private Integer toDayNumber;
    @NotNullIdValidation
    private Integer todoDateId;

    public AddTodoPointRequestDTO(String content, Integer pointOrder, Integer fromDayNumber, Integer toDayNumber, Integer todoDateId) {
        this.content = content;
        this.pointOrder = pointOrder;
        this.fromDayNumber = fromDayNumber;
        this.toDayNumber = toDayNumber;
        this.todoDateId = todoDateId;
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

    public Integer getFromDayNumber() {
        return fromDayNumber;
    }

    public void setFromDayNumber(Integer fromDayNumber) {
        this.fromDayNumber = fromDayNumber;
    }

    public Integer getToDayNumber() {
        return toDayNumber;
    }

    public void setToDayNumber(Integer toDayNumber) {
        this.toDayNumber = toDayNumber;
    }

    public Integer getTodoDateId() {
        return todoDateId;
    }

    public void setTodoDateId(Integer todoDateId) {
        this.todoDateId = todoDateId;
    }
}
