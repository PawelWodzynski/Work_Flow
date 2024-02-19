package com.workflow.WorkFlowDEMO.data.repository.employee;

import com.workflow.WorkFlowDEMO.data.entity.employee.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleJpaRepository extends JpaRepository <Role, Long>{

    // Method to find role by role name
    Role findByName(String roleName);

}
