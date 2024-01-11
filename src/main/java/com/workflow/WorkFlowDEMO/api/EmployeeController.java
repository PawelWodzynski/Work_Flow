package com.workflow.WorkFlowDEMO.api;

import com.workflow.WorkFlowDEMO.data.entity.Employee;
import com.workflow.WorkFlowDEMO.data.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
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
        return "admin-panel";
    }
}
