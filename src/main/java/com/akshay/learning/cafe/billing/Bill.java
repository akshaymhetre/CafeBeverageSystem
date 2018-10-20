package com.akshay.learning.cafe.billing;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@AllArgsConstructor
public class Bill {
    private int id;
    private String payment_mode; // Can be enum
    private List<Order> orders;

    public String getDisplaybleBill(){
        final String header = "Index  Name\tQuantity\tAmount\tTax";
        final String midString = IntStream.range(0, orders.size())
                .mapToObj(index -> {
                    final Order order = orders.get(index);
                    final Optional<Float> tax = order.getTax();
                    final String taxString = tax.map(taxValue -> "\t" + taxValue).orElse("");
                    return index + ". " + order.getBeverage() + "\t" + order.getQuantity() + "\t" + order.getTotal() + taxString;
                }).collect(Collectors.joining("\n"));

        final Double totalBillAmount = totalBillAmount();
        final Double totalTaxAmount = totalTaxAmount();
        final Double totalNetAmount = totalNetAmount(totalBillAmount, totalTaxAmount);
        final String footer = "--------------------------------------------------------------------\n"
                + "Total: " + orders.size() + "\t" + totalBillAmount + "\t" + totalTaxAmount
                + "\t\t\t"+ totalNetAmount;
        return header + midString + footer;
    }

    private Double totalBillAmount() {
        return orders.stream().mapToDouble(Order::getTotal).sum();
    }

    private Double totalTaxAmount() {
        return orders.stream().mapToDouble(order -> order.getTax().orElse(0F)).sum();
    }

    private Double totalNetAmount(Double totalAmount, Double totalTax) {
        return totalAmount*totalTax;
    }
}
