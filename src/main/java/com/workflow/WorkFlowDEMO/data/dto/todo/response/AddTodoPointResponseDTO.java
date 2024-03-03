package com.workflow.WorkFlowDEMO.data.dto.todo.response;

public class AddTodoPointResponseDTO {
    private String successfulMessage;
    private String todoContent;
    private int todoPointOrder;
    private String fromDate;
    private String toDate;
    private boolean completed;
    private int todoDateId;
    private int todoPointId;

    public AddTodoPointResponseDTO(String successfulMessage, String todoContent, int todoPointOrder, String fromDate, String toDate, boolean completed, int todoDateId, int todoPointId) {
        this.successfulMessage = successfulMessage;
        this.todoContent = todoContent;
        this.todoPointOrder = todoPointOrder;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.completed = completed;
        this.todoDateId = todoDateId;
        this.todoPointId = todoPointId;
    }

    public String getSuccessfulMessage() {
        return successfulMessage;
    }

    public void setSuccessfulMessage(String successfulMessage) {
        this.successfulMessage = successfulMessage;
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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getTodoDateId() {
        return todoDateId;
    }

    public void setTodoDateId(int todoDateId) {
        this.todoDateId = todoDateId;
    }

    public int getTodoPointId() {
        return todoPointId;
    }

    public void setTodoPointId(int todoPointId) {
        this.todoPointId = todoPointId;
    }
}
