package com.choi.springwebservice.service;

import com.choi.springwebservice.domain.order.Order;
import com.choi.springwebservice.domain.order.OrderRepository;
import com.choi.springwebservice.dto.order.OrderRequestDto;
import com.choi.springwebservice.dto.order.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    @Transactional
    public Long createOrder(OrderRequestDto orderRequestDto) {
        Order order = orderRequestDto.toEntity();
        if (order.getTotalAmount() <= 0) {
            throw new IllegalArgumentException("Total amount must be greater than zero");
        }
        return orderRepository.save(order).getId();
    }

    @Transactional(readOnly = true)
    public OrderResponseDto getOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
        return new OrderResponseDto(order);
    }
}