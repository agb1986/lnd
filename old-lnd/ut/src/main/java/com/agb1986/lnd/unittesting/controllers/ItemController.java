package com.agb1986.lnd.unittesting.controllers;

import java.util.List;
import com.agb1986.lnd.unittesting.models.Item;
import com.agb1986.lnd.unittesting.services.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    @Autowired
    private ItemServiceImpl itemServiceImpl;

    @GetMapping(path = "/item")
    public Item getItem() {
        return new Item(1, "Ball", 10.00, 100);
    }

    @GetMapping(path = "/item-service")
    public Item getItemService() {
        return itemServiceImpl.retriveHardCodedItem();
    }

    @GetMapping(path = "/item-jpa")
    public List<Item> getItemServiceJpa() {
        return itemServiceImpl.retriveItems();
    }

    @GetMapping(path = "/item-jpa/{id}")
    public Item getItemServiceJpa(@PathVariable Integer id) {
        return itemServiceImpl.retriveItemById(id);
    }
}
