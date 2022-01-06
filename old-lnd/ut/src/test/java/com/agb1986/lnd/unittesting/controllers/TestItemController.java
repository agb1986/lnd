package com.agb1986.lnd.unittesting.controllers;

import com.agb1986.lnd.unittesting.models.Item;
import com.agb1986.lnd.unittesting.services.ItemServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.Arrays;

@WebMvcTest(ItemController.class)
class TestItemController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemServiceImpl itemServiceImplMock;

    @Test
    void getItem_basic() throws Exception {
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/item").accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpectAll(status().isOk(),
                content().contentType(MediaType.APPLICATION_JSON),
                content().json("{id:1,name:Ball,price:10.00,quanity:100}"));
    }

    @Test
    void getItem_basicService() throws Exception {
        when(itemServiceImplMock.retriveHardCodedItem())
                .thenReturn(new Item(1, "Ball", 10.00, 100));

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/item-service").accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpectAll(status().isOk(),
                content().contentType(MediaType.APPLICATION_JSON),
                content().json("{id:1,name:Ball,price:10.00,quanity:100}"));
    }

    @Test
    void getItem_basicJpaAll() throws Exception {
        when(itemServiceImplMock.retriveItems())
                .thenReturn(Arrays.asList(new Item(1, "Ball", 10.00, 100),
                        new Item(1, "Ball", 10.00, 100), new Item(1, "Ball", 10.00, 100)));

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/item-jpa").accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpectAll(status().isOk(),
                content().contentType(MediaType.APPLICATION_JSON), content().json(
                        "[{id:1,name:Ball,price:10.00,quanity:100},{id:1,name:Ball,price:10.00,quanity:100},{id:1,name:Ball,price:10.00,quanity:100}]"));
    }


    @Test
    void getItem_basicServiceId() throws Exception {
        when(itemServiceImplMock.retriveItemById(1001)).thenReturn(new Item(1, "Ball", 10.00, 100));

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/item-jpa/1001").accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpectAll(status().isOk(),
                content().contentType(MediaType.APPLICATION_JSON),
                content().json("{id:1,name:Ball,price:10.00,quanity:100}"));
    }
}
