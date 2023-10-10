package com.app.mapstructdemo.mapper;

import com.app.mapstructdemo.dto.CustomerDTO;
import com.app.mapstructdemo.entity.Customer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;

/**
 * this mapper is used for
 * ignore a specific field during mapping
 * defaultvalue
 * constant
 * default expression
 * inverse mapping
 */

@Mapper(componentModel = "spring", imports = LocalDate.class)
public interface CustomerMapper {

    @Mapping(source = "customerId", target = "id", ignore = true)
    @Mapping(source = "customerName", target = "name")
    @Mapping(source = "countryName", target = "country", defaultValue = "India")
    @Mapping(source = "registrationDate", target = "registrationDate", dateFormat = "dd/MM/yyyy", defaultExpression = "java(java.time.LocalDate.now())")
    @Mapping(target = "type", constant = "NEW")
    Customer toEntity(CustomerDTO customerDTO);

    /*@Mapping(source = "id", target = "customerId")
    @Mapping(source = "name", target = "customerName")
    @Mapping(source = "country", target = "countryName")
    @Mapping(source = "registrationDate", target = "registrationDate", dateFormat = "dd/MM/yyyy")*/
    @InheritInverseConfiguration
    // if we don't want to write the above mapping we can use this annotation. because we are mapping the same fields
    @Mapping(source = "id", target = "customerId")
    CustomerDTO toDTO(Customer customer);

}