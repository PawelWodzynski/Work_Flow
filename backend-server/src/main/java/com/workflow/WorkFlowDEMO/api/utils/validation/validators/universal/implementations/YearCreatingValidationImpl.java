package com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.implementations;

import com.workflow.WorkFlowDEMO.api.utils.todo.CurrentDate;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.YearCreatingValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class YearCreatingValidationImpl implements ConstraintValidator<YearCreatingValidation,Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        // Default validity flag
        boolean isValid = true;

        // Get the to do date ID as a string
        String todoDateYear = String.valueOf(value);
        CurrentDate currentDate = new CurrentDate();
        String responseMessage = "";


        if (value == null) {
            responseMessage ="Year cannot be null";
            isValid = false;
        }
        if (value != null && value < currentDate.getCurrentYear()){
            responseMessage ="Given year cannot be smaller of the current year";
            isValid = false;
        }
        if (value != null && value > currentDate.getCurrentYear() && currentDate.getCurrentMonth() != 12){
            responseMessage = "You can only create the next year at the end of the current year " +
                    "( " + currentDate.getCurrentYear() + ".12.01"+ " )";
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
