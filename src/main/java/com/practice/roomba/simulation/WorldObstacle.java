/*
 * Purpose:
 * - Axis-aligned rectangle obstacle (AABB) in world coordinates (meters).
 * - Provides a point containment query used for simple collision tests.
 */



package com.practice.roomba.simulation;

public class WorldObstacle {

    private final double minimumX;
    private final double mininumY;

    private final double maximumX;
    private final double maximumY;


    private WorldObstacle(double minimumX, double minimumY, double maximumX, double maximumY)
    {
  

        //using max and min to make sure constructor never gets
        this.minimumX = Math.min(minimumX, maximumX);
        this.mininumY = Math.min(minimumY, maximumY);

        this.maximumX = Math.max(minimumX, maximumX);
        this.maximumY = Math.max(minimumY,maximumY);

    }

    //for a rectangle that is aligned with the map of the simulated world
    public static WorldObstacle axisAlignedRectangle(double minimumX, double minimumY, double maximumX, double maximumY)
    {
        return new WorldObstacle(minimumX, minimumY, maximumX, maximumY);

    }


    //is a point within a rectangle
    public boolean containsPoint(double xPositionMeters, double yPositionMeters)
    {
        boolean withinXBounds = xPositionMeters >= minimumX && xPositionMeters <= maximumX;
        boolean withinYBounds = yPositionMeters >= mininumY && yPositionMeters <= maximumY;

        return withinXBounds && withinYBounds;

    }

    
}
