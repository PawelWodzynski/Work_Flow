package com.workflow.WorkFlowDEMO.api.utils.validation.employee.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;



// Custom validation annotate for Employe entity class
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EmployeeFirstNameValidationImpl.class})
@Documented
public @interface EmployeeFirstNameValidation {

    // define default validation message (required)
    String message() default "First Name Validation Error";

    // define validation default groups ,
    // it is not assigned to any specific validation groups,
    // this means that the annotation will be used in any validation context without additional groups
    Class<?>[] groups() default {};

    // transfer of metadata with validation annotation
    Class<? extends Payload>[] payload() default {};
}
