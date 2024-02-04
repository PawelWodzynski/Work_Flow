package com.workflow.WorkFlowDEMO.api;

import com.workflow.WorkFlowDEMO.api.utils.bcrypt.BcryptPasswordEncoder;
import com.workflow.WorkFlowDEMO.api.utils.email.EmailService;
import com.workflow.WorkFlowDEMO.api.utils.employee.DefiningCurrentEmployeeRole;
import com.workflow.WorkFlowDEMO.api.utils.generators.RandomPasswordGenerator;
import com.workflow.WorkFlowDEMO.api.utils.generators.UsernameGenerator;
import com.workflow.WorkFlowDEMO.data.entity.Employee;
import com.workflow.WorkFlowDEMO.data.repository.PageEmployeeRepository;
import com.workflow.WorkFlowDEMO.data.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeHtmlController {

    // Dependency Injection: EmployeeService
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PageEmployeeRepository pageEmployeeRepository;


/////////////////////////////////////////////// REDIRECTING ////////////////////////////////////////////////////////////
    @GetMapping
    public String redirectToAdminPanel(RedirectAttributes attributes) {
        return "redirect:/employees/adminPanel/0";
    }

    @GetMapping("/adminPanel")
    public String redirectToAdminPanel2(){
        return "redirect:/employees/adminPanel/0";
    }

    @GetMapping("/adminPanel/")
    public String redirectToAdminPanel3(){
        return "redirect:/employees/adminPanel/0";
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    // Handling GET request for admin-panel.html
    // This method has task, add to model list of all employees
    // And add to model object of new employee for add employee form
    @GetMapping("/adminPanel/{page}")
    public  String listOfAllEmployeesAndAddEmployee(@PathVariable int page, Model theModel){
        // If the user, manual enter page uder 0 number, redirect to page 0
        if (page<0  ){
            page = 0;
        }
        // define employees list page size
        int pageSize = 13;


//  List of EMPLOYEES
        // Retrieve the list of employees divisioned to pages from the service
        List<Employee> theEmployees = employeeService.findAll(PageRequest.of(page,pageSize));

        // Add the list of employees to the model to make it available in the view
        theModel.addAttribute("employees", theEmployees);

//  Define count of employees for page quantity in page bar in admin-panel.html
        double pageQuantity = (double) employeeService.employeesCountInDB() / pageSize;
        int pageCountRoundedUp = (int) Math.ceil(pageQuantity);

        // Add the page quantity to the model attribute
        theModel.addAttribute("pageQuantity",pageCountRoundedUp);



//  Add Employee
        // Creating new employee object for add employee function in Add Employee button
        Employee theEmployee = new Employee();

        // creating model attribute to bind form data
        // Adding the Employee object to the model
        theModel.addAttribute("employee", theEmployee);

        // Return the view name to be rendered
        return "employees/admin-panel";
    }



    // Handling GET request for admin-panel.html
    // This method has the task of adding to the model a list of all employees searched by the word in the search bar in admin-panel.html
    // And add to model object of new employee for add employee form
    @GetMapping("/adminPanelFindByUsername/{page}")
    public  String listOfEmployeesFindedByUsernameAndAddEmployee(@PathVariable int page, @RequestParam("findByUsername") String searchedName, Model theModel){
        // If the user, manual enter page uder 0 number, redirect to page 0
        if (page<0  ){
            page = 0;
        }
        // define employees list page size
        int pageSize = 13;


//  Page of EMPLOYEES finded by username
        // Retrieve the page of employees from the service
        Page<Employee> theEmployees = pageEmployeeRepository.findByUserNameContaining(searchedName, PageRequest.of(page, pageSize));

        // Add the list of employees to the model to make it available in the view
        theModel.addAttribute("employees", theEmployees);

        //  Define count of employees for page quantity in page bar in admin-panel.html
        double pageQuantity = (double) theEmployees.getTotalElements() / pageSize;
        int pageCountRoundedUp = (int) Math.ceil(pageQuantity);

//  Paging in admin-panel.html
        // Adding attribute with searched name for manage paging in admin-panel.html
        theModel.addAttribute("searchedName",searchedName);

        // Adding attribute with searched name pages quantity  for manage paging in admin-panel.html
        theModel.addAttribute("pageQuantity",pageCountRoundedUp);

        // Adding boolean for if statement for paging in admin-panel.html
        boolean findByUsernamePaging = true;
        theModel.addAttribute("findByUsername",findByUsernamePaging);

//  Add Employee
        // Creating new employee object for add employee function in Add Employee button
        Employee theEmployee = new Employee();

        // creating model attribute to bind form data
        // Adding the Employee object to the model
        theModel.addAttribute("employee", theEmployee);

        // Return the view name to be rendered
        return "employees/admin-panel";
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
    // this method using saveWithoutRole method from EmployeeService
    // in order to overwrite only the employee's data with new password to DB
    // and send mail with current psasword for employee email
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


        return "redirect:/employees/adminPanel";

    }

    // This method handling POST request for update employee, and has task saveWithRole/saveWithoutRole the updated employee to DB
    // optional will send mail with new username if employee first or last name has been updated
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
        // generate new username for employee, and send mail with new username to employee current email
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

        // if current employee role it's differs from role from employee update form, set up new employee role and use saveWithRole method for save with new role
        // if current employee role it's not differs from role from employee update form, use saveWithoutRole method for keep current role
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
