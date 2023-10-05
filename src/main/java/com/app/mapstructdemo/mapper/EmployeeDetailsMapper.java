package com.app.mapstructdemo.mapper;

import com.app.mapstructdemo.dto.EmployeeDetailsDTO;
import com.app.mapstructdemo.entity.Department;
import com.app.mapstructdemo.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeDetailsMapper {

    // if any problem with employee.id please install mapstruct support plugin
    @Mapping(source = "employee.id", target = "empId")
    @Mapping(source = "employee.name", target = "empName")
    @Mapping(source = "department.deptName", target = "deptName")
    @Mapping(source = "department.id", target = "deptId")
    EmployeeDetailsDTO toEmployeeDetailsDTO(Employee employee, Department department);


}
