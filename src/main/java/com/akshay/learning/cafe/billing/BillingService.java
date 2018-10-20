package com.akshay.learning.cafe.billing;

public interface BillingService {
    Bill generateBill(RequestOrder requestOrder);
}
