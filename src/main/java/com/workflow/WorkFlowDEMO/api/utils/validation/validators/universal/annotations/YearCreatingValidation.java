package com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations;


import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.implementations.YearCreatingValidationImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = YearCreatingValidationImpl.class)
public @interface YearCreatingValidation {

    String message() default "Year Validation Error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
