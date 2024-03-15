package com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations;


import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.implementations.BooleanValidationImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Constraint(validatedBy = BooleanValidationImpl.class)
public @interface BooleanValidation {
    String message() default "Boolean Validation Error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
