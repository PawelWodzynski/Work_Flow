package com.workflow.WorkFlowDEMO.data.dto.employee.request;


public class UpdateEmployeeRequestDTO {

    private int updatedEmployeeId;
    private String firstName;
    private String lastName;
    private String role;
    private String email;

    public UpdateEmployeeRequestDTO(int updatedEmployeeId, String firstName, String lastName, String role, String email) {
        this.updatedEmployeeId = updatedEmployeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.email = email;
    }

    public int getUpdatedEmployeeId() {
        return updatedEmployeeId;
    }

    public void setUpdatedEmployeeId(int updatedEmployeeId) {
        this.updatedEmployeeId = updatedEmployeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
