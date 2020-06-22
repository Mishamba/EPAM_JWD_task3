package com.mishamba.day3.validator;

public class BasketValidator {
    private static final int MAX_CAPACITY = 1000000;
    private static final int MAX_WEIGHT = 300000;

    public boolean correctBasketData(double capacity, double maxWeight) {
        return ((capacity > 0) && (capacity <= MAX_CAPACITY) &&
                (maxWeight > 0) && (maxWeight <= MAX_WEIGHT));
    }
}