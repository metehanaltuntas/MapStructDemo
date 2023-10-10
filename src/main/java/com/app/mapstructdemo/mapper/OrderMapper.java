package com.app.mapstructdemo.mapper;

import com.app.mapstructdemo.dto.OrderDTO;
import com.app.mapstructdemo.entity.Order;
import org.mapstruct.*;

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

    @BeforeMapping
    default void validateOrderDTO(OrderDTO orderDTO) {
        if (orderDTO.getQuantity() == 0) {
            orderDTO.setQuantity(1);
        }
    }

    @AfterMapping
    default void calculateSum(Order order, @MappingTarget OrderDTO orderDTO) {
        float sum = 0;
        if (order.getQuantity() > 0 && order.getAmount() > 0) {
            sum = order.getAmount() * order.getQuantity();
        }
        orderDTO.setSum(sum);
    }

}
