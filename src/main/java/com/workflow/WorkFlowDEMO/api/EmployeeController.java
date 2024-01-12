package com.workflow.WorkFlowDEMO.api;

import com.workflow.WorkFlowDEMO.data.entity.Employee;
import com.workflow.WorkFlowDEMO.data.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    // Handling GET request at "/employee/adminPanel"
    @GetMapping("/adminPanel")
    public  String listEmployees(Model theModel){

        // Retrieve the list of employees from the service
        List<Employee> theEmployee = employeeService.findAll();

        // Add the list of employees to the model to make it available in the view
        theModel.addAttribute("employees", theEmployee);

        // Return the view name to be rendered
        return "employees/admin-panel";
    }

    // Method handling GET request at "/addEmployee"
    @GetMapping("/addEmployee")
    public String addEmployeeForm(Model theModel){

        // create model attribute to bind form data
        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee); // Add the Employee object to the model

        return "employees/add-employee-form"; // Return the view name for the add-employee form
    }

    //Method handling POST request at "/saveEmployee"
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){

        //save the employee using the appropriate service (employeeService)
        employeeService.save(theEmployee);

        // redirect to the /employees/adminPanel to prevent duplicate submissions
        return "redirect:/employees/adminPanel";
    }




}
