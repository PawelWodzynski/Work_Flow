package com.workflow.WorkFlowDEMO.api.utils.validation.employee.validators;

import com.workflow.WorkFlowDEMO.data.entity.employee.Employee;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// Implementation of EmployeeFirstNameValidation annotate
public class EmployeeFirstNameValidationImpl implements ConstraintValidator<EmployeeFirstNameValidation, Employee> {



    // initialize validator before start validation process
    @Override
    public void initialize(EmployeeFirstNameValidation constraintAnnotation) {
    }


    @Override
    public boolean isValid(Employee employee, ConstraintValidatorContext context) {
        boolean isValid = true;

        StringBuilder errorMessage = new StringBuilder();

        // validation condition for minimum size and not null
        if (employee.getFirstName() == null || employee.getFirstName().trim().isEmpty()) {
            isValid = false;
            errorMessage.append("First Name Of Employee Is Required. ");
        }else {
            // validation condition for requirded uppercased first letter
            if (!employee.getFirstName().matches("^[A-Z].*")) {
                isValid = false;
                errorMessage.append("First Character Must Be An Uppercase Letter. ");
            }else {
                // validation condition for only english letterz without numbers and special characters
                if (!employee.getFirstName().matches("^[A-Za-z]*$")) {
                    isValid = false;
                    errorMessage.append("Only English Letters Are Allowed, And There Cannot Be Any Special Characters Or Numbers. ");
                }else {
                    // validation condition for whitespaces
                    if (employee.getFirstName().contains(" ")) {
                        // Warunek spełniony - w ciągu jest przynajmniej jedna spacja
                        isValid = false;
                        errorMessage.append("The first name cannot contain spaces. ");
                    }
                }
            }

        }

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(errorMessage.toString()).addPropertyNode("firstName").addConstraintViolation();
        }

        return isValid;
    }


}