package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.point.entity;

import com.workflow.WorkFlowDEMO.data.entity.todo.TodoPoint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PointToDayNumberValidationImpl implements ConstraintValidator<PointToDayNumberValidation, TodoPoint> {
    @Override
    public void initialize(PointToDayNumberValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(TodoPoint todoPoint, ConstraintValidatorContext context) {
        boolean isValid = true;
        String responseMessage = "";

        int dayNumber = todoPoint.getToDayNumber();

        if (todoPoint.getToDayNumber() == null){
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
