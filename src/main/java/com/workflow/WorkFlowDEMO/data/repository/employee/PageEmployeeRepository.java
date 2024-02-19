package com.workflow.WorkFlowDEMO.data.repository.employee;

import com.workflow.WorkFlowDEMO.data.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PageEmployeeRepository extends JpaRepository<Employee,Integer> {


    Page<Employee>findByUserNameContaining(String userName, Pageable pageable);



}
