package com.mishamba.day3.validator;

public class BasketValidator {
    public boolean correctBasketData(double capacity, double maxWeight) {
        return ((capacity > 0) && (capacity <= 200000) &&
                (maxWeight > 0) && (maxWeight <= 1000000));
    }
}