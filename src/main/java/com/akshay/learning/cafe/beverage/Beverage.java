package com.akshay.learning.cafe.beverage;


import com.akshay.learning.cafe.exceptions.CafeException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public abstract class Beverage {
    private String name;
    private Type type;
    private int price;
    private Category category;
    private List<Topping> toppings = new ArrayList<>();

    protected Beverage(String name, int price, Type type, Category categroy) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.category = categroy;
    }

    abstract protected void addTopping(Topping topping) throws CafeException;
    abstract protected int getTotalPrice();

    @Override
    public String toString() {
        return this.type.toString() + "." + this.category.toString() + "." + this.name;
    }
}


