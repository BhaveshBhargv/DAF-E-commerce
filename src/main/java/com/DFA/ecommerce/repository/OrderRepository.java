package com.DFA.ecommerce.repository;

import com.DFA.ecommerce.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Query(value = "SELECT item_name  FROM orders GROUP BY item_name ORDER BY SUM(order_quantity) DESC LIMIT 1;", nativeQuery = true)
    String findByOrder_quantityAndItem_name();

    @Query(value = "SELECT category FROM orders GROUP BY category ORDER BY SUM(order_quantity) DESC LIMIT 1;", nativeQuery = true)
    String findByOrder_quantityAndCategory();

    @Query(value = "SELECT id FROM Orders")
    List<String> findById();
}