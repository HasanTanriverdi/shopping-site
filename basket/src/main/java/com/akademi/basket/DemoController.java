package com.akademi.basket;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basket")
public class DemoController {

    @GetMapping("/baskettest")
    public String basketTest(){return "This test from Basket";}
}
