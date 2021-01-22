package com.DFA.ecommerce.repository;

import com.DFA.ecommerce.models.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Items, Long> {
    @Query(value = "SELECT count(distinct category) FROM Items", nativeQuery = true)
    Long findByCategory();

    @Query(value = "SELECT name FROM Items")
    List<String> findByName();
}