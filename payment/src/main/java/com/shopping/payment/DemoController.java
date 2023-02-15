package com.shopping.payment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class DemoController {
    @GetMapping("/paymenttest")
    public String paymentTest(){return "This test from payment";}
}
