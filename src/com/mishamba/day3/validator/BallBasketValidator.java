package com.mishamba.day3.validator;

import com.mishamba.day3.entity.ballconfiguration.BallColor;
import org.jetbrains.annotations.NotNull;

public class BallBasketValidator {
    public boolean correctBallData(@NotNull BallColor color, double weight, double radius) {
        return ((color.getNumber() > 0) && (color.getNumber() <= 5)
                && (weight > 0) && (weight <= 20)
                && (radius > 0) && (radius <= 25));
    }

    public boolean correctBasketData(double capacity, double maxWeight) {
        return ((capacity > 0) && (capacity <= 300) &&
                (maxWeight > 0) && (maxWeight <= 85));
    }
}