package com.workflow.WorkFlowDEMO.data.dto.employee.role;

import java.util.List;

public class FindRoleResponseDTO {
   private  String roleName;

   private  long roleId;

    public FindRoleResponseDTO(String roleName, long roleId) {
        this.roleName = roleName;
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
}
