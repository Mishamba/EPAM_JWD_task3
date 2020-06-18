package com.mishamba.day3.service.session;

import com.mishamba.day3.entity.ball.Ball;
import com.mishamba.day3.entity.ball.configuration.BallColor;
import com.mishamba.day3.entity.basket.Basket;
import com.mishamba.day3.exception.ProgramException;
import com.mishamba.day3.getter.Finder;
import com.mishamba.day3.service.process.PutService;
import com.mishamba.day3.service.process.ResultService;

import java.util.List;

public class SessionService {
    public void start() throws ProgramException {
        Finder finder = new Finder();

        List<Ball> balls = finder.findBalls();
        List<Basket> baskets = finder.findBaskets();

        PutService putService = new PutService();
        boolean putState = true;
        for (int i = 1; i<balls.size() && putState; i++) {
            putState = putService.putBallInBasket(balls.get(i), baskets.get(0));
        }

        ResultService resultService = new ResultService();
        System.out.println(resultService.getBasketWeight(baskets.get(0)));
        System.out.println(resultService.getQuantityBlueBalls(baskets.get(0),
                BallColor.BLUE));
    }
}
