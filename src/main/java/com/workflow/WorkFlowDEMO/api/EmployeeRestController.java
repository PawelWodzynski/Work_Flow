package com.workflow.WorkFlowDEMO.api;

import com.workflow.WorkFlowDEMO.api.utils.validation.service.ValidationService;
import com.workflow.WorkFlowDEMO.api.utils.bcrypt.BcryptPasswordEncoder;
import com.workflow.WorkFlowDEMO.api.utils.email.EmailService;
import com.workflow.WorkFlowDEMO.api.utils.employee.DefiningCurrentEmployeeRole;
import com.workflow.WorkFlowDEMO.api.utils.generators.RandomPasswordGenerator;
import com.workflow.WorkFlowDEMO.api.utils.generators.UsernameGenerator;
import com.workflow.WorkFlowDEMO.data.dto.request.SaveEmpoyeeRequestDTO;
import com.workflow.WorkFlowDEMO.data.dto.request.UpdateEmployeeRequestDTO;
import com.workflow.WorkFlowDEMO.data.dto.response.SaveEmployeeResponseDTO;
import com.workflow.WorkFlowDEMO.data.dto.response.UpdateEmployeeResponseDTO;
import com.workflow.WorkFlowDEMO.data.dto.response.SimpleResponseMessageDTO;
import com.workflow.WorkFlowDEMO.data.entity.Employee;
import com.workflow.WorkFlowDEMO.data.entity.Role;
import com.workflow.WorkFlowDEMO.data.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employeeRequest")
public class EmployeeRestController {



////////////////////////////////////////////// Dependency Injections ///////////////////////////////////////////////////

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmailService emailService;

   @Autowired
   private ValidationService validationService;


//////////////////////////////////////////////////// Endpoints /////////////////////////////////////////////////////////


    // Method handling POST request at "/saveEmployee" in add-employee-form.html
    // This method has task get employee from add employee form
    // Validate and save new employee in DB
    // On the end, method has returning employee login informations for save confirm
    @PostMapping("/saveEmployee")
    public ResponseEntity<?> saveEmployee(@RequestBody SaveEmpoyeeRequestDTO updateEmployeeRequestDTO) {

        // Creating new object of Employeee  and added employee informations for validation
        Employee theEmployee = new Employee();
        theEmployee.setFirstName(updateEmployeeRequestDTO.getFirstName());
        theEmployee.setLastName(updateEmployeeRequestDTO.getLastName());
        theEmployee.setEmail(updateEmployeeRequestDTO.getEmail());
        // Creating  a new role object and add it to the employee to process of validation cunning successful
        List<Role> roleFromRequest = new ArrayList<>();
        roleFromRequest.add(new Role(updateEmployeeRequestDTO.getRole()));
        theEmployee.setRoles(roleFromRequest);

        // Getting validation errors from Entity class
        Map<String, String> fieldErrors = validationService.validateObject(theEmployee, "employee");

        // Clearing the roleFromRequest list because the saveWithRole method from EmployeeService was later used,
        // in which the newly added will be saved in the database as a new role using this method and this should be prevented in this line
        roleFromRequest.clear();

        if (!fieldErrors.isEmpty()) {
            // If validation result has errors, return a Bad Request status with error details
            System.out.println(fieldErrors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldErrors);
        } else {
            // If validation result haven't errors, go to the process of creating a new user

            // Generating username from first and last name from add-employee-form.html
            String generatedUsername = UsernameGenerator.generateUsername(updateEmployeeRequestDTO.getFirstName(), updateEmployeeRequestDTO.getLastName(), employeeService);

            // seting generated username for employee
            theEmployee.setUserName(generatedUsername);

            // generating random password for employee
            String generatedPassword = RandomPasswordGenerator.randomPassword();

            // encoding generated password
            String encodedPassword = BcryptPasswordEncoder.encodePassword(generatedPassword);

            // setting generated password to employee
            theEmployee.setPassword(encodedPassword);

            //saveWithRole the employee using the appropriate service (employeeService)
            employeeService.saveWithRole(theEmployee, updateEmployeeRequestDTO.getRole());

            // sending mail with username and password to new registred employee
            emailService.sendEmail(theEmployee.getEmail(),
                    emailService.greetingSubjectForNewUsers(),
                    "Your Username: " + generatedUsername + "\n" +
                            "Your Password: " + generatedPassword +
                            emailService.passwordBodyWarningMessage());


            return ResponseEntity.ok(new SaveEmployeeResponseDTO(generatedUsername, generatedPassword));
        }
    }


