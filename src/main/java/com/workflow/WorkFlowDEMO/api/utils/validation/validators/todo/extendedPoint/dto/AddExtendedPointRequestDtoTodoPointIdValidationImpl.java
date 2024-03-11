package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.extendedPoint.dto;

import com.workflow.WorkFlowDEMO.data.dto.todo.request.AddTodoExtendedPointRequestDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AddExtendedPointRequestDtoTodoPointIdValidationImpl implements ConstraintValidator<AddExtendedPointRequestDtoTodoPointIdValidation, AddTodoExtendedPointRequestDTO> {
    @Override
    public void initialize(AddExtendedPointRequestDtoTodoPointIdValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(AddTodoExtendedPointRequestDTO addTodoExtendedPointRequestDTO, ConstraintValidatorContext context) {
        // Default validity flag
        boolean isValid = true;


        String responseMessage = "";


        if (addTodoExtendedPointRequestDTO.getTodoPointId() <= 0){
            responseMessage = "Given To Do Point ID cannot equals 0 and cannot be lower from zero";
            isValid = false;
        }
        if (addTodoExtendedPointRequestDTO.getTodoPointId() == null){
            responseMessage = "Given To Do Point ID cannot be null";
            isValid = false;
        }



        // If validation fails, add custom error messages
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(responseMessage).addPropertyNode("todoPointId").addConstraintViolation();
        }

        return isValid;
    }
}
