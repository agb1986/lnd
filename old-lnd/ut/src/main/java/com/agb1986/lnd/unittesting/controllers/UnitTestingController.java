package com.agb1986.lnd.unittesting.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnitTestingController {
    @GetMapping(path = "/hello-world")
    public String getHelloWorld() {
        return "Hello World!";
    }
}
