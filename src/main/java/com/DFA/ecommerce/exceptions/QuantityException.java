package com.DFA.ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class QuantityException extends Exception {
    public QuantityException(String quantity) {
        super(quantity);
    }
}
