package com.choi.springwebservice.dto.order;

import com.choi.springwebservice.domain.order.Order;
import com.choi.springwebservice.domain.order.OrderStatus;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderResponseDto {
    private Long id;
    private Long customerId;
    private LocalDateTime orderDate;
    private Double totalAmount;
    private OrderStatus status;

    public OrderResponseDto(Order order) {
        this.id = order.getId();
        this.customerId = order.getCustomer().getId();
        this.orderDate = order.getOrderDate();
        this.totalAmount = order.getTotalAmount();
        this.status = order.getStatus();
    }
}