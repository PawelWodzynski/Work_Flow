package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.point.entity;

import com.workflow.WorkFlowDEMO.data.entity.todo.TodoPoint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PointCompletedValidationImpl implements ConstraintValidator<PointCompletedValidation, TodoPoint> {
    @Override
    public void initialize(PointCompletedValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(TodoPoint todoPoint, ConstraintValidatorContext context) {
        // Default validity flag
        boolean isValid = true;
        boolean completed = todoPoint.isCompleted();
        String isCompleted = String.valueOf(completed);
        String responseMessage = "";
        if (isCompleted == null){
            responseMessage = "Completed cannot be null";
            isValid = false;
        }
        if (isCompleted.isEmpty()){
            responseMessage = "Completed cannot be null";
            isValid = false;
        }


        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(responseMessage).addPropertyNode("completed").addConstraintViolation();
        }

        return isValid;
    }
}
