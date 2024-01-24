package com.workflow.WorkFlowDEMO.api.utils;

public class DefiningCurrentEmployeeRole {


    // This class is intended to define the role of the employee for future operations
    public static String defineEmployeeRole(String currentEmployeeRole){
        if (currentEmployeeRole.contains("ADMIN")){
            currentEmployeeRole = "ADMIN";
        } else if (currentEmployeeRole.contains("MANAGER")) {
            currentEmployeeRole = "MANAGER";
        } else if (currentEmployeeRole.contains("EMPLOYEE")) {
            currentEmployeeRole = "EMPLOYEE";
        }
        return  currentEmployeeRole;
    }

}
