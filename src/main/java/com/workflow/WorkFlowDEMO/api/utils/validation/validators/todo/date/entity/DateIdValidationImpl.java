package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.date.entity;

import com.workflow.WorkFlowDEMO.data.entity.todo.TodoDate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateIdValidationImpl implements ConstraintValidator<DateIdValidation, TodoDate> {

    @Override
    public void initialize(DateIdValidation constraintAnnotation) {
        // Initializing the constraint validator
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(TodoDate todoDate, ConstraintValidatorContext context) {
        // Default validity flag
        boolean isValid = true;
        String responseMessage = "";



        if (todoDate.getId() <= 0) {
            responseMessage = "Given ID cannot be equal 0 and cannot be lower from 0";
            isValid = false;
        }
        if (todoDate.getId() == null){
            responseMessage = "Given ID cannot be null";
            isValid = false;
        }





        // If validation fails, add custom error messages
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(responseMessage).addPropertyNode("id").addConstraintViolation();
        }

        return isValid;
    }

}
