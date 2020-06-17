package com.mishamba.day3.parser;

import com.mishamba.day3.entity.ball.Ball;
import com.mishamba.day3.entity.ball.configuration.BallColor;
import com.mishamba.day3.entity.ball.configuration.BallMaterial;
import com.mishamba.day3.entity.ball.configuration.BallSize;
import com.mishamba.day3.entity.basket.Basket;
import com.mishamba.day3.exception.ProgramException;
import com.mishamba.day3.service.create.CreateService;
import org.jetbrains.annotations.NotNull;

public class Parser {
    public Ball parseStringToBall(String line) {
        CreateService service = new CreateService();
        String[] config = line.split(" ");
        return service.createBall(parseColor(config[0]),
                parseSize(config[1]), parseMaterial(config[2]));
    }

    public Basket parseStringToBasket(String line)
            throws ProgramException {
        String[] config = line.split(" ");
        CreateService service = new CreateService();
        return service.createBasket(Integer.parseInt(config[0]),
                Integer.parseInt(config[1]));
    }

    private BallColor parseColor(@NotNull String color) {
        BallColor result = null;
        switch(color.toLowerCase()) {
            case "blue":
                result = BallColor.BLUE;
                break;
            case "black":
                result = BallColor.BLACK;
                break;
            case "red":
                result = BallColor.RED;
                break;
            case  "white":
                result = BallColor.WHITE;
                break;
            case "green":
                result = BallColor.GREEN;
                break;
            default:
                System.out.println("unexpected color");
        }

        return result;
    }

    private BallSize parseSize(@NotNull String size) {
        BallSize result = null;
        switch (size.toLowerCase()) {
            case "s":
                result = BallSize.S;
                break;
            case "m":
                result = BallSize.M;
                break;
            case "l":
                result = BallSize.L;
                break;
            case "xl":
                result = BallSize.XL;
                break;
            case "xxl":
                result = BallSize.XXL;
                break;
            case "supersize":
                result = BallSize.SUPER_SIZE;
                break;
            default:
                System.out.println("unexpected size");
        }

        return result;
    }

    private BallMaterial parseMaterial(@NotNull String material) {
        BallMaterial result = null;
        switch (material.toLowerCase()) {
            case "wood":
                result = BallMaterial.WOOD;
                break;
            case "iron":
                result = BallMaterial.IRON;
                break;
            case "plastic":
                result = BallMaterial.PLASTIC;
                break;
            default:
                System.out.println("unexpected material");
        }

        return result;
    }
}
