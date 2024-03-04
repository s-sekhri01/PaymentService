package com.scaler.paymentservice.Services;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentGatewayChooserStrategy paymentGatewayChooserStrategy;

    public PaymentService(PaymentGatewayChooserStrategy paymentGatewayChooserStrategy) {
        this.paymentGatewayChooserStrategy = paymentGatewayChooserStrategy;
    }

    public String initiatePayment() {

        // Make a call to Order service before below line is executed.

        return paymentGatewayChooserStrategy
                .getBestPaymentGateway()
                .generateLink();
    }
}
