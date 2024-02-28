package com.workflow.WorkFlowDEMO.api.controllers.employee.role;

import com.workflow.WorkFlowDEMO.api.documentation.employee.role.RoleRestControllerDocumentation;
import com.workflow.WorkFlowDEMO.data.dto.employee.response.SimpleResponseMessageDTO;
import com.workflow.WorkFlowDEMO.data.dto.employee.role.FindRoleResponseDTO;
import com.workflow.WorkFlowDEMO.data.entity.employee.Role;
import com.workflow.WorkFlowDEMO.data.repository.employee.RoleJpaRepository;
import com.workflow.WorkFlowDEMO.data.service.employee.role.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/roleRequest")
public class RoleRestController {

    @Autowired
    RoleService roleService;

    @Operation(summary ="Find role by role ID from DB.",
            description = RoleRestControllerDocumentation.findRoleByIdDsc)
    @GetMapping("/findById")
    ResponseEntity<?> findRoleById(@RequestParam long id){
        if (roleService.existById(id)){
            Role role = roleService.findById(id);
            return ResponseEntity.ok(new FindRoleResponseDTO(role.getName(),role.getId()));
        }else {
            return ResponseEntity.badRequest().body(new SimpleResponseMessageDTO("Role not found ID: " + id));
        }
    }


    @Operation(summary ="Find role by role name.", description = RoleRestControllerDocumentation.findRoleByNameDsc)
    @GetMapping("/findByName")
    ResponseEntity<?> findRoleByName(@RequestParam String roleName){
        Role role = roleService.findByName(roleName);
        if (role==null){
            return ResponseEntity.badRequest().body(new SimpleResponseMessageDTO("Role not found Name: " + roleName));
        }else {
            String roleNameToString = role.getName();
            return ResponseEntity.ok(new FindRoleResponseDTO(roleNameToString, role.getId()));
        }
    }


    @Operation(summary = "Create new authorization role for employees.", description = RoleRestControllerDocumentation.saveNewRoleDsc)
    @PostMapping ("/saveRole")
    ResponseEntity<?> saveNewRole(@RequestParam String newRoleName){
        roleService.saveNewRole(newRoleName);
        return ResponseEntity.ok(new SimpleResponseMessageDTO("Successful role saved with Name: " + newRoleName));
    }

    @Operation(summary = "Delete Role of Employee By ID from DB .", description = RoleRestControllerDocumentation.deleteRoleByIdDsc)
    @DeleteMapping("/deleteRoleById")
    ResponseEntity <?> deleteRoleById(@RequestParam long roleId){

        if (roleService.existById(roleId)){
            roleService.deleteById(roleId);
            return ResponseEntity.ok(new SimpleResponseMessageDTO("Role successful deleted ID: " + roleId));
        }else{
            return ResponseEntity.badRequest().body(new SimpleResponseMessageDTO("Role with not found ID: " + roleId));
        }
    }

}
