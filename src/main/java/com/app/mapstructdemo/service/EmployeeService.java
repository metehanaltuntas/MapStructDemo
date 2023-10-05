package com.app.mapstructdemo.service;

import com.app.mapstructdemo.dto.EmployeeDTO;
import com.app.mapstructdemo.dto.EmployeeDetailsDTO;
import com.app.mapstructdemo.mapper.EmployeeDetailsMapper;
import com.app.mapstructdemo.mapper.EmployeeMapper;
import com.app.mapstructdemo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    private final EmployeeDetailsMapper employeeDetailsMapper;

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        return employeeMapper.toDTO(employeeRepository.save(employeeMapper.toEntity(employeeDTO)));
    }

    public EmployeeDTO getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(employeeMapper::toDTO)
                .orElse(new EmployeeDTO());
    }

    public EmployeeDetailsDTO getEmployeeDetailsById(Long id) {
        return employeeRepository.findById(id)
                .map(employee -> employeeDetailsMapper.toEmployeeDetailsDTO(employee, employee.getDepartment()))
                .orElse(new EmployeeDetailsDTO());
    }
}
