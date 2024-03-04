package com.scaler.paymentservice.Services.PaymentGateway;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StripePaymentGateway implements PaymentGateway {
    @Override
    public String generateLink() {

        Stripe.apiKey = "Your API key";

        Map<String, Object> productData = new HashMap<>();
        productData.put("name", "Test Product");

        Map<String, Object> productParam = new HashMap<>();
        productParam.put("unit_amount", 10000);
        productParam.put("currency", "inr");
        productParam.put("product_data", productData);

// Create price
        Price price = null;
        try {
            price = Price.create(productParam);
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }

// Create price line item
        Map<String, Object> priceLineItem = new HashMap<>();
        priceLineItem.put("price", price.getId());
        priceLineItem.put("quantity", 1);

        List<Object> lineItems = new ArrayList<>();
        lineItems.add(priceLineItem);

        Map<String, Object> finalParams = new HashMap<>();
        finalParams.put("line_items", lineItems);

        Map<String, Object> afterCompletion = new HashMap<>();
        afterCompletion.put("type", "redirect");

        Map<String, Object> redirect = new HashMap<>();
        redirect.put("url", "https://google.com?payment_id={CHECKOUT_SESSION_ID}");

        afterCompletion.put("redirect", redirect);

        finalParams.put("after_completion", afterCompletion);

        PaymentLink paymentLink = null;
        try {
            paymentLink = PaymentLink.create(finalParams);
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }

        return paymentLink.getUrl();
    }
}
