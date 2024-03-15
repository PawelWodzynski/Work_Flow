package com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.implementations;

import com.workflow.WorkFlowDEMO.api.utils.todo.CurrentDate;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.YearValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class YearValidationImpl implements ConstraintValidator<YearValidation,Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        // Default validity flag
        boolean isValid = true;

        String todoDateYear = String.valueOf(value);
        String responseMessage = "";

        if (value == null) {
            responseMessage ="Year cannot be null";
            isValid = false;
        }

        if (value != null && !todoDateYear.matches(".{1,4}")){
            responseMessage = "The year must consist of four digits";
            isValid = false;
        }




        // If validation fails, add custom error messages
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(responseMessage).addConstraintViolation();
        }

        return isValid;
    }
}
