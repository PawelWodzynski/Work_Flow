package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.date.entity;

import com.workflow.WorkFlowDEMO.api.utils.todo.CurrentDate;
import com.workflow.WorkFlowDEMO.data.entity.todo.TodoDate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateYearValidationImpl implements ConstraintValidator<DateYearValidation, TodoDate> {
    @Override
    public void initialize(DateYearValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(TodoDate todoDate, ConstraintValidatorContext context) {

        // Default validity flag
        boolean isValid = true;

        // Get the to do date ID as a string
        int year= todoDate.getYear();
        String todoDateYear = String.valueOf(year);
        CurrentDate currentDate = new CurrentDate();
        String responseMessage = "";


        if (todoDate.getYear() == null) {
            // Allowing null due to auto increment in the database
            responseMessage ="Year cannot be null";
            isValid = false;
        }
        if (year < currentDate.getCurrentYear()){
            responseMessage ="Given year cannot be smaller of the current year";
            isValid = false;
        }
        if (year > currentDate.getCurrentYear() && currentDate.getCurrentMonth() != 12){
            responseMessage = "You can only create the next year at the end of the current year " +
                    "( " + currentDate.getCurrentYear() + " )";
            isValid = false;
        }
        if (!todoDateYear.matches(".{1,4}")){
            responseMessage = "The year must consist of four digits";
            isValid = false;
        }




        // If validation fails, add custom error messages
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(responseMessage).addPropertyNode("year").addConstraintViolation();
        }

        return isValid;    }

}
