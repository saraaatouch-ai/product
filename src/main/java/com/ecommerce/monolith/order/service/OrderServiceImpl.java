package com.ecommerce.monolith.order.service;

import com.ecommerce.monolith.order.model.Order;
import com.ecommerce.monolith.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order createOrder(Long customerId, BigDecimal amount) {

        Order order = new Order();
        order.setCustomerId(customerId);
        order.setTotalAmount(amount);
        order.setOrderDate(LocalDateTime.now());
        order.setOrderDate(LocalDateTime.now());


        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrdersByCustomer(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }
}