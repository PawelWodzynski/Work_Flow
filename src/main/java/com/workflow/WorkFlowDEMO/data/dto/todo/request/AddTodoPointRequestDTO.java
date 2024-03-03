package com.workflow.WorkFlowDEMO.data.dto.todo.request;

import io.swagger.v3.oas.annotations.media.Schema;

public class AddTodoPointRequestDTO {

    private String todoContent;

    private int todoPointOrder;

    private String fromDate;

    private String toDate;

    private int todoDateId;

    public AddTodoPointRequestDTO(String fromDate, String toDate, int todoDateId) {
        this.fromDate = fromDate;
        this.toDate = toDate;
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

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public int getTodoDateId() {
        return todoDateId;
    }

    public void setTodoDateId(int todoDateId) {
        this.todoDateId = todoDateId;
    }
}
