package com.app.mapstructdemo.mapper;

import com.app.mapstructdemo.dto.EmployeeDTO;
import com.app.mapstructdemo.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = DepartmentMapper.class)
public interface EmployeeMapper {

    @Mapping(source = "empId", target = "id")
    @Mapping(source = "empName", target = "name")
    @Mapping(source = "departmentDTO", target = "department")
    Employee toEntity(EmployeeDTO employeeDTO);

    @Mapping(source = "id", target = "empId")
    @Mapping(source = "name", target = "empName")
    @Mapping(source = "department", target = "departmentDTO")
    EmployeeDTO toDTO(Employee employee);

}
