package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.extendedPoint.entity;

import com.workflow.WorkFlowDEMO.data.entity.todo.TodoExtendedPoint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExtendedPointCompletedValidationImpl implements ConstraintValidator<ExtendedPointCompletedValidation, TodoExtendedPoint> {
    @Override
    public void initialize(ExtendedPointCompletedValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(TodoExtendedPoint todoExtendedPoint, ConstraintValidatorContext context) {
        // Default validity flag
        boolean isValid = true;
        boolean completed = todoExtendedPoint.isCompleted();
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
