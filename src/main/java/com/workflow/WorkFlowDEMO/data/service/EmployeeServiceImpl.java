package com.workflow.WorkFlowDEMO.data.service;

import com.workflow.WorkFlowDEMO.data.repository.EmployeeRepository;
import com.workflow.WorkFlowDEMO.data.repository.PageEmployeeRepository;
import com.workflow.WorkFlowDEMO.data.repository.RoleRepository;
import com.workflow.WorkFlowDEMO.data.entity.Employee;
import com.workflow.WorkFlowDEMO.data.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

// Service implementation for Employee-related operations
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private PageEmployeeRepository pageEmployeeRepository;

    // Implementation of the method to retrieve a list of all employees sorted by last name asc and role hierarchy
    @Override
    public List<Employee> findAll(Pageable pageable) {
        List<Employee> employees = employeeRepository.findAllByOrderByLastNameAsc(pageable);

        // Sort employees by role hierarchy : ROLE_ADMIN > ROLE_MANAGER > ROLE_EMPLOYEE
        employees.sort(Comparator.comparing(employee -> {
            if (employee.getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_ADMIN"))) {
                return 1;
            } else if (employee.getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_MANAGER"))) {
                return 2;
            } else {
                return 3;
            }
        }));

        return employees;
    }


    // Implementating saveWithRole method from EmployeeService
    @Override
    public Employee saveWithRole(Employee theEmployee, String selectedRole) {

        // if role collection does't exist, create new ArrayList for collecting roles
        if (theEmployee.getRoles() == null) {
            theEmployee.setRoles(new ArrayList<>());
        }

        // find appriopriate roles in DB
        Role role_admin = roleRepository.findByName("ROLE_ADMIN");
        Role role_manager= roleRepository.findByName("ROLE_MANAGER");
        Role role_employee = roleRepository.findByName("ROLE_EMPLOYEE");

        // Add role/roles for employee according to choice in add-employee-form.html
        // When empleyee will have highter rank role from lower rank role, must to have all lower rank roles
        if (selectedRole.contains("ADMIN")){
            theEmployee.getRoles().addAll(List.of(role_admin,role_manager,role_employee)); // Adding roles for existed role collection
        } else if(selectedRole.contains("MANAGER")){
            theEmployee.getRoles().addAll(List.of(role_manager, role_employee));
        } else if (selectedRole.contains("EMPLOYEE")) {
            theEmployee.getRoles().add(role_employee);
        }

        // Save employee in DB
        return employeeRepository.save(theEmployee);
    }


    // Implementating find all users mached by username method from EmployeeService
    @Override
    public List<Employee> findByUsernameContaining(String userName) {
        // find appriocrate usernames
        return employeeRepository.findByUserNameContaining(userName);
    }


    // Implementating delete employee by id method from EmployeeService using EmployeeRepository
    @Override
    @Transactional
    public void deleteById(int theId) {

        // finding the employee by id
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // before deleting an employee, remove the role that the employee has
        if(theEmployee != null){
           // deleting roles that the employee has
            theEmployee.setRoles(null);

            // deleting employee
            entityManager.remove(theEmployee);
        }

    }

    // implementation method to find employee by id using employee repository (JpaRepository)
    @Override
    public Optional<Employee> findById(int theId) {
        return employeeRepository.findById(theId);
    }

    // implementation method to save employee without role using employee repository (JpaRepository)
    @Override
    public Employee saveWithoutRole(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    // implementation method to define count of employees in DB
    @Override
    public long employeesCountInDB() {
        return employeeRepository.count();
    }

}
