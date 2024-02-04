package com.workflow.WorkFlowDEMO.api;

import com.workflow.WorkFlowDEMO.api.utils.bcrypt.BcryptPasswordEncoder;
import com.workflow.WorkFlowDEMO.api.utils.email.EmailService;
import com.workflow.WorkFlowDEMO.api.utils.generators.RandomPasswordGenerator;
import com.workflow.WorkFlowDEMO.api.utils.generators.UsernameGenerator;
import com.workflow.WorkFlowDEMO.api.utils.validation.employee.messages.CreateEmployeeDTO;
import com.workflow.WorkFlowDEMO.api.utils.validation.employee.messages.ValidationError;
import com.workflow.WorkFlowDEMO.data.entity.Employee;
import com.workflow.WorkFlowDEMO.data.repository.PageEmployeeRepository;
import com.workflow.WorkFlowDEMO.data.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/employeeRequest")
public class EmployeeRestController {
////////////////////////////////////////////// Dependency Injections ///////////////////////////////////////////////////

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PageEmployeeRepository pageEmployeeRepository;

//////////////////////////////////////////////////// Endpoints /////////////////////////////////////////////////////////

    // Method handling POST request at "/saveEmployee" in add-employee-form.html
    // This method has task get employee from add employee form
    // Validate and save new employee in DB
    // On the end, method has returning employee login informations for save confirm
    @PostMapping("/saveEmployee")
    public ResponseEntity<?> saveEmployee (@Valid @ModelAttribute("employee") Employee theEmployee, BindingResult theBindingResult, @RequestParam("selectedRole") String theRole) {

        if (theBindingResult.hasErrors()) {
            // If validation result has errors, return a Bad Request status with error details
            Map<String, String> fieldErrors = ValidationError.getErrors(theBindingResult);
            System.out.println(fieldErrors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldErrors);
        } else {


            // Generating username from first and last name from add-employee-form.html
            String generatedUsername = UsernameGenerator.generateUsername(theEmployee.getFirstName(),theEmployee.getLastName(),employeeService);

            // seting generated username for employee
            theEmployee.setUserName(generatedUsername);

            // generating random password for employee
            String generatedPassword = RandomPasswordGenerator.randomPassword();

            // encoding generated password
            String encodedPassword = BcryptPasswordEncoder.encodePassword(generatedPassword);

            // setting generated password to employee
            theEmployee.setPassword(encodedPassword);

            //saveWithRole the employee using the appropriate service (employeeService)
            employeeService.saveWithRole(theEmployee, theRole);

            // sending mail with username and password to new registred employee
            emailService.sendEmail(theEmployee.getEmail(),
                    emailService.greetingSubjectForNewUsers(),
                    "Your Username: " + generatedUsername +"\n" +
                            "Your Password: " + generatedPassword +
                            emailService.passwordBodyWarningMessage());


            CreateEmployeeDTO createEmployeeDTO = new CreateEmployeeDTO(generatedUsername,generatedPassword);
            return ResponseEntity.ok(createEmployeeDTO);
        }


    }


}
