package com.choi.springwebservice.service;

import com.choi.springwebservice.domain.customer.Customer;
import com.choi.springwebservice.domain.order.Order;
import com.choi.springwebservice.domain.order.OrderRepository;
import com.choi.springwebservice.dto.order.OrderRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void 주문번호로_주문_조회() {
        // given
        String orderNumber = "ORD123456";
        Customer customer = new Customer(); // Assume a valid customer object
        OrderRequestDto orderRequestDto = OrderRequestDto.builder()
                .orderNumber(orderNumber)
                .customer(customer)
                .orderDate(LocalDateTime.now())
                .totalAmount(100.0)
                .status(OrderStatus.READY)
                .build();

        orderService.saveOrder(orderRequestDto);

        // when
        Order order = orderService.findOrderByOrderNumber(orderNumber);

        // then
        assertThat(order).isNotNull();
        assertThat(order.getOrderNumber()).isEqualTo(orderNumber);
    }
}