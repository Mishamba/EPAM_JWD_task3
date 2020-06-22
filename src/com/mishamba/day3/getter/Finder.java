package com.mishamba.day3.getter;

import com.mishamba.day3.entity.ball.Ball;
import com.mishamba.day3.entity.basket.Basket;
import com.mishamba.day3.exception.ProgramException;
import com.mishamba.day3.parser.Parser;
import com.mishamba.day3.reader.BallBasketReader;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Finder {
    public List<Ball> findBalls() {
        BallBasketReader ballBasketReader = new BallBasketReader();
        Parser parser = new Parser();

        Path ballPath = Paths.get(
                "data/ballData");
        List<String> ballCharacteristics = ballBasketReader.getLines(ballPath,
                "for balls");
        ArrayList<Ball> balls = new ArrayList<>();
        for (String line : ballCharacteristics) {
            balls.add(parser.parseStringToBall(line));
        }

        return balls;
    }

    public List<Basket> findBaskets() throws ProgramException {
        BallBasketReader ballBasketReader = new BallBasketReader();
        Parser parser = new Parser();

        Path basketPath = Paths.get(
                "data/basketData");
        List<String> basketCharacteristics = ballBasketReader.
                getLines(basketPath, "for basket");
        ArrayList<Basket> baskets = new ArrayList<>();
        for (String line : basketCharacteristics) {
            baskets.add(parser.parseStringToBasket(line));
        }

        return baskets;
    }
}
