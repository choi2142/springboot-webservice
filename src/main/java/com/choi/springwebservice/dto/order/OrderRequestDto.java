package com.choi.springwebservice.dto.order;

import com.choi.springwebservice.domain.customer.Customer;
import com.choi.springwebservice.domain.order.Order;
import com.choi.springwebservice.domain.order.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class OrderRequestDto {

    private String orderNumber;
    private Customer customer;
    private LocalDateTime orderDate;
    private Double totalAmount;
    private OrderStatus status;

    @Builder
    public OrderRequestDto(String orderNumber, Customer customer, LocalDateTime orderDate, Double totalAmount, OrderStatus status) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public Order toEntity() {
        return Order.builder()
                .orderNumber(orderNumber)
                .customer(customer)
                .orderDate(orderDate)
                .totalAmount(totalAmount)
                .status(status)
                .build();
    }
}