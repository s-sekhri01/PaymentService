package com.scaler.paymentservice.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stripeWebhook")
public class StripeWebHookController {
    @PostMapping
    public void webhook(){
        System.out.println("Received Webhook Call");
    }
}
