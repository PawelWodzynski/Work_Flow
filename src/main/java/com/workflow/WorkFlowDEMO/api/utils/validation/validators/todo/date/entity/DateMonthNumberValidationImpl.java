package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.date.entity;

import com.workflow.WorkFlowDEMO.data.entity.todo.TodoDate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateMonthNumberValidationImpl implements ConstraintValidator<DateMonthNumberValidation, TodoDate> {

    @Override
    public void initialize(DateMonthNumberValidation constraintAnnotation) {
        // Initializing the constraint validator
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(TodoDate todoDate, ConstraintValidatorContext context) {

        // Default validity flag
        boolean isValid = true;

        // Get the to do date ID as a string
        int monthNumber = todoDate.getMonthNumber();

        String responseMessage = "";


        if(monthNumber > 12 || monthNumber < 1){
            responseMessage = "The given number must be in the range 1-12";
            isValid = false;
        }
        if (todoDate.getMonthNumber() == null){
            responseMessage ="The monthNumber cannot be null";
            isValid = false;
        }




        // If validation fails, add custom error messages
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(responseMessage).addPropertyNode("monthNumber").addConstraintViolation();
        }

        return isValid;



    }


}
