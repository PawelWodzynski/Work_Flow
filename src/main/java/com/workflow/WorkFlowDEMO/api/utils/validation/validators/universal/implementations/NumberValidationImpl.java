package com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.implementations;

import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.NumberValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NumberValidationImpl implements ConstraintValidator<NumberValidation,Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        boolean isValid = true;
        String responseMessage = "";


        if (value == null){
            responseMessage = "Number cannot be null";
            isValid = false;
        }
        if (value != null && value <= 0){
            responseMessage = "Given Number cannot equals 0 and cannot be lower from 0";
            isValid = false;
        }




        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(responseMessage).addConstraintViolation();
        }

        return isValid;
    }
}
