package com.workflow.WorkFlowDEMO.data.service;

import com.workflow.WorkFlowDEMO.data.DAO.EmployeeRepository;
import com.workflow.WorkFlowDEMO.data.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

// Service implementation for Employee-related operations
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    // Constructor with EmployeeRepository injection
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }

    // Implementation of the method to retrieve a list of all employees
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }
}
