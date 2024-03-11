package com.workflow.WorkFlowDEMO.data.dto.todo.request;

import com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.point.dto.*;

@PointRequestDtoTodoContentValidation
@PointRequestDtoPointOrderValidation
@PointRequestDtoFromDayNumberValidation
@PointRequestDtoToDayNumberValidation
@PointRequestDtoTodoDateIdValidation
public class AddTodoPointRequestDTO {

    private String todoContent;

    private Integer todoPointOrder;

    private Integer fromDayNumber;

    private Integer toDayNumber;

    private Integer todoDateId;

    public AddTodoPointRequestDTO(String todoContent, Integer todoPointOrder, Integer fromDayNumber, Integer toDayNumber, Integer todoDateId) {
        this.todoContent = todoContent;
        this.todoPointOrder = todoPointOrder;
        this.fromDayNumber = fromDayNumber;
        this.toDayNumber = toDayNumber;
        this.todoDateId = todoDateId;
    }

    public String getTodoContent() {
        return todoContent;
    }

    public void setTodoContent(String todoContent) {
        this.todoContent = todoContent;
    }

    public Integer getTodoPointOrder() {
        return todoPointOrder;
    }

    public void setTodoPointOrder(Integer todoPointOrder) {
        this.todoPointOrder = todoPointOrder;
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
