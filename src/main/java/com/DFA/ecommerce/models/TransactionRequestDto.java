package com.DFA.ecommerce.models;

public class TransactionRequestDto {

    private Long item_id;
    private Long quantity;
    private String address;
    private Long phone_number;

    public TransactionRequestDto() {
    }

    @Override
    public String toString() {
        return "TransactionRequestDto{" +
                "item_id=" + item_id +
                ", quantity=" + quantity +
                ", address='" + address + '\'' +
                ", phone_number=" + phone_number +
                '}';
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Long phone_number) {
        this.phone_number = phone_number;
    }

    public TransactionRequestDto(Long item_id, Long quantity, String address, Long phone_number) {
        this.item_id = item_id;
        this.quantity = quantity;
        this.address = address;
        this.phone_number = phone_number;
    }
}
