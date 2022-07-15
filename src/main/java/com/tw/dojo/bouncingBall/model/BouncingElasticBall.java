package com.tw.dojo.bouncingBall.model;

import com.tw.dojo.bouncingBall.ui.BallWorld;

public class BouncingElasticBall extends Ball implements IElastic, IBouncing {
    IBouncing iBouncing;

    public static final int MOVEMENT_SPEED = 12;

    static final int DOWN = 1;
    static final int UP = -1;

    private int moveDirection;

    public static final int GROWTH_RATE = 2;

    static final int GROW = 1;
    static final int SHRINK = -1;

    private int growthDirection;

    protected BouncingElasticBall(int x, int y, int radius, int growthDirection, int moveDirection) {
        super(x, y, radius);
        this.moveDirection = moveDirection;
        this.growthDirection = growthDirection;
    }


    @Override
    public void update() {
        moveDirection = reverseDirectionIfNecessary();
        y = move();
        growthDirection = reverseGrowthDirectionIfNecessary();
        radius = next();
    }

    public int reverseDirectionIfNecessary() {
        if (movingTooHigh() || movingTooLow()) {
            return switchBouncing();
        }

        return this.moveDirection;
    }

    public boolean movingTooLow() {
        return y + radius >= BallWorld.BOX_HEIGHT && movingDown();
    }

    public boolean movingTooHigh() {
        return y - radius <= 0 && movingUp();
    }

    public int switchBouncing() {
        return movingDown() ? UP : DOWN;
    }

    public int move() {
        return y + (MOVEMENT_SPEED * moveDirection);
    }

    public boolean movingDown() {
        return moveDirection == DOWN;
    }

    public boolean movingUp() {
        return moveDirection == UP;
    }

    public int reverseGrowthDirectionIfNecessary() {
        if (growingTooBig() || shrinkingTooSmall()) {
            return switchElastic();
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

    public int switchElastic() {
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
