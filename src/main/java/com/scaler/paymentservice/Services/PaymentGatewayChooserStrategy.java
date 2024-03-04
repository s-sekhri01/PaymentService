package com.scaler.paymentservice.Services;

import com.scaler.paymentservice.Services.PaymentGateway.PaymentGateway;
import com.scaler.paymentservice.Services.PaymentGateway.RazorpayPaymentGateway;
import com.scaler.paymentservice.Services.PaymentGateway.StripePaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayChooserStrategy {
    private RazorpayPaymentGateway razorpayPaymentGateway;
    private StripePaymentGateway stripePaymentGateway;

    public PaymentGatewayChooserStrategy(RazorpayPaymentGateway razorpayPaymentGateway,
                                         StripePaymentGateway stripePaymentGateway) {
        this.razorpayPaymentGateway = razorpayPaymentGateway;
        this.stripePaymentGateway = stripePaymentGateway;
    }

    public PaymentGateway getBestPaymentGateway() {
        // Some logic to chooese the best payment gateway
        return stripePaymentGateway;
    }
}
