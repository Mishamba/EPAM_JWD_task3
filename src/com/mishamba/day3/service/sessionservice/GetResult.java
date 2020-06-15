package com.mishamba.day3.service.sessionservice;

import com.mishamba.day3.entity.Ball;
import com.mishamba.day3.entity.Basket;
import com.mishamba.day3.entity.ballconfiguration.BallColor;
import org.jetbrains.annotations.NotNull;

public class GetResult {
    public int getQuantityBlueBalls(@NotNull Basket basket, BallColor color) {
        int quantity = 0;
        for (Ball ball : basket.getBalls()) {
            quantity += (ball.getColor() == color) ? 1 : 0;
        }

        return quantity;
    }

    public double getBasketWeight(@NotNull Basket basket) {
        double weight = 0;
        for (Ball ball : basket.getBalls()) {
            weight += ball.getWeigh();
        }

        return weight;
    }
}
