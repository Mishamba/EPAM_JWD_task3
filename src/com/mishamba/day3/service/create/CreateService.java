package com.mishamba.day3.service.create;

import com.mishamba.day3.entity.ball.configuration.BallMaterial;
import com.mishamba.day3.entity.ball.configuration.BallSize;
import com.mishamba.day3.exception.ProgramException;
import com.mishamba.day3.entity.ball.Ball;
import com.mishamba.day3.entity.basket.Basket;
import com.mishamba.day3.entity.ball.configuration.BallColor;
import com.mishamba.day3.validator.BasketValidator;
import org.jetbrains.annotations.NotNull;

public class CreateService {
    public Ball createBall(BallColor color, BallSize size, BallMaterial material) {
        int weight = calculateBallWeight(size, material);
        return new Ball(color, weight, size);
    }

    public Basket createBasket(int capacity, int maxWeight)
            throws ProgramException {
        BasketValidator validator = new BasketValidator();
        if (!validator.correctBasketData(capacity, maxWeight)) {
            throw new ProgramException("basket data incorrect");
        }

        return new Basket(capacity, maxWeight);
    }

    private int calculateBallWeight(@NotNull BallSize size,
                                       @NotNull BallMaterial material) {
        return (int) (4F/3*Math.PI*Math.pow(size.getRadius(), 3) *
                material.getDensity());
    }
}
