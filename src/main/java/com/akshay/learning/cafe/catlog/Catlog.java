package com.akshay.learning.cafe.catlog;

import com.akshay.learning.cafe.beverage.Beverage;

import java.util.List;

public interface Catlog {
    String getDisplaybleMenu();
    List<Beverage> getSelectedBeveragesFor(List<Integer> selectedIndices);
}
