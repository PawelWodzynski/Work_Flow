package com.workflow.WorkFlowDEMO.data.dto.todo.request;


import com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.date.dto.AddTodoDateRequestDtoEmployeeIdValidation;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.date.dto.AddTodoDateRequestDtoMonthNumberValidation;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.date.dto.AddTodoDateRequestDtoYearValidation;

@AddTodoDateRequestDtoMonthNumberValidation
@AddTodoDateRequestDtoYearValidation
@AddTodoDateRequestDtoEmployeeIdValidation
public class AddTodoDateRequestDTO {
    private Integer monthNumber;
    private Integer year;
    private Integer employeeId;

    public AddTodoDateRequestDTO(int monthNumber, int year, int employeeId) {
        this.monthNumber = monthNumber;
        this.year = year;
        this.employeeId = employeeId;
    }

    public Integer getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(Integer monthNumber) {
        this.monthNumber = monthNumber;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
