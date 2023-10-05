package com.app.mapstructdemo.mapper;

import com.app.mapstructdemo.dto.DepartmentDTO;
import com.app.mapstructdemo.entity.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    Department toEntity(DepartmentDTO departmentDTO);

    DepartmentDTO toDTO(Department department);

}
