package com.mishamba.day3.entity.ball;

import com.mishamba.day3.entity.ball.configuration.BallColor;
import com.mishamba.day3.entity.ball.configuration.BallSize;
import org.jetbrains.annotations.NotNull;

public class Ball implements Comparable<Ball>{
    private final BallColor color;
    private final double weight;
    private final BallSize size;

    public Ball(BallColor color, double weight, BallSize size) {
        this.color = color;
        this.weight = weight;
        this.size = size;
    }

    public BallColor getColor() {
        return color;
    }

    public double getRadius() {
        return size.getRadius();
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
        result = prime*result + color.getPriority();
        result = (int) (prime*result + weight);
        result =  (int) (prime*result + size.getRadius());
        return result;
    }

    @Override
    public int compareTo(@NotNull Ball ball) {
        if (this.color.getPriority() < ball.color.getPriority()) {
            return 1;
        } else if (this.color.getPriority() > ball.color.getPriority()) {
            return -1;
        } else if (this.weight > ball.weight) {
            return 1;
        } else if (this.weight < ball.weight) {
            return -1;
        } else if (this.size.getRadius() > ball.size.getRadius()) {
            return 1;
        } else if (this.size.getRadius() < ball.size.getRadius()) {
            return -1;
        }

        return 0;
    }
}
