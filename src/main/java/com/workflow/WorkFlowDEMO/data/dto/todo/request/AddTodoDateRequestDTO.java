package com.workflow.WorkFlowDEMO.data.dto.todo.request;

public class AddTodoDateRequestDTO {
    private int mounthNumber;
    private int year;
    private int employeeId;

    public AddTodoDateRequestDTO(int mounthNumber, int year, int employeeId) {
        this.mounthNumber = mounthNumber;
        this.year = year;
        this.employeeId = employeeId;
    }

    public int getMounthNumber() {
        return mounthNumber;
    }

    public void setMounthNumber(int mounthNumber) {
        this.mounthNumber = mounthNumber;
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
