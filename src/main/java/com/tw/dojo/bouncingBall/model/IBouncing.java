package com.tw.dojo.bouncingBall.model;

public interface IBouncing {

    int reverseDirectionIfNecessary();

    boolean movingTooLow();

    boolean movingTooHigh();

    int switchDirection();

    int move();

    boolean movingDown();

    boolean movingUp();

}
