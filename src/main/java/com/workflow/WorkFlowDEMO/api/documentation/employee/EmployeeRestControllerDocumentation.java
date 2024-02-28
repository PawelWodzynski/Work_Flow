package com.workflow.WorkFlowDEMO.api.documentation.employee;

public class EmployeeRestControllerDocumentation {

    public static final String findEmployeeByIdDsc = "The request returns parameters of a given user based on ID," +
            "<br>" +
            " Possible responses with JSON parameters:<br>" +
            "<br>" +
            "Response ok:<br>" +
            "<br>" +
            "- id:<br>" +
            "- firstName:<br>" +
            "- lastName:<br>" +
            "- username:<br>" +
            "- roles:<br>" +
            "- email:<br>" +
            "<br>" +
            "Bad Request:<br>" +
            "<br>" +
            "- message:";


    public static final String saveEmployeeDsc = "Method handling POST request at This endpoint has task create an employee<br>" +
            "Validate and save an employee in DB<br>" +
            "On the end, method has returning employee login informations for save confirm or validation errors<br>" +
            "Employee ID it's not required because DB have auto incrementation<br>" +
            "The generated username and password are sent automatically to the employee's email address<br>" +
            "<br>" +
            "<br>All employee parameters are subject to validation<br>" +
            "<br>" +
            "- firstName/lastName:  must start with a capital letter and cannot have white spaces, numbers or special characters<br>" +
            "- role:  the role must correspond to a role from the EmployeeRoleValidationImpl validation class," +
            " by default it can be ADMIN or ROLE_ADMIN, MANAGER or ROLE_MANAGER, EMPLOYEE or ROLE_EMPLOYEE <br>"+
            "- email:  e-mail must contain the @ sign, before this sign it may contain letters," +
            " numbers and allowed special characters \".\" , \"_\", after the @ sign must contain the letters \".\" and letters   ( sa.mple_sample@sample.sm ) <br>"+
            "<br>" +
            "Username of employee is generated automatically from employee first and last name<br> " +
            "Password of employee is generated automatically from RandomPasswordGenerator class<br><br>" +
            "<br>" +
            "Possible responses with JSON parameters:<br>" +
            "<br>" +
            "Response ok:<br>" +
            "<br>" +
            "- generatedUsername:<br>" +
            "- generatedPassword:<br>" +
            "<br>" +
            "Bad Request:<br>" +
            "<br>" +
            "- firstName:<br>" +
            "- lastName:<br>" +
            "- role:<br>" +
            "- email:<br>";

    public static final String updateEmployeeDsc = "This endpoint handles a POST request for an employee update and is intended to use the saveWithRole/saveWithoutRole method depending on the specifics of the edit operation<br>" +
            "Optional will send mail with new username if employee first or last name has been updated<br>" +
            "Optional will set new role for employee<br>" +
            "On the end method sends JSON response with errors or employee informations with appriopriate auth informations<br>" +
            "Validation follows the same rules as in the case of endpoint /saveEmployee<br>" +
            "Possible responses with JSON parameters:<br>" +
            "<br>" +
            "Response ok:<br>" +
            "<br>" +
            "employeeEdited: (boolean true or false)<br>" +
            "messageEditedEmployee: <br>" +
            "messageNoEditedEmployee: <br>" +
            "firstName: <br>" +
            "lastName: <br>" +
            "username: <br>" +
            "email: <br>" +
            "role: <br>" +
            "<br>" +
            "Bad Request:  <br>" +
            "<br>" +
            "firstName: (validation error) <br>" +
            "lastName: (validation error) <br>" +
            "roles: (validation error) <br>" +
            "email: (validation error) <br>" +
            "<br>" +
            "OR <br>" +
            "message: ";

    public static final String resetEmployeePasswordDsc = "This method handilng POST request for reset employee password, and has task generate new password<br>" +
            "This method using saveWithoutRole method from EmployeeService in order to overwrite only the employee's data with new password to DB<br>" +
            "And send mail with current psasword for employee email<br>" +
            "<br>" +
            "Possible responses with JSON parameters:<br>" +
            "<br>" +
            "Response ok/ Bad Request: <br>" +
            "message: ";

    public static final String deleteEmployeeByIdDsc = "Method handling GET request for delete appriopriate employee by id <br>" +
            "<br>" +
            "Possible responses with JSON parameters:<br>" +
            "<br>" +
            "Response ok/ Bad Request: <br>" +
            "message: ";





}
