package com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.implementations;

import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.ContentValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ContentValidationImpl implements ConstraintValidator<ContentValidation,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isValid = true;
        String responseMessage = "";

        if (value == null){
            responseMessage = "Content cannot be null";
            isValid = false;
        }
        if (value != null && value.isBlank()){
            responseMessage = "Content cannot be blank";
            isValid = false;
        }
        if (value != null && value.length() > 256){
            responseMessage = "Content cannot have more than 256 characters";
            isValid = false;
        }

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(responseMessage).addConstraintViolation();
        }

        return isValid;
    }
}
