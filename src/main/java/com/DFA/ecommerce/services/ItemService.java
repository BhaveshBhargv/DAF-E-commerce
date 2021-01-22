package com.DFA.ecommerce.services;

import com.DFA.ecommerce.models.Items;
import com.DFA.ecommerce.exceptions.ItemNotFoundException;
import com.DFA.ecommerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private  final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Items> getItems() {
        return itemRepository.findAll();
    }

    public void addNewItem(Items item) {
        itemRepository.save(item);
    }

    public void deleteItem(Items item) {
        Items items = itemRepository.findById(item.getId()).orElseThrow(() -> new ItemNotFoundException(item.getId()));
        itemRepository.delete(items);
    }

    public void updateItem(Items newItem) {
         Items item = itemRepository.findById(newItem.getId()).orElseThrow(() -> new ItemNotFoundException(newItem.getId()));
         if(newItem.getPrice() != null) {
             item.setPrice(newItem.getPrice());
         }
         if(newItem.getQuantity() != null) {
             item.setQuantity(newItem.getQuantity());
         }
         itemRepository.saveAndFlush(item);
    }

    public Long totalItems() {
        return itemRepository.count();
    }

    public Long totalCategory() {
        return itemRepository.findByCategory();
    }

    public List<String> itemList() {
        List<String> itemList= itemRepository.findByName();
        return itemList;
    }

    public Items getItemById(Long id) {
        return itemRepository.getOne(id);
    }
}