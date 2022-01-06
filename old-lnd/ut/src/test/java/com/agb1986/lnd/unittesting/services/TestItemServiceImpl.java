package com.agb1986.lnd.unittesting.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import com.agb1986.lnd.unittesting.models.Item;
import com.agb1986.lnd.unittesting.repositories.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestItemServiceImpl {

    @InjectMocks
    ItemServiceImpl itemService;

    @Mock
    ItemRepository itemRepository;

    @Test
    void retriveItemById_test() {
        Item mockItem = new Item(1001, "Ball", 10.00, 100);
        when(itemRepository.findById(anyInt())).thenReturn(Optional.of(mockItem));
        Item returnedItem = itemService.retriveItemById(1001);

        assertEquals(mockItem.getId(), returnedItem.getId());
        assertEquals(mockItem.getName(), returnedItem.getName());
        assertEquals(mockItem.getPrice(), returnedItem.getPrice());
        assertEquals(mockItem.getQuanity(), returnedItem.getQuanity());
    }

    @Test
    void retriveItems_test() {
        List<Item> mockItemList = Arrays.asList(new Item(1, "Ball", 10.00, 100),
                new Item(1, "Ball", 10.00, 100), new Item(1, "Ball", 10.00, 100));
        when(itemRepository.findAll()).thenReturn(mockItemList);
        List<Item> returnedItemList = itemService.retriveItems();

        assertEquals(mockItemList.size(), returnedItemList.size());

        for (int i = 0; i < returnedItemList.size(); i++) {
            assertEquals(mockItemList.get(i), returnedItemList.get(i));
        }
    }
}
