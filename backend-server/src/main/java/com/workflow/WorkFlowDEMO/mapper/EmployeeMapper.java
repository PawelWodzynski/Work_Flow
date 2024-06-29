package com.workflow.WorkFlowDEMO.mapper;


import com.workflow.WorkFlowDEMO.data.dto.employee.EmployeeDto;
import com.workflow.WorkFlowDEMO.data.entity.employee.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface EmployeeMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "email", target = "email")
    EmployeeDto toUserDto(Employee employee);



}
