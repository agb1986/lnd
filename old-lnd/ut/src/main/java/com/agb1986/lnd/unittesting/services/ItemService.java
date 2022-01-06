package com.agb1986.lnd.unittesting.services;

import java.util.List;
import com.agb1986.lnd.unittesting.models.Item;

public interface ItemService {
    Item retriveHardCodedItem();
    Item retriveItemById(int id);
    List<Item> retriveItems();
}
