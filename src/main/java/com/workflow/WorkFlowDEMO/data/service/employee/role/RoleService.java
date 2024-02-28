package com.workflow.WorkFlowDEMO.data.service.employee.role;

import com.workflow.WorkFlowDEMO.data.entity.employee.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {

    Role findByName(String roleName);

    Role findById(long id);

    Role saveNewRole(String roleName);

    Role deleteById(long id);


    boolean existById(long id);

}
