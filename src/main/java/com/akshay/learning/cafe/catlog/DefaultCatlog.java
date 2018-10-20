package com.akshay.learning.cafe.catlog;

import com.akshay.learning.cafe.beverage.Beverage;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DefaultCatlog implements Catlog {
    private Map<Integer, Beverage> indexWiseMenu;

    @Override
    public String getDisplaybleMenu(){
        return indexWiseMenu.entrySet().stream()
                .map(entry -> entry.getKey() + ". " + entry.getValue().toString())
                .collect(Collectors.joining("\n"));
    }

    @Override
    public List<Beverage> getSelectedBeveragesFor(List<Integer> selectedIndices){
        return selectedIndices.stream()
                .map(index -> indexWiseMenu.get(index))
                .collect(Collectors.toList());
    }
}
