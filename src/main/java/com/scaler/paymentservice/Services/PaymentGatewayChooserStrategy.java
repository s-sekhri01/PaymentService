package com.scaler.paymentservice.Services;

import com.scaler.paymentservice.Services.PaymentGateway.PaymentGateway;
import com.scaler.paymentservice.Services.PaymentGateway.RazorpayPaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayChooserStrategy {
    private RazorpayPaymentGateway razorpayPaymentGateway;

    public PaymentGatewayChooserStrategy(RazorpayPaymentGateway razorpayPaymentGateway) {
        this.razorpayPaymentGateway = razorpayPaymentGateway;
    }

    public PaymentGateway getBestPaymentGateway() {
        // Some logic to chooese the best payment gateway
        return razorpayPaymentGateway;
    }
}
