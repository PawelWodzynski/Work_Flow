package com.workflow.WorkFlowDEMO.data.repository.employee;

import com.workflow.WorkFlowDEMO.data.entity.employee.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleJpaRepository extends JpaRepository <Role, Long>{

    // Method to find role by role name
    Role findByName(String roleName);

    Role findById(long id);

    Role deleteById(long id);


}
