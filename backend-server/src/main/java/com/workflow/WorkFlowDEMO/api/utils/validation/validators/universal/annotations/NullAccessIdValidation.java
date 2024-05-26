package com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations;

import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.implementations.NullAccessIdValidationImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NullAccessIdValidationImpl.class)
public @interface NullAccessIdValidation {
    String message() default "ID Validation Error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
