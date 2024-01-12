package com.workflow.WorkFlowDEMO.data.service;

import com.workflow.WorkFlowDEMO.data.entity.Employee;

import java.util.List;

// Service interface for Employee-related operations
public interface EmployeeService {

    // Method to retrieve a list of all employees
    List<Employee> findAll();

    Employee save(Employee theEmployee);

}
