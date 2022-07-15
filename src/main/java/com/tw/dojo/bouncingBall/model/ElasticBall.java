package com.tw.dojo.bouncingBall.model;

public class ElasticBall extends Ball implements IElastic {
    public static final int GROWTH_RATE = 2;

    static final int GROW = 1;
    static final int SHRINK = -1;

    private int growthDirection;

    ElasticBall(int x, int y, int radius, int growthDirection) {
        super(x, y, radius);
        this.growthDirection = growthDirection;
    }

    @Override
    public void update() {
        growthDirection = reverseGrowthDirectionIfNecessary();
        radius = next();
    }

    /***********************************************************************************
     *
     * Do not change Elastic ALGORITHM below.
     *
     ***********************************************************************************/

    public int reverseGrowthDirectionIfNecessary() {
        if (growingTooBig() || shrinkingTooSmall()) {
            return switchDirection();
        }

        return this.growthDirection;
    }

    public boolean shrinkingTooSmall() {
        return radius <= 0 && shrinking();
    }

    public boolean growingTooBig() {
        return radius >= DEFAULT_RADIUS && growing();
    }

    public int switchDirection() {
        return growing() ? SHRINK : GROW;
    }

    public int next() {
        return radius + (GROWTH_RATE * growthDirection);
    }

    public boolean shrinking() {
        return growthDirection == SHRINK;
    }

    public boolean growing() {
        return growthDirection == GROW;
    }
}