    // This method handling POST request for update employee, and has task saveWithRole/saveWithoutRole the updated employee to DB
    // optional will send mail with new username if employee first or last name has been updated
    // optional will set new role for employee
    // On the end method sends JSON response with errors or employee informations with appriopriate messages
    @PostMapping("/updateEmployee")
    public ResponseEntity<?> updateEmpleyee(@RequestBody UpdateEmployeeRequestDTO updateEmployeeRequestDTO) {

        if (employeeService.existById(updateEmployeeRequestDTO.getUpdatedEmployeeId())){
            // Getting employee by id
            Optional<Employee> existingEmployee = employeeService.findById(updateEmployeeRequestDTO.getUpdatedEmployeeId());

            // Check whether employee is exist
            if (existingEmployee.isPresent()){

                // Creating new employee which inherits current information about existing employee
                Employee employee = existingEmployee.get();

                // Getting employee first and last before entering new employee informations to Employee entity
                String firstNameBeforeEdit = employee.getFirstName();
                String lastNameBeforeEdit = employee.getLastName();

                // convert role of employee to String
                String currentEmployeeRole = employee.getRoles().toString();
                // Defining current role from DB witch has employee, by converted employee role
                String definedEmployeeRoleBeforeEdit = DefiningCurrentEmployeeRole.defineEmployeeRole(currentEmployeeRole);



                // entering new employee informations to Employee entity class before validation,
                // because validation is for Employee entity
                employee.setFirstName(updateEmployeeRequestDTO.getFirstName());
                employee.setLastName(updateEmployeeRequestDTO.getLastName());
                employee.setEmail(updateEmployeeRequestDTO.getEmail());


                boolean isRoleChanged = false;
                List<Role> roleFromRequest = new ArrayList<>();
                if (!definedEmployeeRoleBeforeEdit.contains(updateEmployeeRequestDTO.getRole())) {
                    // Checking whether role of employee has changed
                    isRoleChanged = true;

                    // Creating  a new role object and add it to the employee to process of validation cunning successful
                    roleFromRequest.add(new Role(updateEmployeeRequestDTO.getRole()));
                    employee.setRoles(roleFromRequest);
                }


                // Getting validation errors from Entity class
                Map<String, String> fieldErrors = validationService.validateObject(employee, "employee");

                // Clearing the roleFromRequest list because the saveWithRole method from EmployeeService was later used,
                // in which the newly added will be saved in the database as a new role using this method and this should be prevented in this line
                roleFromRequest.clear();


                // Check whether validation was successful
                if (!fieldErrors.isEmpty()) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldErrors);
                } else {

                    String newUsername = "";
                    String generateNewUsername = "";
                    boolean isEditedEmployee = false; // boolean for final JSON response
                    if (!updateEmployeeRequestDTO.getFirstName().equals(firstNameBeforeEdit) || !updateEmployeeRequestDTO.getLastName().equals(lastNameBeforeEdit)) {
                        // if employee updated first name not equals to current first name in DB or if employee last name not equals to last name in DB,
                        // set new first and last name for updating employee and
                        // generate and set new username for employee
                        generateNewUsername = UsernameGenerator.generateUsername(updateEmployeeRequestDTO.getFirstName(), updateEmployeeRequestDTO.getLastName(), employeeService);
                        employee.setUserName(generateNewUsername);
                        newUsername = generateNewUsername;
                        isEditedEmployee = true;
                    }

                    if (isRoleChanged == true){
                        // if current employee role it's differs from role from employee update request, set up new employee role and use saveWithRole method for save with new role
                        employee.setRoles(null);
                        employeeService.saveWithRole(employee, updateEmployeeRequestDTO.getRole());
                    }else if (isRoleChanged == false) {
                        // if current employee role it's not differs from role from employee update request, use saveWithoutRole method for keep current role
                        employeeService.saveWithoutRole(employee);
                    }
                    if (isEditedEmployee){
                        // if employee has edited first or last name send mail with new username to employee current email
                        emailService.sendEmail(employee.getEmail(), emailService.newUsernameSubject(), "Username: " + generateNewUsername);
                    }
                    return ResponseEntity.ok(new UpdateEmployeeResponseDTO(
                            isEditedEmployee,
                            "New generated username is sended to employee email",
                            "Employee updated successfully",
                            updateEmployeeRequestDTO.getFirstName(), updateEmployeeRequestDTO.getLastName(), newUsername, updateEmployeeRequestDTO.getEmail(), updateEmployeeRequestDTO.getRole())
                    );
                }

            }else {
                return ResponseEntity.badRequest().body(new SimpleResponseMessageDTO(
                        "Object of employee is null ID: " + updateEmployeeRequestDTO.getUpdatedEmployeeId()
                ));
            }

        }else {
            return ResponseEntity.badRequest().body(new SimpleResponseMessageDTO(
               "Employee not found ID: " + updateEmployeeRequestDTO.getUpdatedEmployeeId()
            ));
        }
}





    // this method handilng POST request for reset employee password, and has task generate new password,
    // this method using saveWithoutRole method from EmployeeService
    // in order to overwrite only the employee's data with new password to DB
    // and send mail with current psasword for employee email
    @PostMapping("/resetPassword")
    public ResponseEntity<?> resetEmployeePassword(@RequestParam("employeeId") int employeeId ){



        if (employeeService.existById(employeeId)){
            // Find employee object in the database by employee id
            Optional<Employee> optionalEmployee = employeeService.findById(employeeId);

            // Check if the optional object contains a value
            if (optionalEmployee.isPresent()) {
                // Get the Employee object from the optional object
                Employee theEmployee = optionalEmployee.get();
                // Generate a random password for the employee
                String generatedPassword = RandomPasswordGenerator.randomPassword();
                // Encode the generated password
                String encodedPassword = BcryptPasswordEncoder.encodePassword(generatedPassword);
                // Set the generated password for the employee
                theEmployee.setPassword(encodedPassword);
                // Save the employee using the appropriate service (employeeService)
                employeeService.saveWithoutRole(theEmployee);
                // Send an email with the new password to the employee
                emailService.sendEmail(theEmployee.getEmail(), emailService.resetPasswordRequestSubject(),
                        "Your Username: " + theEmployee.getUserName() + "\n" +
                                "Your Password: " + generatedPassword +
                                emailService.passwordBodyWarningMessage());

                SimpleResponseMessageDTO simpleMessageDTO = new SimpleResponseMessageDTO("New password has been sent to the employee's email");
                return ResponseEntity.ok(simpleMessageDTO);
            } else {

                // Handling the case when the employee is not found
                return ResponseEntity.badRequest().body(new SimpleResponseMessageDTO(
                        "Object of employee is null ID: " + employeeId)
                );
            }

        }else{
            return ResponseEntity.badRequest().body(new SimpleResponseMessageDTO(
                    "Employee not found ID " + employeeId)
            );
        }
    }


    // Method handling GET request for delete employee
    // This method has task deleted appropriate employee
    @PostMapping("/deleteEmployee")
    public ResponseEntity<?> deleteEmployeeById(@RequestParam("employeeId") int employeeId){
        if (employeeService.existById(employeeId)){
            // Delete the employee
            employeeService.deleteById(employeeId);
            // refresh admin panel page for visual update employees list
            return ResponseEntity.ok(new SimpleResponseMessageDTO("Employee has been deleted ID: " + employeeId));
        }else {
            return  ResponseEntity.badRequest().body(new SimpleResponseMessageDTO("Employee not found ID: " + employeeId));
        }
    }



}
