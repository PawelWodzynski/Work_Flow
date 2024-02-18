package com.workflow.WorkFlowDEMO.data.repository;

import com.workflow.WorkFlowDEMO.data.entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

// EmployeeJPARepository interface extending JpaRepository for database operations
public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {

    // Method to find all employees and order them by last name in ascending order with paging
    public List<Employee> findAllByOrderByLastNameAsc(Pageable pageable);

    // Method to find all usernames matched to username
    List<Employee> findByUserNameContaining(String userName);

    // Method for check whether record exist in DB by id
    boolean existsById(int theId);
}
