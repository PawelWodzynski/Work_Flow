package com.workflow.WorkFlowDEMO.data.dto.todo.response;

public class AddTodoExtendedPointResponseDTO {


    private String successfulMessage;
    private String todoExtendedPointContent;
    private int todoExtededPointOrder;
    private int todoPointId;
    private boolean completed;
    private int getTodoExtededPointId;


    public AddTodoExtendedPointResponseDTO(String successfulMessage, String todoExtendedPointContent, int todoExtededPointOrder, int todoPointId, boolean completed, int getTodoExtededPointId) {
        this.successfulMessage = successfulMessage;
        this.todoExtendedPointContent = todoExtendedPointContent;
        this.todoExtededPointOrder = todoExtededPointOrder;
        this.todoPointId = todoPointId;
        this.completed = completed;
        this.getTodoExtededPointId = getTodoExtededPointId;
    }

    public String getSuccessfulMessage() {
        return successfulMessage;
    }

    public void setSuccessfulMessage(String successfulMessage) {
        this.successfulMessage = successfulMessage;
    }

    public String getTodoExtendedPointContent() {
        return todoExtendedPointContent;
    }

    public void setTodoExtendedPointContent(String todoExtendedPointContent) {
        this.todoExtendedPointContent = todoExtendedPointContent;
    }

    public int getTodoExtededPointOrder() {
        return todoExtededPointOrder;
    }

    public void setTodoExtededPointOrder(int todoExtededPointOrder) {
        this.todoExtededPointOrder = todoExtededPointOrder;
    }

    public int getTodoPointId() {
        return todoPointId;
    }

    public void setTodoPointId(int todoPointId) {
        this.todoPointId = todoPointId;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getGetTodoExtededPointId() {
        return getTodoExtededPointId;
    }

    public void setGetTodoExtededPointId(int getTodoExtededPointId) {
        this.getTodoExtededPointId = getTodoExtededPointId;
    }
}