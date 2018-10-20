package com.akshay.learning.cafe.beverage;

import com.akshay.learning.cafe.exceptions.CafeException;

import static com.akshay.learning.cafe.beverage.Topping.CHOCLATE_CRUSH;

class HotCoffee extends Beverage implements Taxable {

    public HotCoffee(String name, int price) {
        super(name, price, Type.HOT, Category.COFEE);
    }

    @Override
    public void addTopping(Topping topping) throws CafeException {
        if(topping.equals(CHOCLATE_CRUSH)){
            throw new CafeException("Not Supported topping");
        }
        getToppings().add(topping);
    }

    @Override
    public int getTotalPrice() {
        final int totalPriceForToppings = getToppings().stream().mapToInt(Topping::getPrice).sum();
        return getPrice()+totalPriceForToppings;
    }

    @Override
    public float getTax() {
        return 0.2F;
    }
}
