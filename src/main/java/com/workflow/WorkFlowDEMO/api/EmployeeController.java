package com.workflow.WorkFlowDEMO.api;

import com.workflow.WorkFlowDEMO.api.utils.*;
import com.workflow.WorkFlowDEMO.data.entity.Employee;
import com.workflow.WorkFlowDEMO.data.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    // Dependency Injection: EmployeeService
    private EmployeeService employeeService;

    private EmailService emailService;

    // Controller constructor dependent on EmployeeService
    public EmployeeController(EmployeeService theEmployeeService, EmailService theEmailService){
        employeeService = theEmployeeService;
        emailService = theEmailService;
    }

    // Handling GET request at "/employee/adminPanel" for admin-panel.html
    @GetMapping("/adminPanel")
    public  String listAndAddEmployees(Model theModel){
//  List of EMPLOYEES
        // Retrieve the list of employees from the service
        List<Employee> theEmployees = employeeService.findAll();

        // Add the list of employees to the model to make it available in the view
        theModel.addAttribute("employees", theEmployees);


//  Add Employee
        // Creating new employee object for add employee function in Add Employee button
        Employee theEmployee = new Employee();

        // creating model attribute to bind form data
        // Adding the Employee object to the model
        theModel.addAttribute("employee", theEmployee);

        // Return the view name to be rendered
        return "employees/admin-panel";
    }


    //Method handling POST request at "/saveEmployee" in add-employee-form.html
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee, @RequestParam("selectedRole") String theRole, Model theModel){

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

        // creating model attribute to bind data
        // adding generated username to the model
        theModel.addAttribute("generated_username",generatedUsername);

        // creating model attribute to bind data
        // adding generated password to the model
        theModel.addAttribute("generated_password", generatedPassword);

        // return employee confirmation page with model attributes
        return "employees/add-employee-confirmation-page";
    }


    // Method handling GET request for delete employee
    @GetMapping("/deleteEmployee")
    public String deleteEmployeeById(@RequestParam("employeeId") int theId){

        // Delete the employee
        employeeService.deleteById(theId);

        // refresh admin panel page for visual update employees list
        return "redirect:/employees/adminPanel";
    }

    // this method handilng POST request for reset employee password, and has task generate new password,
    // saveWithRole the password in DB and send mail with current psasword for employee email
    @PostMapping ("/resetPassword")
    public String resetEmployeePassword(@RequestParam("employeeId") int theId){

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


        return "redirect:/employees/adminPanel";  // zrobic tak by nie bylo przeladowywania strony  AJAX asychronicznosc

    }

    // This method handling POST request for update employee, and has task saveWithRole the updated employee in DB
    // optional will send mail with new username if employee first and last name has been updated
    // optional will set new role for employee
    @PostMapping("/updateEmployee")
    public String updateEmpleyee(@RequestParam("updatedEmployeeId") int theId,@RequestParam("updatedEmployeeFirstName") String theFirstName,
                                 @RequestParam("updatedEmployeeLastName") String theLastName, @RequestParam("updatedEmployeeRole") String theRole,
                                 @RequestParam("updatedEmployeeEmail") String theEmail){

        // Getting employee by id
        Optional<Employee> existingEmployee = employeeService.findById(theId);

        // Creating new employee which inherits current information about existing employee
        Employee updatedEmployee = existingEmployee.get();

        // Setting employee email before optional sending mail with new username
        updatedEmployee.setEmail(theEmail);

        // if employee updated first name not equals to current first name in DB or if employee last name not equals to last name in DB,
        // set new first and last name for updating employee and
        // generate new username for employee and send mail with new username to employee current email
        if (!theFirstName.equals(updatedEmployee.getFirstName()) || !theLastName.equals(updatedEmployee.getLastName())){
            updatedEmployee.setFirstName(theFirstName);
            updatedEmployee.setLastName(theLastName);
            String generateNewUsername = UsernameGenerator.generateUsername(theFirstName,theLastName,employeeService);
            updatedEmployee.setUserName(generateNewUsername);
            emailService.sendEmail(updatedEmployee.getEmail(),emailService.newUsernameSubject(),"Username: " + generateNewUsername);
        }


        // convert role of employee to String
        String currentEmployeeRole = updatedEmployee.getRoles().toString();
        // Defining current role witch has employee by converted employee role
        String definedEmployeeRole = DefiningCurrentEmployeeRole.defineEmployeeRole(currentEmployeeRole);

        // if current employee role it's differs from role from employee update form set up new employee role and saveWithRole employee with new role
        // if current employee role it's not differs from role from employee update form saveWithRole employee withotu role for keep current role
        if (!definedEmployeeRole.equals(theRole)){
            updatedEmployee.setRoles(null);
            employeeService.saveWithRole(updatedEmployee,theRole);
        }else{
            employeeService.saveWithoutRole(updatedEmployee);
        }



        // reload employee list page
        return "redirect:/employees/adminPanel";
    }




}
