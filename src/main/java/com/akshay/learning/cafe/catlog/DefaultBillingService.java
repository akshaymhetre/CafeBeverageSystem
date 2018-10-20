package com.akshay.learning.cafe.catlog;

import com.akshay.learning.cafe.Cafe;
import com.akshay.learning.cafe.billing.Order;
import com.akshay.learning.cafe.billing.RequestOrder;
import com.akshay.learning.cafe.beverage.Beverage;
import com.akshay.learning.cafe.billing.Bill;
import com.akshay.learning.cafe.billing.BillingService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@AllArgsConstructor
public class DefaultBillingService implements BillingService {
    private Cafe cafe;

    @Override
    public Bill generateBill(RequestOrder requestOrder) {
        final List<Beverage> selectedBeverages = cafe.getCatlog().getSelectedBeveragesFor(requestOrder.getIndices());
        final Map<Beverage, Long> beveragesWithQuantity = selectedBeverages.stream()
                .collect(Collectors.groupingBy(beverage -> beverage, Collectors.counting()));
        final List<Order> orders = transform(beveragesWithQuantity);
        return new Bill(new Random().nextInt(), "CASH", orders);

    }

    private List<Order> transform(Map<Beverage, Long> beveragesWithQuantity) {
        return beveragesWithQuantity.entrySet().stream()
                .map(entry -> new Order(entry.getKey(), entry.getValue().intValue()))
                .collect(Collectors.toList());
    }
}
