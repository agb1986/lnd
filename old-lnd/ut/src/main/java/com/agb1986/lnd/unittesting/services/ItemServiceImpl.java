package com.agb1986.lnd.unittesting.services;

import java.util.List;
import com.agb1986.lnd.unittesting.models.Item;
import com.agb1986.lnd.unittesting.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item retriveHardCodedItem() {
        return new Item(1, "Ball", 10.00, 100);
    }

    @Override
    public Item retriveItemById(int id) {
        return itemRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Item> retriveItems() {
        return itemRepository.findAll();
    }
}
