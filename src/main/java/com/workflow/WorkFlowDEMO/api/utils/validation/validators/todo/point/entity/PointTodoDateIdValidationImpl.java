package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.point.entity;

import com.workflow.WorkFlowDEMO.data.entity.todo.TodoPoint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PointTodoDateIdValidationImpl implements ConstraintValidator<PointTodoDateIdValidation, TodoPoint> {
    @Override
    public void initialize(PointTodoDateIdValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(TodoPoint todoPoint, ConstraintValidatorContext context) {
        // Default validity flag
        boolean isValid = true;


        String responseMessage = "";


        if (todoPoint.getTodoDateId() <= 0){
            responseMessage = "Given To Do Date ID cannot equals 0 and cannot be lower from zero";
            isValid = false;
        }
        if (todoPoint.getTodoDateId() == null){
            responseMessage = "Given To Do Date ID cannot be null";
            isValid = false;
        }



        // If validation fails, add custom error messages
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(responseMessage).addPropertyNode("todoDateId").addConstraintViolation();
        }

        return isValid;
    }
}
