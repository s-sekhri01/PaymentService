package com.scaler.paymentservice.Services.PaymentGateway;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class RazorpayPaymentGateway implements PaymentGateway {
    @Override
    public String generateLink() {
        RazorpayClient razorpay =
                null;
        try {
            razorpay = new RazorpayClient("YOUR_KEY", "YOUR__KEY_SECRET");
        } catch (RazorpayException e) {
            throw new RuntimeException(e);
        }
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount", 1000);
        paymentLinkRequest.put("currency", "INR");
        paymentLinkRequest.put("accept_partial", false);
        paymentLinkRequest.put("expire_by", 1709700974);
        paymentLinkRequest.put("reference_id", "TS1989");
        paymentLinkRequest.put("description", "Payment for policy no #23456");

        JSONObject customer = new JSONObject();
        customer.put("contact", "+917337057594");
        customer.put("name", "Ankit Arora");
        customer.put("email", "arora.ankit7@gmail.com");
        paymentLinkRequest.put("customer", customer);

        JSONObject notify = new JSONObject();
        notify.put("sms", true);
        notify.put("email", true);
        paymentLinkRequest.put("notify", notify);

        paymentLinkRequest.put("callback_url", "https://google.com/");
        paymentLinkRequest.put("callback_method", "get");

        PaymentLink payment = null;
        try {
            payment = razorpay.paymentLink.create(paymentLinkRequest);
        } catch (RazorpayException e) {
            throw new RuntimeException(e);
        }

        return payment.toString();
    }
}
