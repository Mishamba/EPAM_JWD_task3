package com.mishamba.day3.entity.ballconfiguration;

public enum BallColor {
    BLUE(1),
    BLACK(2),
    RED(3),
    WHITE(4),
    GREEN(5);

    private int colorNumber;

    BallColor(int colorNumber) {
        this.colorNumber = colorNumber;
    }

    public int getNumber() {
        return this.colorNumber;
    }
}
