package com.workflow.WorkFlowDEMO.data.dto.error;

public class ErrorDto {
    private String message;

    private ErrorDto(Builder builder) {
        this.message = builder.message;
    }

    public ErrorDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ErrorDto{" +
                "message='" + message + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String message;

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public ErrorDto build() {
            return new ErrorDto(this);
        }
    }
}
