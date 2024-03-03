package com.workflow.WorkFlowDEMO.data.dto.todo.request;

public class AddTodoExtendedPointRequestDTO {

    private String todoExtendedPointContent;

    private int todoExtededPointOrder;

    private int todoPointId;

    public AddTodoExtendedPointRequestDTO(String todoExtendedPointContent, int todoExtededPointOrder, int todoPointId) {
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
}
