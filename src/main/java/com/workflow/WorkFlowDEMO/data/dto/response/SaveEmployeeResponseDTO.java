package com.workflow.WorkFlowDEMO.data.dto.response;


// Data Transfer Object for OK response for EmployeeRestController
// Contains basic message, generated username and generated password
public class SaveEmployeeResponseDTO {

    private String bodyMessage = "Sucessfull Added Employee";
    private String generatedUsername;
    private String generatedPassword;

    public SaveEmployeeResponseDTO(String generatedUsername, String generatedPassword) {
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
        return "SaveEmployeeResponseDTO{" +
                "bodyMessage='" + bodyMessage + '\'' +
                ", generatedUsername='" + generatedUsername + '\'' +
                ", generatedPassword='" + generatedPassword + '\'' +
                '}';
    }
}
