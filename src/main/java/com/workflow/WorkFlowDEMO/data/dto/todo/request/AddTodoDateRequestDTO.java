package com.workflow.WorkFlowDEMO.data.dto.todo.request;

public class AddTodoDateRequestDTO {

    private String todoDate;

    private int employeeId;

    public AddTodoDateRequestDTO(String todoDate, int employeeId) {
        this.todoDate = todoDate;
        this.employeeId = employeeId;
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
}
