package com.mishamba.day3.service.process;

import com.mishamba.day3.entity.ball.Ball;
import com.mishamba.day3.entity.basket.Basket;
import org.jetbrains.annotations.NotNull;

public class PutService {
    public boolean putBallInBasket(@NotNull Ball ball, @NotNull Basket basket) {
        boolean operationStatement;
        if (calculateCapacityToSubtract(ball.getRadius()) < basket.getCapacityLeft()
                && ball.getWeigh() < basket.getWeighLeft()) {
            basket.putBall(ball, calculateCapacityToSubtract(ball.getRadius()));
            operationStatement = true;
        } else {
            operationStatement = false;
        }

        return operationStatement;
    }

    private double calculateCapacityToSubtract(double radius) {
        double cubeVolume = 8 * Math.pow(radius, 3);
        double ballVolume = 4F/3*Math.PI*Math.pow(radius, 3);

        return (cubeVolume - ballVolume) + ballVolume;
    }
}
