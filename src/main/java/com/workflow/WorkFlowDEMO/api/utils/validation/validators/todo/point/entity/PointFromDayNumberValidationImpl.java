package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.point.entity;

import com.workflow.WorkFlowDEMO.data.entity.todo.TodoPoint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PointFromDayNumberValidationImpl implements ConstraintValidator<PointFromDayNumberValidation, TodoPoint> {
    @Override
    public void initialize(PointFromDayNumberValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(TodoPoint todoPoint, ConstraintValidatorContext context) {
        boolean isValid = true;
        String fromDayNumber = String.valueOf(todoPoint.getFromDayNumber());
        String responseMessage = "";

        int dayNumber = todoPoint.getFromDayNumber();

        if (todoPoint.getFromDayNumber() == null){
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
