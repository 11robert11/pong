package com.company;

import static java.lang.Math.abs;

public class Ball {
    private static short radius = 1;
    private static short speed = 1;
    private static short yBound = 128;
    private static short xBound = 128;
    private static short x;
    private static short y;
    private static float slope;   //Rise over run
    private static short b;
    private static byte direction = 1;

    public static void setRadius(short i)
    {
        radius = i;
    }
    public static int getRadius()
    {
        return radius;
    }
    public static void setDirection(byte d)
    {
        assert d*d == 1;
    }
    private static void notDirection()
    {
        direction = (byte) (direction * -1);
    }
    private static void notSlope()
    {
        slope = slope * -1; //Inverts the slop
    }
    public static void setX(short x1)
    {
        x = x1;
    }
    public static void setY(short y1)
    {
        y = y1;
    }
    public static int getX()
    {
        return x;
    }
    public static int getY()
    {
        return y;
    }
    public static void setSlope(float slopeIn)
    {
        slope = slopeIn;
    }
    public static void ballInc()
    {
        wallCheck();
        x = (short) (x + direction);
        y = (short) abs((slope*x + b));
    }
    private static void wallCheck()
    {
        if(x >= xBound | x <= 0)
        {
            notDirection(); // Changes
            notSlope();

        }
        if(y >= yBound | y <= 0)
        {
            notSlope();
        }
    }
}
