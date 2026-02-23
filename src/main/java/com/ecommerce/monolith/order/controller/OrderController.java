package com.ecommerce.monolith.order.controller;

import com.ecommerce.monolith.order.model.Order;
import com.ecommerce.monolith.order.service.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderServiceImpl orderService;

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestParam Long customerId, @RequestParam BigDecimal amount) {
        return ResponseEntity.ok(orderService.createOrder(customerId, amount));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Order>> getCustomerOrders(@PathVariable Long customerId) {
        return ResponseEntity.ok(orderService.getOrdersByCustomer(customerId));
    }
}