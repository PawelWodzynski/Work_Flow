package com.workflow.WorkFlowDEMO.api.utils.validation.employee.messages;

// Data Transfer Object for OK response for EmployeeRestController
// Contains message for no edited first or last name employee or for employee with edited first and last name employee
// and employee first and last name, username and email, role
public class EditEmployeeDTO {

    private boolean employeeEdited;

    private String messageEditedEmployee;

    private String messageNoEditedEmployee;

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String role;


    public EditEmployeeDTO(boolean employeeEdited, String messageEditedEmployee, String messageNoEditedEmployee, String firstName, String lastName, String username, String email, String role) {
        this.employeeEdited = employeeEdited;
        this.messageEditedEmployee = messageEditedEmployee;
        this.messageNoEditedEmployee = messageNoEditedEmployee;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.role = role;
    }

    public boolean isEmployeeEdited() {
        return employeeEdited;
    }

    public void setEmployeeEdited(boolean employeeEdited) {
        this.employeeEdited = employeeEdited;
    }

    public String getMessageEditedEmployee() {
        return messageEditedEmployee;
    }

    public void setMessageEditedEmployee(String messageEditedEmployee) {
        this.messageEditedEmployee = messageEditedEmployee;
    }

    public String getMessageNoEditedEmployee() {
        return messageNoEditedEmployee;
    }

    public void setMessageNoEditedEmployee(String messageNoEditedEmployee) {
        this.messageNoEditedEmployee = messageNoEditedEmployee;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "EditEmployeeDTO{" +
                "employeeEdited=" + employeeEdited +
                ", messageEditedEmployee='" + messageEditedEmployee + '\'' +
                ", messageNoEditedEmployee='" + messageNoEditedEmployee + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
