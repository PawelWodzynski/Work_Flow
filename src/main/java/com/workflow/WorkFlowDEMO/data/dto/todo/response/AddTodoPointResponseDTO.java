package com.workflow.WorkFlowDEMO.data.dto.todo.response;

public class AddTodoPointResponseDTO {
    private String successfulMessage;
    private String todoContent;
    private int todoPointOrder;
    private int fromDayNumber;
    private int toDayNumber;
    private boolean completed;
    private int todoDateId;
    private int todoPointId;

    public AddTodoPointResponseDTO(String successfulMessage, String todoContent, int todoPointOrder, int fromDayNumber, int toDayNumber, boolean completed, int todoDateId, int todoPointId) {
        this.successfulMessage = successfulMessage;
        this.todoContent = todoContent;
        this.todoPointOrder = todoPointOrder;
        this.fromDayNumber = fromDayNumber;
        this.toDayNumber = toDayNumber;
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
