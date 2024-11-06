package com.sapana.orderservice.controller;

import com.sapana.basedomains.dto.Order;
import com.sapana.basedomains.dto.OrderEvent;
import com.sapana.orderservice.kafka.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Author: Sapana Rimal
 * Date: 10/22/2024
 */

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderProducer orderProducer;

    @PostMapping("/create")
    public String createOrder(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("Order status is in pending state");
        orderEvent.setOrder(order);

        orderProducer.sendMessage(orderEvent);
        return "Order placed Successfully";
    }

    @GetMapping("/{id}")
    public Map<String, String> getOrderById(@PathVariable String id) {
        return Map.of(
                "id", id,
                "name", "DEll",
                "price", "50000"
        );
    }
    @GetMapping()
    public List<Order> getOrderList() {
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Order order = new Order();
            order.setOrderId(UUID.randomUUID().toString());
            order.setName("DELL " + (i + 1));
            order.setPrice(50000 + (i * 1000)); // Increment price for variety
            orders.add(order);
        }
        return orders;
    }
}
