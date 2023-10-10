package com.app.mapstructdemo.service;


import com.app.mapstructdemo.dto.OrderDTO;
import com.app.mapstructdemo.entity.Order;
import com.app.mapstructdemo.mapper.OrderMapper;
import com.app.mapstructdemo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {


    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    public Order saveOrder(OrderDTO orderDTO) {
        return orderRepository.save(orderMapper.toEntity(orderDTO));
    }

    public OrderDTO getOrderById(Long id) {
        return orderRepository.findById(id)
                .map(orderMapper::toDTO)
                .orElse(new OrderDTO());
    }

}