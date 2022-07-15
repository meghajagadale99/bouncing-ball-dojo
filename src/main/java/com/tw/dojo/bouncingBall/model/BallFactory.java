package com.tw.dojo.bouncingBall.model;

public class BallFactory {

    public static Ball[] all() {
        return new Ball[]{
                bouncingBall(75, 50, BouncingBall.DOWN),
                elasticBall(250, 100, Ball.DEFAULT_RADIUS, ElasticBall.SHRINK),
                bouncingElasticBall(360, 160,
                        Ball.DEFAULT_RADIUS, BouncingElasticBall.SHRINK, BouncingElasticBall.UP ),
                // bouncingElasticBall() --> Let's make a new ball!
        };
    }

    private static Ball bouncingElasticBall(int centerX, int centerY, int moveDirection, int growthDirection, int radius) {
        return new BouncingElasticBall(centerX, centerY, moveDirection, growthDirection, radius);
    }

    public static Ball bouncingBall(int centerX, int centerY, int direction) {
        return new BouncingBall(centerX, centerY, direction);
    }

    public static Ball elasticBall(int centerX, int centerY, int radius, int direction) {
        return new ElasticBall(centerX, centerY, radius, direction);
    }
}
