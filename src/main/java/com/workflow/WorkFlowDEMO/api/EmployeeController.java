package com.workflow.WorkFlowDEMO.api;

import com.workflow.WorkFlowDEMO.api.utils.BcryptPasswordEncoder;
import com.workflow.WorkFlowDEMO.api.utils.RandomPasswordGenerator;
import com.workflow.WorkFlowDEMO.api.utils.UsernameGenerator;
import com.workflow.WorkFlowDEMO.data.entity.Employee;
import com.workflow.WorkFlowDEMO.data.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    // Dependency Injection: EmployeeService
    private EmployeeService employeeService;

    // Controller constructor dependent on EmployeeService
    public EmployeeController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
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

        //save the employee using the appropriate service (employeeService)
        employeeService.save(theEmployee, theRole);

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




}
