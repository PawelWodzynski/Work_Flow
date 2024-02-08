package com.workflow.WorkFlowDEMO.data.dto;

public class SimpleMessageDTO {

    private String message;

    public SimpleMessageDTO(String message) {
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
        return "SimpleMessageDTO{" +
                "message='" + message + '\'' +
                '}';
    }
}
