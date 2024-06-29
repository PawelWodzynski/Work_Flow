package com.workflow.WorkFlowDEMO.data.dto.employee;

import com.workflow.WorkFlowDEMO.data.entity.employee.Role;

import java.util.Collection;
import java.util.List;

public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String token;
    private List<Role> roles;

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, String firstName, String lastName, String userName, String email, String token, List<Role> roles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.token = token;
        this.roles = roles;
    }

    // Gettery i Settery
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", token='" + token + '\'' +
                ", roles=" + roles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeDto employeeDto = (EmployeeDto) o;

        if (id != null ? !id.equals(employeeDto.id) : employeeDto.id != null) return false;
        if (firstName != null ? !firstName.equals(employeeDto.firstName) : employeeDto.firstName != null) return false;
        if (lastName != null ? !lastName.equals(employeeDto.lastName) : employeeDto.lastName != null) return false;
        if (userName != null ? !userName.equals(employeeDto.userName) : employeeDto.userName != null) return false;
        if (email != null ? !email.equals(employeeDto.email) : employeeDto.email != null) return false;
        if (token != null ? !token.equals(employeeDto.token) : employeeDto.token != null) return false;
        return roles != null ? roles.equals(employeeDto.roles) : employeeDto.roles == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        return result;
    }
}
