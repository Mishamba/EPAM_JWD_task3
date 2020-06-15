package com.mishamba.day3.service.create;

import com.mishamba.day3.exception.ProgramException;
import com.mishamba.day3.entity.Ball;
import com.mishamba.day3.entity.Basket;
import com.mishamba.day3.entity.ballconfiguration.BallColor;
import com.mishamba.day3.validator.BallBasketValidator;

public class CreateService {
    public Ball createBall(BallColor color, double weight, double radius)
            throws ProgramException {
        BallBasketValidator validator = new BallBasketValidator();
        if (!validator.correctBallData(color, weight, radius)) {
            throw new ProgramException("ball data incorrect");
        }

        return new Ball(color, weight, radius);
    }

    public Basket createBasket(int capacity, int maxWeight)
            throws ProgramException {
        BallBasketValidator validator = new BallBasketValidator();
        if (!validator.correctBasketData(capacity, maxWeight)) {
            throw new ProgramException("basket data incorrect");
        }

        return new Basket(capacity, maxWeight);
    }
}
