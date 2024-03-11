package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.point.entity;

import com.workflow.WorkFlowDEMO.data.entity.todo.TodoPoint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PointContentValidationImpl implements ConstraintValidator<PointContentValidation, TodoPoint> {
    @Override
    public void initialize(PointContentValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(TodoPoint todoPoint, ConstraintValidatorContext context) {
        boolean isValid = true;
        String content = todoPoint.getContent();
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
