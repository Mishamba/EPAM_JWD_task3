package com.mishamba.day3.entity.ball.configuration;

public enum BallMaterial {
    WOOD(0.3),
    IRON(6),
    PLASTIC(1.5);

    private final double density;

    BallMaterial(double density) {
        this.density = density;
    }

    public double getDensity() {
        return density;
    }
}
