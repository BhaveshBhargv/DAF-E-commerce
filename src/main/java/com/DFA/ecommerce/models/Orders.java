package com.DFA.ecommerce.models;

import javax.persistence.*;

@Entity
@Table
public class Orders {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )

    private long id;
    private String item_name;
    private long contact_number;
    private String address;
    private long order_quantity;
    private long total_amount;
    private String status;
    private String category;

    public Orders() {
    }

    public Orders(long id, String item_name, long contact_number, String address, long order_quantity, long total_amount, String status, String category) {
        this.id = id;
        this.item_name = item_name;
        this.contact_number = contact_number;
        this.address = address;
        this.order_quantity = order_quantity;
        this.total_amount = total_amount;
        this.status = status;
        this.category = category;
    }

    public Orders(String item_name, long contact_number, String address, long order_quantity, long total_amount, String status, String category) {
        this.item_name = item_name;
        this.contact_number = contact_number;
        this.address = address;
        this.order_quantity = order_quantity;
        this.total_amount = total_amount;
        this.status = status;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public long getContact_number() {
        return contact_number;
    }

    public void setContact_number(long contact_number) {
        this.contact_number = contact_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getOrder_quantity() {
        return order_quantity;
    }

    public void setOrder_quantity(long order_quantity) {
        this.order_quantity = order_quantity;
    }

    public long getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(long total_amount) {
        this.total_amount = total_amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", item_name='" + item_name + '\'' +
                ", contact_number=" + contact_number +
                ", address='" + address + '\'' +
                ", order_quantity=" + order_quantity +
                ", total_amount=" + total_amount +
                ", status='" + status + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}