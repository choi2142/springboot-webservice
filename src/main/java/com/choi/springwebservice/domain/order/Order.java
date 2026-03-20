package com.choi.springwebservice.domain.order;

import javax.persistence.*;
import java.time.LocalDateTime;

import com.choi.springwebservice.domain.customer.Customer;
import com.choi.springwebservice.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Order extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String orderNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(nullable = false)
    private LocalDateTime orderDate;

    @Column(nullable = false)
    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status = OrderStatus.READY;

    @Builder
    public Order(String orderNumber, Customer customer, LocalDateTime orderDate, Double totalAmount, OrderStatus status) {
        if (totalAmount <= 0) {
            throw new IllegalArgumentException("Total amount must be greater than zero");
        }
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status != null ? status : OrderStatus.READY;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}