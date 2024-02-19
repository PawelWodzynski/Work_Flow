package com.workflow.WorkFlowDEMO.data.dto.employee.response;

public class SimpleResponseMessageDTO {

    private String message;

    public SimpleResponseMessageDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SimpleResponseMessageDTO{" +
                "message='" + message + '\'' +
                '}';
    }
}
