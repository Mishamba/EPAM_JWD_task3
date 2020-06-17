package com.mishamba.day3.service.session;

import com.mishamba.day3.entity.ball.Ball;
import com.mishamba.day3.entity.ball.configuration.BallColor;
import com.mishamba.day3.entity.basket.Basket;
import com.mishamba.day3.exception.ProgramException;
import com.mishamba.day3.parser.Parser;
import com.mishamba.day3.reader.BallBasketReader;
import com.mishamba.day3.service.process.PutService;
import com.mishamba.day3.service.process.ResultService;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SessionService {
    public void start() throws IOException, ProgramException {
        BallBasketReader ballBasketReader = new BallBasketReader();
        Parser parser = new Parser();

        Path ballPath = Paths.get("data/ballData.txt");
        String[] ballCharacteristics = ballBasketReader.getBallLines(ballPath);
        ArrayList<Ball> balls = new ArrayList<>();
        for (String line : ballCharacteristics) {
            balls.add(parser.parseStringToBall(line));
        }

        Path basketPath = Paths.get("data/basketData.txt");
        String[] basketCharacteristics = ballBasketReader.getBasketLines(basketPath);
        ArrayList<Basket> baskets = new ArrayList<>();
        for (String line : basketCharacteristics) {
            baskets.add(parser.parseStringToBasket(line));
        }

        PutService putService = new PutService();
        for (Ball ball : balls) {
            putService.putBallInBasket(ball, baskets.get(0));
        }

        ResultService resultService = new ResultService();
        System.out.println(resultService.getBasketWeight(baskets.get(0)));
        System.out.println(resultService.getQuantityBlueBalls(baskets.get(0),
                BallColor.BLUE));
    }
}