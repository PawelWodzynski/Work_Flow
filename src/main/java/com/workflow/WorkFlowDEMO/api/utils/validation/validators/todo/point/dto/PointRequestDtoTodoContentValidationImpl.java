package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.point.dto;

import com.workflow.WorkFlowDEMO.data.dto.todo.request.AddTodoPointRequestDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PointRequestDtoTodoContentValidationImpl implements ConstraintValidator<PointRequestDtoTodoContentValidation, AddTodoPointRequestDTO> {
    @Override
    public void initialize(PointRequestDtoTodoContentValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(AddTodoPointRequestDTO addTodoPointRequestDTO, ConstraintValidatorContext context) {
        // Default validity flag
        boolean isValid = true;
        String content = addTodoPointRequestDTO.getContent();
        String responseMessage = "";
        if (content == null){
            responseMessage = "Content cannot be null";
            isValid = false;
        }
        if (content.isEmpty()){
            responseMessage = "Content cannot be null";
            isValid = false;
        }
        if (content.length() > 256){
            responseMessage = "Content cannot have more than 256 characters";
            isValid = false;
        }

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(responseMessage).addPropertyNode("content").addConstraintViolation();
        }

        return isValid;
    }
}
