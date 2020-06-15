package com.mishamba.day3.service.sessionservice;

import com.mishamba.day1.exception.ProgramException;
import com.mishamba.day3.entity.Ball;
import com.mishamba.day3.entity.Basket;

public class PutService {
    public void putBallInBasket(Ball ball, Basket basket) throws ProgramException {
        if (calculateCapacityToSubtract(ball.getRadius()) < basket.getCapacityLeft()
                && ball.getWeigh() < basket.getWeighLeft()) {
            basket.putBall(ball, calculateCapacityToSubtract(ball.getRadius()));
        } else {
            throw new ProgramException("basket is full");
        }
    }

    private double calculateCapacityToSubtract(double radius) {
        double cubeVolume = 8 * Math.pow(radius, 3);
        double ballVolume = 4F/3*Math.PI*Math.pow(radius, 3);

        return (cubeVolume - ballVolume) + ballVolume;
    }
}
