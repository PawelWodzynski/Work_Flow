package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.point.dto;

import com.workflow.WorkFlowDEMO.data.dto.todo.request.AddTodoPointRequestDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PointRequestDtoTodoDateIdValidationImpl implements ConstraintValidator<PointRequestDtoTodoDateIdValidation, AddTodoPointRequestDTO> {
    @Override
    public void initialize(PointRequestDtoTodoDateIdValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(AddTodoPointRequestDTO addTodoPointRequestDTO, ConstraintValidatorContext context) {
        // Default validity flag
        boolean isValid = true;


        String responseMessage = "";


        if (addTodoPointRequestDTO.getTodoDateId() <= 0){
            responseMessage = "Given Employee ID cannot equals 0 and cannot be lower from zero";
            isValid = false;
        }
        if (addTodoPointRequestDTO.getTodoDateId() == null){
            responseMessage = "Given Employee ID cannot be null";
            isValid = false;
        }



        // If validation fails, add custom error messages
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(responseMessage).addPropertyNode("todoDateId").addConstraintViolation();
        }

        return isValid;
    }
}
