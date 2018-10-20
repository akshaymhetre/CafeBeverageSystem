package com.akshay.learning.cafe.billing;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Optional;

@Getter
@AllArgsConstructor
public class RequestOrder {
    List<Integer> indices;
    //Optional<Beverage.Topping> topping;  <<<-----We can add this, that why new Request object created
}
