package com.workflow.WorkFlowDEMO.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/workFlow")
public class ViewController {

    // Controller handling request for the home page (App Center)
    @GetMapping("/appCenter")
    public String showHomeAppCenter(){
        // Returns the view name "app-center" to be rendered
        return "app-center";}

    @GetMapping("/adminPanel")
    public String showAdminPanel(){
        // Returns the view name "admin-panel" to be rendered
        return "admin-panel";
    }

}
