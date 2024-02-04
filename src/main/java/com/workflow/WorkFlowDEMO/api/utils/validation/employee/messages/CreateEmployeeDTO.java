package com.workflow.WorkFlowDEMO.api.utils.validation.employee.messages;


// Data Transfer Object for OK response for EmployeeRestController
// Contains basic message, generated username and generated password
public class CreateEmployeeDTO {

    private String bodyMessage = "Sucessfull Added Employee";
    private String generatedUsername;
    private String generatedPassword;

    public CreateEmployeeDTO(String generatedUsername, String generatedPassword) {
        this.generatedUsername = generatedUsername;
        this.generatedPassword = generatedPassword;
    }

    public String getGeneratedUsername() {
        return generatedUsername;
    }

    public void setGeneratedUsername(String generatedUsername) {
        this.generatedUsername = generatedUsername;
    }

    public String getGeneratedPassword() {
        return generatedPassword;
    }

    public void setGeneratedPassword(String generatedPassword) {
        this.generatedPassword = generatedPassword;
    }

    @Override
    public String toString() {
        return "CreateEmployeeDTO{" +
                "bodyMessage='" + bodyMessage + '\'' +
                ", generatedUsername='" + generatedUsername + '\'' +
                ", generatedPassword='" + generatedPassword + '\'' +
                '}';
    }
}
