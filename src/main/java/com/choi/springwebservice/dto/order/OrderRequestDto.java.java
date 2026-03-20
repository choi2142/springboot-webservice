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
    private Long customerId;
    private LocalDateTime orderDate;
    private Double totalAmount;
    private OrderStatus status;

    @Builder
    public OrderRequestDto(Long customerId, LocalDateTime orderDate, Double totalAmount, OrderStatus status) {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status != null ? status : OrderStatus.READY;
    }

    public Order toEntity() {
        Customer customer = new Customer(); // This should be fetched from the database
        customer.setId(customerId);
        return Order.builder()
                .customer(customer)
                .orderDate(orderDate)
                .totalAmount(totalAmount)
                .status(status)
                .build();
    }
}