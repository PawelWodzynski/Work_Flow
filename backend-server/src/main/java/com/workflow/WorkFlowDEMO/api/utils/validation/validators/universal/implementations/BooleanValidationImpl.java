package com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.implementations;

import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.BooleanValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BooleanValidationImpl implements ConstraintValidator<BooleanValidation,Boolean> {
    @Override
    public boolean isValid(Boolean value, ConstraintValidatorContext context) {
        boolean isValid = true;
        String responseMessage = "";

        if (value == null){
            responseMessage = "Boolean cannot be null";
            isValid = false;
        }



        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(responseMessage).addConstraintViolation();
        }

        return isValid;
    }
}
