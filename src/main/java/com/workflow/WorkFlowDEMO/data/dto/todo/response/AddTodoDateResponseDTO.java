package com.workflow.WorkFlowDEMO.data.dto.todo.response;

public class AddTodoDateResponseDTO {
    private String successfulMessage;
    private int year;
    private int monthNumber;
    private int employeeId;
    private int todoDateId;

    public AddTodoDateResponseDTO(String successfulMessage, int year, int monthNumber, int employeeId, int todoDateId) {
        this.successfulMessage = successfulMessage;
        this.year = year;
        this.monthNumber = monthNumber;
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

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
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
