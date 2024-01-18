package com.workflow.WorkFlowDEMO.data.service;

import com.workflow.WorkFlowDEMO.data.entity.Employee;

import java.util.List;

// Service interface for Employee-related operations
public interface EmployeeService {

    // Method to retrieve a list of all employees
    List<Employee> findAll();

    // Method to save employee with selected role from add-employee-form.html
    Employee save(Employee theEmployee, String selectedRole);

    // Method to find all usernames matched to username
    List<Employee> FindByUsernameContaining(String userName);




}
