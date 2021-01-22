package com.DFA.ecommerce.exceptions;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(Long id) {
        System.out.println("Item " + id + " do not exists");
    }
}
