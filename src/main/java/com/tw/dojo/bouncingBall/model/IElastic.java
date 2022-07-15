package com.tw.dojo.bouncingBall.model;

public interface IElastic {

    int reverseGrowthDirectionIfNecessary();

    boolean shrinkingTooSmall();

     boolean growingTooBig();

     int switchDirection();

     int next();

     boolean shrinking();

     boolean growing();
}
