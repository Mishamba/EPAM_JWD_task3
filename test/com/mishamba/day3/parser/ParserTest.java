package com.mishamba.day3.parser;

import com.mishamba.day3.entity.ball.Ball;
import com.mishamba.day3.entity.ball.configuration.BallColor;
import com.mishamba.day3.entity.ball.configuration.BallSize;
import com.mishamba.day3.entity.basket.Basket;
import com.mishamba.day3.exception.ProgramException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParserTest {

    @Contract(" -> new")
    @DataProvider(name = "ballsData")
    private Object[] @NotNull [] ballsData() {
        return new Object[][] {
                {new Ball(BallColor.BLUE, 2155, BallSize.L),
                        "Blue L Plastic"},
                {new Ball(BallColor.GREEN, 3141, BallSize.M),
                        "Green M Iron"},
                {new Ball(BallColor.BLUE, 33, BallSize.S),
                        "Blue S Wood"}
        };
    }

    @Test(dataProvider = "ballsData")
    public void testParseStringToBall(Ball expected, String source) {
        Parser parser = new Parser();
        Ball actual = parser.parseStringToBall(source);
        assertEquals(actual, expected);
    }

    @Contract(" -> new")
    @DataProvider(name = "basketsData")
    private Object[] @NotNull [] basketsData() {
        return new Object[][] {
                {new Basket(14, 15), "14 15"},
                {new Basket(64, 13), "64 13"}
        };
    }

    @Test(dataProvider = "basketsData")
    public void testParseStringToBasket(Basket expected, String source) {
        Parser parser = new Parser();
        try {
            Basket actual = parser.parseStringToBasket(source);
            assertEquals(actual, expected);
        } catch (ProgramException ex) {
            fail("got exception");
        }
    }
}