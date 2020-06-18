package com.mishamba.day3.entity.basket;

import com.mishamba.day3.entity.ball.Ball;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private int capacityLeft;
    private int weightLeft;
    private final ArrayList<Ball> balls;

    public Basket(int capacityLeft, int maxWeigh) {
        this.capacityLeft = capacityLeft;
        this.weightLeft = maxWeigh;
        this.balls = new ArrayList<>();
    }

    public void putBall(@NotNull Ball ball, double capacityToSubtract) {
        capacityLeft -= capacityToSubtract;
        weightLeft -= ball.getWeigh();
        balls.add(ball);
    }

    public int getCapacityLeft() {
        return capacityLeft;
    }

    public int getWeighLeft() {
        return weightLeft;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Basket basket = (Basket) o;
        int ballsCompare = 0;
        if (this.balls.size() > basket.balls.size()) {
            return false;
        } else {
            for (int i = 0; i < balls.size(); i++) {
                ballsCompare += balls.get(i).compareTo(basket.balls.get(i));
            }
            return basket.getCapacityLeft() == getCapacityLeft() &&
                    basket.getWeighLeft() == getWeighLeft() &&
                    ballsCompare == 0;
        }
    }

    @Override
    public int hashCode() {
        int prime = 63;
        int result = 0;
        for (Ball ball : balls) {
            result += (prime * ball.hashCode());
        }
        result += (prime * result) + capacityLeft;
        result += (prime * result) + weightLeft;

        return result;
    }
}
