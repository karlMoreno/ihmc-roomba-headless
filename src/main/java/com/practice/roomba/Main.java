/*
 * Purpose:
 * - Step 1 entry point:
 *   Runs a small headless simulation loop and prints telemetry each tick.
 */
package com.practice.roomba;

import com.practice.roomba.app.RoombaApplication;

import com.practice.roomba.simulation.SimulationWorld;
import com.practice.roomba.simulation.WorldObstacle;

import com.practice.roomba.simulation.SimulationClock;

public class Main
{
   public static void main(String[] arguments)
   {
      // RoombaApplication roombaApplication = new RoombaApplication();
      // roombaApplication.runFixedNumberOfTicks(60);

      // instantiate simulation clock
         SimulationClock simulationClock = new SimulationClock(0.02);

         System.out.println("time seconds upon start " + simulationClock.getSimulationTimeSeconds());
         System.out.println("step seconds upon start " +simulationClock.getSimulationStepSeconds());
         
      // for loop stepping through clock
      for(int i = 0; i <= 5; i++)
         {
            System.out.println("Step 3B tick: t=" + simulationClock.getSimulationTimeSeconds());
            simulationClock.step();
         }

      //print results
      System.out.println("time seconds upon end " + simulationClock.getSimulationTimeSeconds());
      System.out.println("step seconds upon end " +simulationClock.getSimulationStepSeconds());



      

      
   }
}
