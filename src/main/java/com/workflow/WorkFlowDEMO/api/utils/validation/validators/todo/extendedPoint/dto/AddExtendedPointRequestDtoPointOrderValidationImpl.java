package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.extendedPoint.dto;

import com.workflow.WorkFlowDEMO.data.dto.todo.request.AddTodoExtendedPointRequestDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AddExtendedPointRequestDtoPointOrderValidationImpl implements ConstraintValidator<AddExtendedPointRequestDtoPointOrderValidation, AddTodoExtendedPointRequestDTO> {
    @Override
    public void initialize(AddExtendedPointRequestDtoPointOrderValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(AddTodoExtendedPointRequestDTO addTodoExtendedPointRequestDTO, ConstraintValidatorContext context) {
        boolean isValid = true;
        int order = addTodoExtendedPointRequestDTO.getTodoExtededPointOrder();
        String responseMessage = "";


        if (addTodoExtendedPointRequestDTO.getTodoExtededPointOrder() == null){
            responseMessage = "Point order cannot be null";
            isValid = false;
        }
        if (order <=0) {
            responseMessage = "Point order cannot equal 0 and lower from 0";
            isValid = false;
        }



        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(responseMessage).addPropertyNode("todoExtededPointOrder").addConstraintViolation();
        }
        return isValid;
    }
}
