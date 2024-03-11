package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.point.entity;

import com.workflow.WorkFlowDEMO.data.entity.todo.TodoPoint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PointOrderValidationImpl implements ConstraintValidator<PointOrderValidation, TodoPoint> {

    @Override
    public void initialize(PointOrderValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(TodoPoint todoPoint, ConstraintValidatorContext context) {
        boolean isValid = true;
        int order = todoPoint.getPointOrder();
        String responseMessage = "";


        if (todoPoint.getPointOrder() == null){
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
