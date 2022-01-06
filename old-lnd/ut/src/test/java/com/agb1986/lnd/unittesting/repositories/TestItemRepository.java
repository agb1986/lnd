package com.agb1986.lnd.unittesting.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import com.agb1986.lnd.unittesting.models.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class TestItemRepository {
    @Autowired
    ItemRepository itemRepository;

    @Test
    void testFindAll() {
        List<Item> items = itemRepository.findAll();
        assertEquals(4, items.size());
    }
}
