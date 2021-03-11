package com.company;
import com.company.Ball;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Ball.setY((short) 2);
        Ball.setX((short) 2);
        Ball.setSlope(1);
        while (true)
        {
            Thread.sleep(100);
            Ball.ballInc();
            System.out.println(Ball.getX() + ":" + Ball.getY());

        }
        //System.out.println(ball.point);
    }
}
