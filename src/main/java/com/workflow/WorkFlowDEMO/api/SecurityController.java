package com.workflow.WorkFlowDEMO.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    // Controller handling requests related to login
    @GetMapping("/loginPage")
    public String showLoginPage() {
        // Returns the view name "login-page" to be rendered
        return "login-page";
    }

    // Controller handling request related to access denied
    @GetMapping("/access-denied")
    public String showAccesDeniedPage(){
        // Returns the view name "accesss-denied" to be rendered
        return "access-denied";
    }


}
