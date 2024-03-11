package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.point.entity;

import com.workflow.WorkFlowDEMO.data.entity.todo.TodoPoint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PointIdValidationImpl implements ConstraintValidator<PointIdValidation, TodoPoint> {
    @Override
    public void initialize(PointIdValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(TodoPoint todoPoint, ConstraintValidatorContext context) {
        boolean isValid = true;
        String responseMessage = "";

        if (todoPoint.getId() < 0){
            responseMessage = "Given Employee ID cannot equals 0 and cannot be lower from zero";
            isValid = false;
        }

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(responseMessage).addPropertyNode("id").addConstraintViolation();
        }

        return isValid;
    }
}
