package com.mishamba.day3.entity;

import com.mishamba.day3.entity.ballconfiguration.BallColor;
import org.jetbrains.annotations.NotNull;

public class Ball implements Comparable<Ball>{
    private final BallColor color;
    private final double weight;
    private final double radius;

    public Ball(BallColor color, double weight, double radius) {
        this.color = color;
        this.weight = weight;
        this.radius = radius;
    }

    public BallColor getColor() {
        return color;
    }

    public double getRadius() {
        return radius;
    }

    public double getWeigh() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
       if (!(o instanceof Ball)) {
           return false;
       }
        Ball ball = (Ball) o;
        return this.getColor() == ball.getColor() &&
                Double.compare(ball.getWeigh(), getWeigh()) == 0 &&
                Double.compare(ball.getRadius(), getRadius()) == 0;
    }

    @Override
    public int hashCode() {
        int prime = 62;
        int result = 1;
        result = prime*result + color.getNumber();
        result = (int) (prime*result + weight);
        result =  (int) (prime*result + radius);
        return result;
    }

    @Override
    public int compareTo(@NotNull Ball ball) {
        if (this.color.getNumber() < ball.color.getNumber()) {
            return 1;
        } else if (this.color.getNumber() > ball.color.getNumber()) {
            return -1;
        } else if (this.weight > ball.weight) {
            return 1;
        } else if (this.weight < ball.weight) {
            return -1;
        } else if (this.radius > ball.radius) {
            return 1;
        } else if (this.radius < ball.radius) {
            return -1;
        }

        return 0;
    }
}
