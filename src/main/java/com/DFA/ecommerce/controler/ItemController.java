package com.DFA.ecommerce.controler;

import com.DFA.ecommerce.models.Items;
import com.DFA.ecommerce.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "home/item")
public class ItemController {

    public final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    @RequestMapping(path = "/add")
    public void addItem(@RequestBody Items item) {
        itemService.addNewItem(item);
    }

    @PutMapping
    @RequestMapping(path = "/update")
    public void updateItem(@RequestBody Items items) {
        itemService.updateItem(items);
    }

    @PostMapping
    @RequestMapping(path = "/delete")
    public void deleteItem(@RequestBody Items items) {
        itemService.deleteItem(items);
    }

}