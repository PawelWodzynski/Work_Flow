package com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.implementations;

import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.NullAccessIdValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NullAccessIdValidationImpl implements ConstraintValidator<NullAccessIdValidation,Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        boolean isValid = true;
        String responseMessage = "";


        if (value != null && value < 0) {
            responseMessage = "Given ID cannot be lower from 0";
            isValid = false;
        }



        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(responseMessage).addConstraintViolation();
        }

        return isValid;
    }
}
