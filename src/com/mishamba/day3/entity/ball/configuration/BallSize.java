package com.mishamba.day3.entity.ball.configuration;

public enum BallSize {
    S(3),
    M(5),
    L(7),
    XL(10),
    XXL(15),
    SUPER_SIZE(30);

    private int radius;

    BallSize(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }
}
