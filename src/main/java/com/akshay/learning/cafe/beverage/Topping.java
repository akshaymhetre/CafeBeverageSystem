package com.akshay.learning.cafe.beverage;

public enum Topping {
    CAREMAL(10), VANILLA(20), CREAM(15), CHOCLATE_CRUSH(30);
    private int price;
    Topping(int price){
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
