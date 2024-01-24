package com.workflow.WorkFlowDEMO.data.service;

import com.workflow.WorkFlowDEMO.data.entity.Employee;

import java.util.List;
import java.util.Optional;

// Service interface for Employee-related operations
public interface EmployeeService {

    // Method to retrieve a list of all employees
    List<Employee> findAll();

    // Method to save employee with role witch selected role from add-employee-form.html
    Employee saveWithRole(Employee theEmployee, String selectedRole);

    // Method to find all usernames matched to username
    List<Employee> FindByUsernameContaining(String userName);

    // Method to delete employee by id
    void deleteById(int theId);

    // Method to find employee by id
    Optional<Employee> findById(int theId);

    // Method to save employee without role if role is not required to no problem working application
    Employee saveWithoutRole(Employee theEmployee);





}
