package com.shivam.projects.lovable_clone.service;

import com.shivam.projects.lovable_clone.dto.auth.subscription.CheckoutRequest;
import com.shivam.projects.lovable_clone.dto.auth.subscription.CheckoutResponse;
import com.shivam.projects.lovable_clone.dto.auth.subscription.PortalResponse;
import com.stripe.model.StripeObject;

import java.util.Map;


public interface PaymentProcessor {
    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request);

    PortalResponse openCustomerPortal();

    void handleWebhookEvent(String type, StripeObject stripeObject, Map<String, String> metadata);
}
