package com.shivam.projects.lovable_clone.service;

import com.shivam.projects.lovable_clone.dto.auth.subscription.CheckoutRequest;
import com.shivam.projects.lovable_clone.dto.auth.subscription.CheckoutResponse;
import com.shivam.projects.lovable_clone.dto.auth.subscription.PortalResponse;
import com.shivam.projects.lovable_clone.dto.auth.subscription.SubscriptionResponse;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);

    CheckoutResponse createCheckOutSessionUrl(CheckoutRequest checkoutRequest, Long userId);

    PortalResponse openCustomerPortal(Long userId);
}
