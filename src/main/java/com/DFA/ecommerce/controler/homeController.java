package com.DFA.ecommerce.controler;


import com.DFA.ecommerce.services.ItemService;
import com.DFA.ecommerce.services.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("home")
public class homeController {

    final ItemService itemService;
    final OrderService orderService;

    @Autowired
    public homeController(ItemService itemService, OrderService orderService) {
        this.itemService = itemService;
        this.orderService = orderService;
    }

    @RequestMapping("/home")
    public String home(ModelMap model) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String itemsJson = mapper.writeValueAsString(itemService.getItems());
        String totalCategory = mapper.writeValueAsString(itemService.totalCategory());
        String totalItems = mapper.writeValueAsString(itemService.totalItems());
        String orderJson = mapper.writeValueAsString(orderService.getOrders());
        String itemList = mapper.writeValueAsString(itemService.itemList());
        String orderList = mapper.writeValueAsString(orderService.orderList());
        model.put("items", itemsJson);
        model.put("totalCategory", totalCategory);
        model.put("totalItems", totalItems);
        model.put("orders", orderJson);
        model.put("bestItem", orderService.bestItem());
        model.put("bestCategory", orderService.bestCategory());
        model.put("itemList", itemList);
        model.put("orderList", orderList);
        return "home";
    }
}
