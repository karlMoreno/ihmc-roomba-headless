
/*
 * Purpose:
 * - Owns world obstacles and answers collision queries.
 */




package com.practice.roomba.simulation;


import java.util.ArrayList;
import java.util.List;

import com.practice.roomba.simulation.WorldObstacle;




public final class SimulationWorld {

    private final List<WorldObstacle> worldObstacles = new ArrayList<>();


    public void addObstacle(WorldObstacle worldObstacle)
    {
        worldObstacles.add(worldObstacle);
    }

    public boolean isPointInsideAnyObstacle(double xPositionMeters, double yPositionMeters)
    {
        for (WorldObstacle worldObstacle : worldObstacles)
        {
            if (worldObstacle.containsPoint(xPositionMeters, yPositionMeters))
            {
                return true;
            }
        }
        return false;
    }
    
}
