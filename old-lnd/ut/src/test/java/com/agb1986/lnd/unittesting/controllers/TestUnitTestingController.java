package com.agb1986.lnd.unittesting.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UnitTestingController.class)
class TestUnitTestingController {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloWorld_basic() throws Exception {
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/hello-world").accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpectAll(status().isOk(),
                content().contentType(MediaType.APPLICATION_JSON), content().string("Hello World!"));
    }
}
