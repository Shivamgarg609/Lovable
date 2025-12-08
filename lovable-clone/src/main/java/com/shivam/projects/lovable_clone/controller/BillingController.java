package com.shivam.projects.lovable_clone.controller;

import com.shivam.projects.lovable_clone.dto.auth.subscription.*;
import com.shivam.projects.lovable_clone.service.PlanService;
import com.shivam.projects.lovable_clone.service.SubscriptionService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class BillingController {

      SubscriptionService subscriptionService;
      PlanService planService;

    @GetMapping("/api/response")
    public ResponseEntity<List<PlanResponse>> getAllPlans(){

        return ResponseEntity.ok(planService.getAllActivePlans());
    }

    @GetMapping("/api/me/subscription")
    public ResponseEntity<SubscriptionResponse> getMySubscription(){
        Long userId =1L;
        return  ResponseEntity.ok(subscriptionService.getCurrentSubscription(userId));
    }

    @PostMapping("/api/stripe/checkout")
    public ResponseEntity<CheckoutResponse> createCheckoutResponse(@RequestBody CheckoutRequest checkoutRequest){
        Long userId = 1L;
        return ResponseEntity.ok(subscriptionService.createCheckOutSessionUrl(checkoutRequest,userId));
    }

    @PostMapping("/api/stripe/portal")
    public ResponseEntity<PortalResponse> openCustomerPortal(){
        Long userId =1L;
        return ResponseEntity.ok(subscriptionService.openCustomerPortal(userId));
    }
}
