package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.point.dto;

import com.workflow.WorkFlowDEMO.data.dto.todo.request.AddTodoPointRequestDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PointRequestDtoPointOrderValidationImpl implements ConstraintValidator<PointRequestDtoPointOrderValidation, AddTodoPointRequestDTO> {
    @Override
    public void initialize(PointRequestDtoPointOrderValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(AddTodoPointRequestDTO addTodoPointRequestDTO, ConstraintValidatorContext context) {
        boolean isValid = true;
        int order = addTodoPointRequestDTO.getPointOrder();
        String responseMessage = "";


        if (addTodoPointRequestDTO.getPointOrder() == null){
            responseMessage = "Point order cannot be null";
            isValid = false;
        }
        if (order <=0) {
            responseMessage = "Point order cannot equal 0 and lower from 0";
            isValid = false;
        }



        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(responseMessage).addPropertyNode("pointOrder").addConstraintViolation();
        }
        return isValid;
    }
}
