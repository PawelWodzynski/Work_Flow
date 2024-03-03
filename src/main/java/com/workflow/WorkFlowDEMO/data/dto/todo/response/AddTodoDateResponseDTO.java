package com.workflow.WorkFlowDEMO.data.dto.todo.response;

public class AddTodoDateResponseDTO {
    private String successfulMessage;
    private String todoDate;
    private int employeeId;
    private int todoDateId;


    public AddTodoDateResponseDTO(String successfulMessage, String todoDate, int employeeId, int todoDateId) {
        this.successfulMessage = successfulMessage;
        this.todoDate = todoDate;
        this.employeeId = employeeId;
        this.todoDateId = todoDateId;
    }

    public String getSuccessfulMessage() {
        return successfulMessage;
    }

    public void setSuccessfulMessage(String successfulMessage) {
        this.successfulMessage = successfulMessage;
    }

    public String getTodoDate() {
        return todoDate;
    }

    public void setTodoDate(String todoDate) {
        this.todoDate = todoDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getTodoDateId() {
        return todoDateId;
    }

    public void setTodoDateId(int todoDateId) {
        this.todoDateId = todoDateId;
    }
}
