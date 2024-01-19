package com.workflow.WorkFlowDEMO.data.service;

import com.workflow.WorkFlowDEMO.data.DAO.EmployeeRepository;
import com.workflow.WorkFlowDEMO.data.DAO.RoleRepository;
import com.workflow.WorkFlowDEMO.data.entity.Employee;
import com.workflow.WorkFlowDEMO.data.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

// Service implementation for Employee-related operations
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private RoleRepository roleRepository;

    @Autowired
    private EntityManager entityManager;

    // Constructor with EmployeeRepository injection
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository, RoleRepository theRoleRepository){
        employeeRepository = theEmployeeRepository;
        roleRepository = theRoleRepository;
    }

    // Implementation of the method to retrieve a list of all employees
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    // Implementating save method from EmployeeService
    @Override
    public Employee save(Employee theEmployee, String selectedRole) {

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
    public List<Employee> FindByUsernameContaining(String userName) {
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





}
