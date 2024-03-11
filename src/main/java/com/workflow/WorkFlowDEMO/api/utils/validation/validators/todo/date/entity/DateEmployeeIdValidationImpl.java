package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.date.entity;

import com.workflow.WorkFlowDEMO.data.entity.todo.TodoDate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;



public class DateEmployeeIdValidationImpl implements ConstraintValidator<DateEmployeeIdValidation, TodoDate> {


    @Override
    public void initialize(DateEmployeeIdValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(TodoDate todoDate, ConstraintValidatorContext context) {

        // Default validity flag
        boolean isValid = true;

        // Get the to do date ID as a string

        String responseMessage = "";


        if (todoDate.getEmployeeId() == 0){
            responseMessage = "Given Employee ID cannot equals 0";
            isValid = false;
        }
        if (todoDate.getEmployeeId() == null){
            responseMessage = "Given Employee ID cannot be null";
            isValid = false;
        }



        // If validation fails, add custom error messages
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(responseMessage).addPropertyNode("employeeId").addConstraintViolation();
        }

        return isValid;
    }
}
