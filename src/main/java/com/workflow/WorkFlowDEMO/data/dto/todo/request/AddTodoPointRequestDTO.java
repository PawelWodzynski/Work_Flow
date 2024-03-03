package com.workflow.WorkFlowDEMO.data.dto.todo.request;

import io.swagger.v3.oas.annotations.media.Schema;

public class AddTodoPointRequestDTO {

    private String todoContent;

    private int todoPointOrder;

    private int fromDayNumber;

    private int toDayNumber;

    private int todoDateId;

    public AddTodoPointRequestDTO(String todoContent, int todoPointOrder, int fromDayNumber, int toDayNumber, int todoDateId) {
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

    public int getTodoPointOrder() {
        return todoPointOrder;
    }

    public void setTodoPointOrder(int todoPointOrder) {
        this.todoPointOrder = todoPointOrder;
    }

    public int getFromDayNumber() {
        return fromDayNumber;
    }

    public void setFromDayNumber(int fromDayNumber) {
        this.fromDayNumber = fromDayNumber;
    }

    public int getToDayNumber() {
        return toDayNumber;
    }

    public void setToDayNumber(int toDayNumber) {
        this.toDayNumber = toDayNumber;
    }

    public int getTodoDateId() {
        return todoDateId;
    }

    public void setTodoDateId(int todoDateId) {
        this.todoDateId = todoDateId;
    }
}
