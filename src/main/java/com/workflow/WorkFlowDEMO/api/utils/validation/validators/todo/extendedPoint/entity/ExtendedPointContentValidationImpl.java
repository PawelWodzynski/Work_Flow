package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.extendedPoint.entity;

import com.workflow.WorkFlowDEMO.data.entity.todo.TodoExtendedPoint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExtendedPointContentValidationImpl implements ConstraintValidator<ExtendedPointContentValidation, TodoExtendedPoint> {
    @Override
    public void initialize(ExtendedPointContentValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(TodoExtendedPoint todoExtendedPoint, ConstraintValidatorContext context) {
        boolean isValid = true;
        String content = todoExtendedPoint.getContent();
        String responseMessage = "";
        if (content == null){
            responseMessage = "Content cannot be null";
            isValid = false;
        }
        if (content.isEmpty()){
            responseMessage = "Content cannot be null";
            isValid = false;
        }
        if (content.length() > 256){
            responseMessage = "Content cannot have more than 256 characters";
            isValid = false;
        }

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(responseMessage).addPropertyNode("content").addConstraintViolation();
        }

        return isValid;
    }
}
