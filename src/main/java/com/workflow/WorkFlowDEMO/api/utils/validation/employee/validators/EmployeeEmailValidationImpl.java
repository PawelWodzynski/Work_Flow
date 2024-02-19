package com.workflow.WorkFlowDEMO.api.utils.validation.employee.validators;

import com.workflow.WorkFlowDEMO.data.entity.employee.Employee;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// implementation of EmployeeEmailValidation annotate
public class EmployeeEmailValidationImpl implements ConstraintValidator<EmployeeEmailValidation, Employee> {


    // Initialize validator before starting validation process
    @Override
    public void initialize(EmployeeEmailValidation constraintAnnotation) {
    }


    @Override
    public boolean isValid(Employee employee, ConstraintValidatorContext context) {
        boolean isValid = true;

        StringBuilder errorMessage = new StringBuilder();

        // Validate if email is not null or empty
        String email = employee.getEmail();
        if (email == null || email.trim().isEmpty()) {
            isValid = false;
            errorMessage.append("Email is required. ");
        } else {
            // Validate if email contains '@' symbol
            if (!email.contains("@")) {
                isValid = false;
                errorMessage.append("Email must contain '@' symbol. ");
            } else {
                // Split email address into parts before and after '@'
                String[] parts = email.split("@");
                if (parts.length != 2) {
                    isValid = false;
                    errorMessage.append("Invalid email format. ");
                } else {
                    String localPart = parts[0];
                    String domainPart = parts[1];

                    // Validate local part before '@'
                    if (!localPart.matches("[a-zA-Z0-9._]+")) {
                        isValid = false;
                        errorMessage.append("Local part must contain only letters, digits, '.', or '_'. ");
                    }

                    // Validate domain part after '@'
                    if (!domainPart.matches("[a-zA-Z0-9.-]+")) {
                        isValid = false;
                        errorMessage.append("Domain part must contain only letters, digits, '-' or '.'. ");
                    } else {
                        // Check if there is a domain name before the dot
                        int lastDotIndex = domainPart.lastIndexOf(".");
                        if (lastDotIndex == -1 || lastDotIndex == domainPart.length() - 1) {
                            isValid = false;
                            errorMessage.append("After the dot in the domain, there must be a domain name. ");
                        } else {
                            // Check if there is at least one character before the dot
                            int lastAtIndex = domainPart.lastIndexOf("@");
                            String domainName = domainPart.substring(lastAtIndex + 1, lastDotIndex);
                            if (domainName.isEmpty()) {
                                isValid = false;
                                errorMessage.append("Before the dot in the domain, there must be at least one character. ");
                            }
                        }
                    }
                }
            }
        }

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(errorMessage.toString()).addPropertyNode("email").addConstraintViolation();
        }

        return isValid;
    }

}
