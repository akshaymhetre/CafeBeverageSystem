package com.akshay.learning.cafe.billing;

import com.akshay.learning.cafe.beverage.Taxable;
import com.akshay.learning.cafe.beverage.Beverage;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class Order {
    public Beverage beverage;
    public int quantity;

    public float getTotal() {
        return beverage.getPrice() * quantity;
    }

    public Optional<Float> getTax() {
        if(beverage instanceof Taxable){
            Taxable taxableBeverage = (Taxable) beverage;
            return Optional.of(taxableBeverage.getTax());
        }
        return Optional.empty();
    }
}
