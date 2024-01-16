package com.workflow.WorkFlowDEMO.api;

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
    public  String listEmployees(Model theModel){

        // Retrieve the list of employees from the service
        List<Employee> theEmployee = employeeService.findAll();

        // Add the list of employees to the model to make it available in the view
        theModel.addAttribute("employees", theEmployee);

        // Return the view name to be rendered
        return "employees/admin-panel";
    }

    // Method handling GET request at "/addEmployee" in admin-panel.html
    @GetMapping("/addEmployee")
    public String addEmployeeForm(Model theModel){

        // create model attribute to bind form data
        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee); // Add the Employee object to the model

        return "employees/add-employee-form"; // Return the view name for the add-employee form
    }

    //Method handling POST request at "/saveEmployee" in add-employee-form.html
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee, @RequestParam("selectedRole") String theRole){


        //save the employee using the appropriate service (employeeService)
        employeeService.save(theEmployee, theRole);

        // redirect to the /employees/adminPanel to prevent duplicate submissions
        return "redirect:/employees/adminPanel";
    }




}
