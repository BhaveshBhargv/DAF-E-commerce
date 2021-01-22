package com.DFA.ecommerce.controler;

import com.DFA.ecommerce.models.Orders;
import com.DFA.ecommerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "home/orders")
public class OrderController {

    public final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Orders> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping
    @RequestMapping(path = "/add")
    public void addOrder(@RequestBody Orders orders) {
        orderService.addOrder(orders);
    }

    @PostMapping
    @RequestMapping(path = "/updateStatus")
    public void updateOrder(@RequestBody Orders orders) {
        orderService.updateOrder(orders);
    }

}