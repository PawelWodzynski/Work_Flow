package com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations;


import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.implementations.NumberValidationImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Constraint(validatedBy = NumberValidationImpl.class)
public @interface NumberValidation {
    String message() default "Number Validation Error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
