package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.extendedPoint.dto;

import com.workflow.WorkFlowDEMO.data.dto.todo.request.AddTodoExtendedPointRequestDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AddExtendedPointRequestDtoContentValidationImpl implements ConstraintValidator<AddExtendedPointRequestDtoContentValidation, AddTodoExtendedPointRequestDTO> {
    @Override
    public void initialize(AddExtendedPointRequestDtoContentValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(AddTodoExtendedPointRequestDTO addTodoExtendedPointRequestDTO, ConstraintValidatorContext context) {
        // Default validity flag
        boolean isValid = true;
        String content = addTodoExtendedPointRequestDTO.getContent();
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
