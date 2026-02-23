package com.ecommerce.monolith.order.service;

import com.ecommerce.monolith.order.model.Order;
import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    Order createOrder(Long customerId, BigDecimal amount);
    List<Order> getOrdersByCustomer(Long customerId);
}