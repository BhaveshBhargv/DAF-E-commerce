package com.DFA.ecommerce.services;

import com.DFA.ecommerce.exceptions.ItemNotFoundException;
import com.DFA.ecommerce.models.Orders;
import com.DFA.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Orders> getOrders() {
        return orderRepository.findAll();
    }

    public void addOrder(Orders orders) {
        orderRepository.save(orders);
    }

    public void updateOrder(Orders orders) {
        Orders updateOrders = orderRepository.findById(orders.getId()).orElseThrow(() -> new ItemNotFoundException(orders.getId()));;
        if(orders.getStatus() != null) {
            updateOrders.setStatus(orders.getStatus());
        }
        orderRepository.saveAndFlush(updateOrders);
    }

    public String bestItem() {
        String bestItem = orderRepository.findByOrder_quantityAndItem_name();
        return bestItem;
    }

    public String bestCategory() {
        String bestCategory = orderRepository.findByOrder_quantityAndCategory();
        return bestCategory;
    }

    public List<String> orderList() {
        List<String> orderList= orderRepository.findById();
        return orderList;
    }

}