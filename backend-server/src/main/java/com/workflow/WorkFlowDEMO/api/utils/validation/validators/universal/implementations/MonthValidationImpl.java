package com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.implementations;

import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.MonthValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MonthValidationImpl implements ConstraintValidator<MonthValidation,Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        boolean isValid = true;
        String responseMessage = "";


        if(value > 12 || value < 1){
            responseMessage = "The given month number must be in the range 1-12";
            isValid = false;
        }
        if (value == null){
            responseMessage ="The Month Number cannot be null";
            isValid = false;
        }




        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(responseMessage).addConstraintViolation();
        }

        return isValid;
    }
}
