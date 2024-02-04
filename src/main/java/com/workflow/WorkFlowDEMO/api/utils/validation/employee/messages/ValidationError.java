package com.workflow.WorkFlowDEMO.api.utils.validation.employee.messages;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;


import java.util.Map;
import java.util.stream.Collectors;

// Result message of validation
public class ValidationError {

    // Result Message
    public static Map<String, String> getErrors(BindingResult bindingResult) {
        // return validation result for appriopriate field
        return bindingResult.getFieldErrors()
                .stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
    }

}