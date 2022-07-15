package com.tw.dojo.bouncingBall.model;

import com.tw.dojo.bouncingBall.ui.BallWorld;

public class BouncingBall extends Ball implements IBouncing {
    public static final int MOVEMENT_SPEED = 12;

    static final int DOWN = 1;
    static final int UP = -1;

    private int direction;

    BouncingBall(int x, int y, int direction) {
        super(x, y);
        this.direction = direction;
    }

    @Override
    public void update() {
        direction = reverseDirectionIfNecessary();
        y = move();
    }

    /***********************************************************************************
     *
     * Do not change Bouncing ALGORITHM below.
     *
     ***********************************************************************************/

    public int reverseDirectionIfNecessary() {
        if (movingTooHigh() || movingTooLow()) {
            return switchDirection();
        }

        return this.direction;
    }

    public boolean movingTooLow() {
        return y + radius >= BallWorld.BOX_HEIGHT && movingDown();
    }

    public boolean movingTooHigh() {
        return y - radius <= 0 && movingUp();
    }

    public int switchDirection() {
        return movingDown() ? UP : DOWN;
    }

    public int move() {
        return y + (MOVEMENT_SPEED * direction);
    }

    public boolean movingDown() {
        return direction == DOWN;
    }

    public boolean movingUp() {
        return direction == UP;
    }
}
