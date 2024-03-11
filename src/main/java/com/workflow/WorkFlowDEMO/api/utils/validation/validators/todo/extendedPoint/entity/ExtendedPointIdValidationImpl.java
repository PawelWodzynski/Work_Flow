package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.extendedPoint.entity;

import com.workflow.WorkFlowDEMO.data.entity.todo.TodoExtendedPoint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExtendedPointIdValidationImpl implements ConstraintValidator<ExtendedPointIdValidation, TodoExtendedPoint> {
    @Override
    public void initialize(ExtendedPointIdValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(TodoExtendedPoint todoExtendedPoint, ConstraintValidatorContext context) {
        boolean isValid = true;
        String responseMessage = "";

        if (todoExtendedPoint.getId() < 0){
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
