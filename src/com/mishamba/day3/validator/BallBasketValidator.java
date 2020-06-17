package com.mishamba.day3.validator;

public class BallBasketValidator {
    public boolean correctBallData(double weight, double radius) {
        return ((weight > 0) && (weight <= 20) &&
                (radius > 0) && (radius <= 25));
    }

    public boolean correctBasketData(double capacity, double maxWeight) {
        return ((capacity > 0) && (capacity <= 300) &&
                (maxWeight > 0) && (maxWeight <= 85));
    }
}