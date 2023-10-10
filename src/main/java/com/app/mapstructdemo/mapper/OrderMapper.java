package com.app.mapstructdemo.mapper;

import com.app.mapstructdemo.dto.OrderDTO;
import com.app.mapstructdemo.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "orderAmount", target = "amount")
    @Mapping(source = "orderDate", target = "date", dateFormat = "dd-MM-yyyy HH:mm:ss")
    Order toEntity(OrderDTO orderDTO);

    @Mapping(source = "amount", target = "orderAmount")
    @Mapping(source = "date", target = "orderDate", dateFormat = "dd-MM-yyyy HH:mm:ss")
    OrderDTO toDTO(Order order);

}
