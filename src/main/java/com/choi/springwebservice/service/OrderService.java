package com.choi.springwebservice.service;

import com.choi.springwebservice.domain.order.Order;
import com.choi.springwebservice.domain.order.OrderRepository;
import com.choi.springwebservice.dto.order.OrderRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public Long saveOrder(OrderRequestDto orderRequestDto) {
        Order order = orderRequestDto.toEntity();
        return orderRepository.save(order).getId();
    }

    @Transactional(readOnly = true)
    public Order findOrderByOrderNumber(String orderNumber) {
        return orderRepository.findByOrderNumber(orderNumber);
    }
}