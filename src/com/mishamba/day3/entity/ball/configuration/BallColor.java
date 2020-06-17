package com.mishamba.day3.entity.ball.configuration;

public enum BallColor {
    BLUE(1),
    BLACK(2),
    RED(3),
    WHITE(4),
    GREEN(5);

    private int priority;

    BallColor(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
