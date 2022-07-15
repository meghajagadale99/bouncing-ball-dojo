package com.tw.dojo.bouncingBall.model;

public class BallFactory {

    public static Ball[] all() {
        return new Ball[]{
                bouncingBall(75, 50, BouncingBall.DOWN),
                elasticBall(250, 100, Ball.DEFAULT_RADIUS, ElasticBall.SHRINK),
                elasticBouncingBall(390, 100, ElasticBouncingBall.DOWN, ElasticBouncingBall.SHRINK, Ball.DEFAULT_RADIUS),
                // bouncingElasticBall() --> Let's make a new ball!
        };
    }

    private static Ball elasticBouncingBall(int centerX, int centerY, int direction,int growthDirection, int radius) {
        return new ElasticBouncingBall(centerX, centerY, direction, radius);
    }

    public static Ball bouncingBall(int centerX, int centerY, int direction) {
        return new BouncingBall(centerX, centerY, direction);
    }

    public static Ball elasticBall(int centerX, int centerY, int radius, int direction) {
        return new ElasticBall(centerX, centerY, radius, direction);
    }
}
