package com.shivam.projects.lovable_clone.service.impl;

import com.shivam.projects.lovable_clone.dto.auth.subscription.CheckoutRequest;
import com.shivam.projects.lovable_clone.dto.auth.subscription.CheckoutResponse;
import com.shivam.projects.lovable_clone.dto.auth.subscription.PortalResponse;
import com.shivam.projects.lovable_clone.dto.auth.subscription.SubscriptionResponse;
import com.shivam.projects.lovable_clone.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }

    @Override
    public CheckoutResponse createCheckOutSessionUrl(CheckoutRequest checkoutRequest, Long userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
