/*
 * Purpose:
 * - Owns the top-level simulation loop.
 * - Calls the finite state machine each tick and prints telemetry.
 */
package com.practice.roomba.app;

import com.practice.roomba.fsm.RoombaFiniteStateMachine;
import com.practice.roomba.model.RoombaTelemetry;

public class RoombaApplication
{
   private final RoombaFiniteStateMachine roombaFiniteStateMachine;
   private final RoombaTelemetry roombaTelemetry;

   public RoombaApplication()
   {
      this.roombaTelemetry = new RoombaTelemetry();
      this.roombaFiniteStateMachine = new RoombaFiniteStateMachine(roombaTelemetry);
   }

   public void runFixedNumberOfTicks(int totalTickCount)
   {
      for (int tickIndex = 0; tickIndex < totalTickCount; tickIndex++)
      {
         roombaFiniteStateMachine.tickOnce(tickIndex);
         System.out.println(roombaTelemetry.toConsoleLine());
      }
   }
}
