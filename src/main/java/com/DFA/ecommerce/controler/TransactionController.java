package com.DFA.ecommerce.controler;

import com.DFA.ecommerce.models.TransactionRequestDto;
import com.DFA.ecommerce.services.OrderTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    OrderTransactionService orderTransactionService;


    @PostMapping
    @RequestMapping(path = "/transaction")
    public void transaction(@RequestBody TransactionRequestDto transactionRequestDto) throws Exception {
        orderTransactionService.takeOrder(transactionRequestDto);
    }
}
