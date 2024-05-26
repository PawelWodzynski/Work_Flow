package com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.implementations;

import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.NotNullIdValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotNullIdValidationImpl implements ConstraintValidator<NotNullIdValidation,Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        boolean isValid = true;
        String responseMessage = "";

        if (value<= 0) {
            responseMessage = "Given ID cannot be equal 0 and cannot be lower from 0";
            isValid = false;
        }
        if (value == null){
            responseMessage = "Given ID cannot be null";
            isValid = false;
        }


        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(responseMessage).addConstraintViolation();
        }

        return isValid;
    }
}
