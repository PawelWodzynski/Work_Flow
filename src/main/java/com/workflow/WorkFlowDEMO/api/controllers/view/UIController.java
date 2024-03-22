package com.workflow.WorkFlowDEMO.api.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/workFlow")
public class UIController {

    // Controller handling request for the home page (App Center)
    @GetMapping("/appCenter")
    public String showHomeAppCenter(){
        // Returns the view name "app-center" to be rendered
        return "UI/app-center";}

    @GetMapping("/todo")
    public String todoApp(){
        return "todo/todo-app";
    }


}
