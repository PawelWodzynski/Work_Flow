package com.workflow.WorkFlowDEMO.data.repository.employee;

import com.workflow.WorkFlowDEMO.data.entity.employee.Employee;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

// EmployeeJPARepository interface extending JpaRepository for database operations
@Repository
@Hidden
public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {

    // Method to find all employees and order them by last name in ascending order with paging
    public List<Employee> findAllByOrderByLastNameAsc(Pageable pageable);

    // Method to find all usernames matched to username
    List<Employee> findByUserNameContaining(String userName);

    // Method for check whether record exist in DB by id
    boolean existsById(int theId);

    @Query("SELECT e.id FROM Employee e WHERE e.userName = ?1")
    Integer findIdByUserName(String username);

    Optional<Employee> findByUserName(String userName);

}
