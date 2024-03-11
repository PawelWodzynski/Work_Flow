package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.extendedPoint.entity;

import com.workflow.WorkFlowDEMO.data.entity.todo.TodoExtendedPoint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExtendedPointTodoPointIdValidationImpl implements ConstraintValidator<ExtendedPointTodoPointIdValidation, TodoExtendedPoint> {
    @Override
    public void initialize(ExtendedPointTodoPointIdValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(TodoExtendedPoint extendedPoint, ConstraintValidatorContext context) {
        // Default validity flag
        boolean isValid = true;


        String responseMessage = "";


        if (extendedPoint.getTodoPointId() <= 0){
            responseMessage = "Given To Do Point ID cannot equals 0 and cannot be lower from zero";
            isValid = false;
        }
        if (extendedPoint.getTodoPointId() == null){
            responseMessage = "Given To Do Point ID cannot be null";
            isValid = false;
        }



        // If validation fails, add custom error messages
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(responseMessage).addPropertyNode("todoPointId").addConstraintViolation();
        }

        return isValid;
    }
}
