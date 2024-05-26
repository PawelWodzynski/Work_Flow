package com.workflow.WorkFlowDEMO.api.utils.validation.validators.employee;

import com.workflow.WorkFlowDEMO.data.entity.employee.Employee;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeeIdValidationImpl implements ConstraintValidator<EmployeeIdValidation, Employee> {

    @Override
    public void initialize(EmployeeIdValidation constraintAnnotation) {
        // Initializing the constraint validator
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Employee employee, ConstraintValidatorContext context) {
        // Default validity flag
        boolean isValid = true;

        // Get the employee ID as a string
        String employeeId = String.valueOf(employee.getId());


            if (!employeeId.matches("\\d+")) {
                // Regular expression validation - checking if the ID consists only of digits
                isValid = false;
            }
             if (employee.getId() == null) {
                 // Allowing null due to auto increment in the database
                 isValid = true;
              }


        // If validation fails, add custom error messages
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Employee ID must be a numeric value, without special characters, may be null due to auto increment").addPropertyNode("id").addConstraintViolation();
        }

        return isValid;
    }
}
