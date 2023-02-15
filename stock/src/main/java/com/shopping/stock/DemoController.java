package com.shopping.stock;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class DemoController {
    @GetMapping("/stocktest")
    public String stockTest(){return "This test from stock";}
}
