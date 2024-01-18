package com.workflow.WorkFlowDEMO.api.utils;

import com.workflow.WorkFlowDEMO.data.service.EmployeeService;

public class UsernameGenerator {

    // Method for generate appriopriate username from first name and last name and a count the same usernames from DB for Employee

    //this method takses first name and last name and insert a dot between first and last name and
    // applies method for find all employees by cointained username from first and last name,
    // if exist cointained the same usernames is appending number of quantities users in last character of username
    // to ensure unique usernames
    public static String generateUsername(String firstName,String lastName, EmployeeService employeeService){



    // Adding first and last name with "." character between name and surname
    String synthesizedInitials = firstName + "." + lastName;

    // Lowercasing sythesizes initials
    String lowercaseInitials = synthesizedInitials.toLowerCase();

        // finding list of the same matched useres to lowercased initials
        employeeService.FindByUsernameContaining(lowercaseInitials);

        // counting the same matched users
        int numberOfUsers = employeeService.FindByUsernameContaining(lowercaseInitials).size();

        // Creating empty string of final username
        String finalUsername = "";

        // if lower cased initials does't existed in DB admit basic lowercased initials for username
        if (numberOfUsers == 0){
            finalUsername = lowercaseInitials;
        }
        // if lower cased initials exist in DB append count of existed users number to basic lowercased initials for username
        else if(numberOfUsers > 0){
            finalUsername = lowercaseInitials + numberOfUsers;
        }

        // return final username
        return finalUsername;
    }



}
