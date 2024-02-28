package com.workflow.WorkFlowDEMO.api.utils.validation.employee.validators;

import com.workflow.WorkFlowDEMO.data.entity.employee.Employee;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeeLastNameValidationImpl implements ConstraintValidator<EmployeeLastNameValidation, Employee> {

    @Override
    public void initialize(EmployeeLastNameValidation constraintAnnotation) {
    }

    @Override
    public boolean isValid(Employee employee, ConstraintValidatorContext context) {
        boolean isValid = true;

        StringBuilder errorMessage = new StringBuilder();

        // validation condition for minimum size and not null
        if (employee.getLastName() == null || employee.getLastName().trim().isEmpty()) {
            isValid = false;
            errorMessage.append("Last Name Of Employee Is Required. ");
        }else {
            // validation condition for requirded uppercased first letter
            if (!employee.getLastName().matches("^[A-Z].*")) {
                isValid = false;
                errorMessage.append("First Character Must Be An Uppercase Letter. ");
            }else {
                // validation condition for only english letterz without numbers and special characters
                if (!employee.getLastName().matches("^[A-Za-z]*$")) {
                    isValid = false;
                    errorMessage.append("Only English Letters Are Allowed, And There Cannot Be Any Special Characters Or Numbers. ");
                }else {
                    // validation condition for whitespaces
                    if (employee.getLastName().contains(" ")) {
                        // Warunek spełniony - w ciągu jest przynajmniej jedna spacja
                        isValid = false;
                        errorMessage.append("The last name cannot contain spaces. ");
                    }
                }
            }

        }

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(errorMessage.toString()).addPropertyNode("lastName").addConstraintViolation();
        }

        return isValid;
    }
}
