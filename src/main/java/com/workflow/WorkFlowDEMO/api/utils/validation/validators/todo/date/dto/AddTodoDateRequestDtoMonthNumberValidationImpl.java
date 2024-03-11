package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.date.dto;


import com.workflow.WorkFlowDEMO.data.dto.todo.request.AddTodoDateRequestDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AddTodoDateRequestDtoMonthNumberValidationImpl implements ConstraintValidator<AddTodoDateRequestDtoMonthNumberValidation, AddTodoDateRequestDTO> {
    @Override
    public void initialize(AddTodoDateRequestDtoMonthNumberValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(AddTodoDateRequestDTO addTodoDateRequestDTO, ConstraintValidatorContext context) {
        // Default validity flag
        boolean isValid = true;

        // Get the to do date ID as a string
        int monthNumber = addTodoDateRequestDTO.getMonthNumber();
        String responseMessage = "";


        if(monthNumber > 12 || monthNumber < 1){
            responseMessage = "The given number must be in the range 1-12";
            isValid = false;
        }
        if (addTodoDateRequestDTO.getMonthNumber() == null){
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
