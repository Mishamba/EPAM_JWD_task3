package com.mishamba.day3.service.process;

import com.mishamba.day3.entity.ball.Ball;
import com.mishamba.day3.entity.basket.Basket;
import com.mishamba.day3.entity.ball.configuration.BallColor;
import org.jetbrains.annotations.NotNull;

public class ResultService {
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
