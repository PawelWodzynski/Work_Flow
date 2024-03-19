package com.workflow.WorkFlowDEMO.data.dto.todo.response;

public class DatesDoesNotExistResponseDTO {
    private boolean existed;
    private String message;

    public DatesDoesNotExistResponseDTO(boolean existed, String message) {
        this.existed = existed;
        this.message = message;
    }

    public boolean isExisted() {
        return existed;
    }

    public void setExisted(boolean existed) {
        this.existed = existed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
