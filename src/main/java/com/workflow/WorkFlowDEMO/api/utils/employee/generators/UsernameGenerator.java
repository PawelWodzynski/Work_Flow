package com.workflow.WorkFlowDEMO.api.utils.employee.generators;

import com.workflow.WorkFlowDEMO.data.entity.employee.Employee;
import com.workflow.WorkFlowDEMO.data.service.employee.EmployeeService;

import java.util.ArrayList;
import java.util.List;

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

        // get list of all cointained employees by lowercase initials
        List<Employee> listOfContainedEmployees = employeeService.findByUsernameContaining(lowercaseInitials);

        // checking employees count in listOfContainedEmployees
        int numberOfUsers = listOfContainedEmployees.size();

        // Creating empty string of final username
        String finalUsername = "";

        // if lower cased initials does't existed in DB admit basic lowercased initials for username
        if (numberOfUsers == 0){
            finalUsername = lowercaseInitials;
        }
        // if lower cased initials exist in DB append the highest number from the same username to new employee username
        else if(numberOfUsers > 0){

            // initialize new ArrayList for numbers from usernames
            List<Integer> theHightestUsernameNumber = new ArrayList<>();

            // get all users from listOfContainedEmployees
            for (Employee employee : listOfContainedEmployees) {

                // if username of employee does't ending with number
                // we must add 0 number to end of username to prevent error
                if (!employee.getUserName().matches(".*\\d$")) {
                    // gettig current employee name
                    String employeeUsername = employee.getUserName();
                    // adding 0 number to end of username
                    String employeeUsernameWithZeroNumber = employeeUsername += "0";
                    // get username and leave only number from string
                    String usernameStringNumber = employeeUsernameWithZeroNumber.replaceAll("[^0-9]", "");
                    // convert string numbers to int number
                    int usernameNumber = Integer.parseInt(usernameStringNumber);
                    //put number to arraylist
                    theHightestUsernameNumber.add(usernameNumber);
                }else {
                    // get username and leave only number from string
                    String usernameStringNumber = employee.getUserName().replaceAll("[^0-9]", "");
                    // convert string numbers to int number
                    int usernameNumber = Integer.parseInt(usernameStringNumber);
                    //put number to arraylist
                    theHightestUsernameNumber.add(usernameNumber);
                }
            }


            // define the highest number
            int highestNumber = 0;
            for (int number : theHightestUsernameNumber) {
                if (number > highestNumber) {
                    highestNumber = number;
                }
            }

            // add 1 to highest number, because new username must be highter from highest number in username of employee
            highestNumber++;

            // define final username
            finalUsername = lowercaseInitials + highestNumber;

        }

        // return final username
        return finalUsername;
    }



}
