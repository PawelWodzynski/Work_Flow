package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.point.dto;

import com.workflow.WorkFlowDEMO.data.dto.todo.request.AddTodoPointRequestDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PointRequestDtoToDayNumberValidationImpl implements ConstraintValidator<PointRequestDtoToDayNumberValidation, AddTodoPointRequestDTO> {
    @Override
    public void initialize(PointRequestDtoToDayNumberValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(AddTodoPointRequestDTO addTodoPointRequestDTO, ConstraintValidatorContext context) {
        boolean isValid = true;
        String toDayNumber = String.valueOf(addTodoPointRequestDTO.getToDayNumber());
        String responseMessage = "";

        int dayNumber = addTodoPointRequestDTO.getToDayNumber();

        if (addTodoPointRequestDTO.getToDayNumber() == null){
            responseMessage = "To Day Number cannot be null";
            isValid = false;
        }
        if (dayNumber <= 0){
            responseMessage = "Given To Day Number cannot equals 0 and cannot be lower from zero";
            isValid = false;
        }




        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(responseMessage).addPropertyNode("toDayNumber").addConstraintViolation();
        }

        return isValid;
    }
}
