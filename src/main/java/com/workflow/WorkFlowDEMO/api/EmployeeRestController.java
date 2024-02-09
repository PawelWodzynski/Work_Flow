package com.workflow.WorkFlowDEMO.api;

import com.workflow.WorkFlowDEMO.api.utils.bcrypt.BcryptPasswordEncoder;
import com.workflow.WorkFlowDEMO.api.utils.email.EmailService;
import com.workflow.WorkFlowDEMO.api.utils.employee.DefiningCurrentEmployeeRole;
import com.workflow.WorkFlowDEMO.api.utils.generators.RandomPasswordGenerator;
import com.workflow.WorkFlowDEMO.api.utils.generators.UsernameGenerator;
import com.workflow.WorkFlowDEMO.data.dto.CreateEmployeeDTO;
import com.workflow.WorkFlowDEMO.data.dto.EditEmployeeDTO;
import com.workflow.WorkFlowDEMO.api.utils.validation.employee.messages.ValidationError;
import com.workflow.WorkFlowDEMO.data.dto.SimpleMessageDTO;
import com.workflow.WorkFlowDEMO.data.entity.Employee;
import com.workflow.WorkFlowDEMO.data.repository.PageEmployeeRepository;
import com.workflow.WorkFlowDEMO.data.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.FieldError;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employeeRequest")
public class EmployeeRestController {


    @Autowired
    private Validator validator; // Dodaj walidator

    // Metoda do obsługi walidacji pracownika
    private Map<String, String> validateEmployee(Employee employee) {
        // Tworzy obiekt BindingResult do zbierania wyników walidacji
        BeanPropertyBindingResult result = new BeanPropertyBindingResult(employee, "employee");

        // Wywołuje walidację pracownika
        validator.validate(employee, result);

        // Zbiera błędy walidacji i zwraca jako mapę
        return result.getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
    }



////////////////////////////////////////////// Dependency Injections ///////////////////////////////////////////////////

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PageEmployeeRepository pageEmployeeRepository;

//////////////////////////////////////////////////// Endpoints /////////////////////////////////////////////////////////



    // Method handling GET request for delete employee
    // This method has task deleted appropriate employee
    @PostMapping("/deleteEmployee")
    public ResponseEntity<?> deleteEmployeeById(@RequestParam("employeeId") int theId){

        // Delete the employee
        employeeService.deleteById(theId);

        // refresh admin panel page for visual update employees list
        SimpleMessageDTO simpleMessageDTO = new SimpleMessageDTO("employee has been deleted id:" + theId);
        return ResponseEntity.ok(simpleMessageDTO);
    }


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


    // This method handling POST request for update employee, and has task saveWithRole/saveWithoutRole the updated employee to DB
    // optional will send mail with new username if employee first or last name has been updated
    // optional will set new role for employee
    // On the end method sends JSON response with errors or employee informations with appriopriate messages
    @PostMapping("/updateEmployee")
    public ResponseEntity<?> updateEmpleyee(@RequestParam("updatedEmployeeId") int theId, @RequestParam("updatedEmployeeFirstName") String theFirstName,
                                                              @RequestParam("updatedEmployeeLastName") String theLastName, @RequestParam("updatedEmployeeRole") String theRole,
                                                              @RequestParam("updatedEmployeeEmail") String theEmail){

        // marking appropriate variables for further activities
        String generatedUsername = "";
        String editedEmployeeMessage = "New generated username is sended to employee email";
        boolean editedEmployee = false;

        // Getting employee by id
        Optional<Employee> existingEmployee = employeeService.findById(theId);

        // Creating new employee which inherits current information about existing employee
        Employee updatedEmployee = existingEmployee.get();

        // Setting employee email before optional sending mail with new username
        updatedEmployee.setEmail(theEmail);

        // if employee updated first name not equals to current first name in DB or if employee last name not equals to last name in DB,
        // set new first and last name for updating employee and
        // generate new username for employee, and send mail with new username to employee current email
        if (!theFirstName.equals(updatedEmployee.getFirstName()) || !theLastName.equals(updatedEmployee.getLastName())){
            updatedEmployee.setFirstName(theFirstName);
            updatedEmployee.setLastName(theLastName);
            String generateNewUsername = UsernameGenerator.generateUsername(theFirstName,theLastName,employeeService);
            updatedEmployee.setUserName(generateNewUsername);
            generatedUsername = generateNewUsername;
            emailService.sendEmail(updatedEmployee.getEmail(),emailService.newUsernameSubject(),"Username: " + generateNewUsername);
            editedEmployee = true;
        }


        // convert role of employee to String
        String currentEmployeeRole = updatedEmployee.getRoles().toString();
        // Defining current role witch has employee by converted employee role
        String definedEmployeeRole = DefiningCurrentEmployeeRole.defineEmployeeRole(currentEmployeeRole);



        Map<String, String> fieldErrors = validateEmployee(updatedEmployee);

        // Check whether validation was successful
        if (!fieldErrors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldErrors);
        }else {
            // if current employee role it's differs from role from employee update form, set up new employee role and use saveWithRole method for save with new role
            // if current employee role it's not differs from role from employee update form, use saveWithoutRole method for keep current role
            if (!definedEmployeeRole.equals(theRole)){
                updatedEmployee.setRoles(null);
                employeeService.saveWithRole(updatedEmployee,theRole);
            }else{
                employeeService.saveWithoutRole(updatedEmployee);
            }

            EditEmployeeDTO editEmployeeDTO = new EditEmployeeDTO(editedEmployee,editedEmployeeMessage,"Employee updated successfully",theFirstName,theLastName,generatedUsername,theEmail,theRole);
            return ResponseEntity.ok(editEmployeeDTO);
        }
    }





    // this method handilng POST request for reset employee password, and has task generate new password,
    // this method using saveWithoutRole method from EmployeeService
    // in order to overwrite only the employee's data with new password to DB
    // and send mail with current psasword for employee email
    @PostMapping ("/resetPassword")
    public ResponseEntity<?> resetEmployeePassword(@RequestParam("employeeId") int theId){

        // find employee object in DB by employee id
        Optional<Employee> optionalEmployee = employeeService.findById(theId);

        // Creating new employee which inherits current information about existing employee
        Employee theEmployee = optionalEmployee.get();

        // generating random password for employee
        String generatedPassword = RandomPasswordGenerator.randomPassword();

        // encoding generated password
        String encodedPassword = BcryptPasswordEncoder.encodePassword(generatedPassword);

        // setting generated password to employee
        theEmployee.setPassword(encodedPassword);

        //saving the employee using the appropriate service (employeeService)
        employeeService.saveWithoutRole(theEmployee);

        // sending mail with new password for employee
        emailService.sendEmail(theEmployee.getEmail(),emailService.resetPasswordRequestSubject(),
                "Your Username: " + theEmployee.getUserName() +"\n" +
                        "Your Password: " + generatedPassword +
                        emailService.passwordBodyWarningMessage());


        SimpleMessageDTO simpleMessageDTO = new SimpleMessageDTO("New password has been sended to employee email");
        return ResponseEntity.ok(simpleMessageDTO);

    }



}
