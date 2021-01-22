package com.DFA.ecommerce.services;

import com.DFA.ecommerce.models.Items;
import com.DFA.ecommerce.models.Orders;
import com.DFA.ecommerce.models.TransactionRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderTransactionService {

    @Autowired
    ItemService itemService;
    @Autowired
    OrderService orderService;

    public void takeOrder(TransactionRequestDto transactionRequestDto) throws Exception {
        Long item_id = transactionRequestDto.getItem_id();
        Items items = itemService.getItemById(item_id);
        if (items.getQuantity() < transactionRequestDto.getQuantity()){
            throw new Exception("Order quantity exceeds available quantity");
        }
        else {
            Orders orders = new Orders();
            orders.setStatus("Order Received");
            orders.setAddress(transactionRequestDto.getAddress());
            orders.setCategory(items.getCategory());
            orders.setOrder_quantity(transactionRequestDto.getQuantity());
            orders.setContact_number(transactionRequestDto.getPhone_number());
            orders.setItem_name(items.getName());
            orders.setTotal_amount(transactionRequestDto.getQuantity() * items.getPrice());
            orderService.addOrder(orders);
            items.setQuantity(items.getQuantity() - transactionRequestDto.getQuantity());
            itemService.updateItem(items);
        }
    }
}
