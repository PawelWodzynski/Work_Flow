package com.workflow.WorkFlowDEMO.api.controllers.security;

import com.workflow.WorkFlowDEMO.data.dto.authorization.CredentialsDto;
import com.workflow.WorkFlowDEMO.data.dto.employee.EmployeeDto;
import com.workflow.WorkFlowDEMO.data.service.employee.EmployeeServiceImpl;
import com.workflow.WorkFlowDEMO.security.UserAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthRestController {

    private EmployeeServiceImpl employeeService;
    private UserAuthProvider userAuthProvider;

    @Autowired
    public AuthRestController(EmployeeServiceImpl employeeService, UserAuthProvider userAuthProvider) {
        this.employeeService = employeeService;
        this.userAuthProvider = userAuthProvider;
    }


    @PostMapping("/login")
    public ResponseEntity<EmployeeDto> login(@RequestBody CredentialsDto credentialsDto){
        EmployeeDto user = employeeService.login(credentialsDto);

        user.setToken(userAuthProvider.createToken(user.getUserName()));

        return ResponseEntity.ok(user);
    }
}
