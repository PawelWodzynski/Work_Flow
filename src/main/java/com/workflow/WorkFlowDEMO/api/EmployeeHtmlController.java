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
        Page<Employee> theEmployees = employeeService.findByUserNameContaining(searchedName, PageRequest.of(page, pageSize));

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










}
