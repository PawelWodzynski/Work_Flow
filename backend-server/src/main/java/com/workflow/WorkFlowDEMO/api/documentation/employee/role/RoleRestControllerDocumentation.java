package com.workflow.WorkFlowDEMO.api.documentation.employee.role;

public class RoleRestControllerDocumentation {

public static final String findRoleByIdDsc = "Find role to authorize users based on the role ID.<br>" +
        "Possible responses with JSON parameters:<br>" +
        "<br>" +
        "Response ok: <br>" +
        "roleName: <br>" +
        "roleId: <br>" +
        "<br>" +
        "Bad Request: <br>" +
        "message: ";

public static final String findRoleByNameDsc = "Find role to authorize users based on the role name. <br>" +
        "Possible responses with JSON parameters:<br>" +
        "<br>" +
        "Response ok: <br>" +
        "roleName: <br>" +
        "roleId: <br>" +
        "<br>" +
        "Bad Request: <br>" +
        "message: ";;

public static final String saveNewRoleDsc = "Creating a main role for employees based on the provided name in order to authorize access to appropriate sources (endpoints) in the application. <br>" +
        "Possible responses with JSON parameters: (without Bad Request )<br>" +
        "<br>" +
        "Response ok: <br>" +
        "message: ";


public static final String deleteRoleByIdDsc = "Removing the main role for authorizing access to appropriate sources (endpoints) in the application for employees based on the provided ID.<br>" +
        "Possible responses with JSON parameters: (without Bad Request )<br>" +
        "<br>" +
        "Response ok: <br>" +
        "message: <br>" +
        "<br>" +
        "Bad Request: <br>" +
        "message: ";
}
