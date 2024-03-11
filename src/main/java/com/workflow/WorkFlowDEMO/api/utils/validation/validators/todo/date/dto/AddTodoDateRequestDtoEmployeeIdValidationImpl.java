package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.date.dto;

import com.workflow.WorkFlowDEMO.data.dto.todo.request.AddTodoDateRequestDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AddTodoDateRequestDtoEmployeeIdValidationImpl implements ConstraintValidator<AddTodoDateRequestDtoEmployeeIdValidation, AddTodoDateRequestDTO> {
    @Override
    public void initialize(AddTodoDateRequestDtoEmployeeIdValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(AddTodoDateRequestDTO addTodoDateRequestDTO, ConstraintValidatorContext context) {

        // Default validity flag
        boolean isValid = true;


        String responseMessage = "";


        if (addTodoDateRequestDTO.getEmployeeId() <= 0){
            responseMessage = "Given Employee ID cannot equals 0 and cannot be lower from zero";
            isValid = false;
        }
        if (addTodoDateRequestDTO.getEmployeeId() == null){
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
