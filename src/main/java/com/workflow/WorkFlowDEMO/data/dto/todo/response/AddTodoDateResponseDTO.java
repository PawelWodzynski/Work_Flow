package com.workflow.WorkFlowDEMO.data.dto.todo.response;

public class AddTodoDateResponseDTO {
    private String successfulMessage;
    private int year;
    private int mounthNumber;
    private int employeeId;
    private int todoDateId;

    public AddTodoDateResponseDTO(String successfulMessage, int year, int mounthNumber, int employeeId, int todoDateId) {
        this.successfulMessage = successfulMessage;
        this.year = year;
        this.mounthNumber = mounthNumber;
        this.employeeId = employeeId;
        this.todoDateId = todoDateId;
    }

    public String getSuccessfulMessage() {
        return successfulMessage;
    }

    public void setSuccessfulMessage(String successfulMessage) {
        this.successfulMessage = successfulMessage;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMounthNumber() {
        return mounthNumber;
    }

    public void setMounthNumber(int mounthNumber) {
        this.mounthNumber = mounthNumber;
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
