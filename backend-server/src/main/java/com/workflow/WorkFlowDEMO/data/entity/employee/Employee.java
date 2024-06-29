package com.workflow.WorkFlowDEMO.data.entity.employee;

import com.workflow.WorkFlowDEMO.api.utils.validation.validators.employee.*;
import com.workflow.WorkFlowDEMO.data.entity.todo.TodoDate;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "employee")
@EmployeeIdValidation
@EmployeeFirstNameValidation
@EmployeeLastNameValidation
@EmployeeEmailValidation
@EmployeeRoleValidation
public class Employee {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment strategy
    @Column(name = "id") // Database column mapping
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "employee_roles", // Table for mapping roles
            joinColumns = @JoinColumn(name = "user_id"), // Owning side of the relationship
            inverseJoinColumns = @JoinColumn(name = "role_id")) // Inverse side of the relationship
    private List<Role> roles; // Collection to store roles (typically ArrayList or LinkedHashMap)


    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TodoDate> todoDates;


    // Default constructor
    public Employee() {
    }

    // Constructor with all fields
    public Employee(String userName, String password, String firstName, String lastName, String email) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Constructor with all fields and an additional field for roles
    public Employee(String userName, String password, String firstName, String lastName, String email,
                    List<Role> roles) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles = roles;
    }

    // Getter and setter methods for all fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    public void addTodoDate(TodoDate todoDate){
        if (todoDates == null){
            todoDates = new ArrayList<>();
        }

        todoDates.add(todoDate);
    }


    // Adding toString method for debugging
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + "*********" + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}
