package com.app.mapstructdemo.mapper;

import com.app.mapstructdemo.dto.OrderDTO;
import com.app.mapstructdemo.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "orderAmount", target = "amount")
    @Mapping(source = "orderDate", target = "date", dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(source = "orderStatus", target = "status", qualifiedByName = "checkOrderStatus")
    Order toEntity(OrderDTO orderDTO);

    @Mapping(source = "amount", target = "orderAmount")
    @Mapping(source = "date", target = "orderDate", dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(source = "status", target = "orderStatus", qualifiedByName = "checkOrderStatus")
    OrderDTO toDTO(Order order);

    @Named("checkOrderStatus")
    default boolean checkOrderStatus(String orderStatus) {
        return orderStatus.equalsIgnoreCase("delivered");
    }

    @Named("checkOrderStatus")
    default String checkOrderStatusInString(boolean status) {
        return status ? "delivered" : "pending";
    }
}
