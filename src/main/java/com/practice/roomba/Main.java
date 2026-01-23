/*
 * Purpose:
 * - Step 1 entry point:
 *   Runs a small headless simulation loop and prints telemetry each tick.
 */
package com.practice.roomba;

import com.practice.roomba.app.RoombaApplication;

import com.practice.roomba.simulation.SimulationWorld;
import com.practice.roomba.simulation.WorldObstacle;

public class Main
{
   public static void main(String[] arguments)
   {
      // RoombaApplication roombaApplication = new RoombaApplication();
      // roombaApplication.runFixedNumberOfTicks(60);

      SimulationWorld simulationWorld = new SimulationWorld();

      // anonymous object java magic da hek
      simulationWorld.addObstacle(WorldObstacle.axisAlignedRectangle(0.0,0.0,1.0,1.0));

      boolean isInsideFirstQuery = simulationWorld.isPointInsideAnyObstacle(0.5, 0.5);
      boolean isInsideSecondQuery = simulationWorld.isPointInsideAnyObstacle(2.0, 2.0);

      System.out.println("Step 3A OK: (0.5,0.5) inside obstacle? " + isInsideFirstQuery);
      System.out.println("Step 3A OK: (2.0,2.0) inside obstacle? " + isInsideSecondQuery);



      
   }
}
