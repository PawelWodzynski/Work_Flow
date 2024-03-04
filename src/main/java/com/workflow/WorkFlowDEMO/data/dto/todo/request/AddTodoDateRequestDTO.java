package com.workflow.WorkFlowDEMO.data.dto.todo.request;

public class AddTodoDateRequestDTO {
    private int monthNumber;
    private int year;
    private int employeeId;

    public AddTodoDateRequestDTO(int monthNumber, int year, int employeeId) {
        this.monthNumber = monthNumber;
        this.year = year;
        this.employeeId = employeeId;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
