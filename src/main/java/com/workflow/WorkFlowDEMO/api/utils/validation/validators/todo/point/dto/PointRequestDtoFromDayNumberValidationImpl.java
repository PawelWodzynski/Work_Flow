package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.point.dto;

import com.workflow.WorkFlowDEMO.data.dto.todo.request.AddTodoPointRequestDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PointRequestDtoFromDayNumberValidationImpl implements ConstraintValidator<PointRequestDtoFromDayNumberValidation, AddTodoPointRequestDTO> {
    @Override
    public void initialize(PointRequestDtoFromDayNumberValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(AddTodoPointRequestDTO addTodoPointRequestDTO, ConstraintValidatorContext context) {
        boolean isValid = true;
        String fromDayNumber = String.valueOf(addTodoPointRequestDTO.getFromDayNumber());
        String responseMessage = "";

        int dayNumber = addTodoPointRequestDTO.getFromDayNumber();

        if (addTodoPointRequestDTO.getFromDayNumber() == null){
            responseMessage = "From Day Number cannot be null";
            isValid = false;
        }
        if (dayNumber <= 0){
            responseMessage = "Given From Day Number cannot equals 0 and cannot be lower from zero";
            isValid = false;
        }




        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(responseMessage).addPropertyNode("fromDayNumber").addConstraintViolation();
        }

        return isValid;
    }
}
