package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.extendedPoint.entity;

import com.workflow.WorkFlowDEMO.data.entity.todo.TodoExtendedPoint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExtendedPointPointOrderValidationImpl implements ConstraintValidator<ExtendedPointPointOrderValidation, TodoExtendedPoint> {
    @Override
    public void initialize(ExtendedPointPointOrderValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(TodoExtendedPoint todoExtendedPoint, ConstraintValidatorContext context) {
        boolean isValid = true;
        int order = todoExtendedPoint.getPointOrder();
        String responseMessage = "";


        if (todoExtendedPoint.getPointOrder() == null){
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
