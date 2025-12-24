/*
 * Purpose:
 * - IDLE: Roomba does nothing but reports status.
 */
package com.practice.roomba.fsm;

import com.practice.roomba.model.RoombaTelemetry;

public class IdleState implements RoombaState
{
   private final RoombaTelemetry roombaTelemetry;

   public IdleState(RoombaTelemetry roombaTelemetry)
   {
      this.roombaTelemetry = roombaTelemetry;
   }

   @Override
   public RoombaStateName getName()
   {
      return RoombaStateName.IDLE;
   }

   @Override
   public void onEnter()
   {
      roombaTelemetry.setStatusMessage("Entering IDLE");
      roombaTelemetry.setLinearVelocityMetersPerSecond(0.0);
      roombaTelemetry.setAngularVelocityRadiansPerSecond(0.0);
   }

   @Override
   public void onTick(int tickIndex)
   {
      roombaTelemetry.setStatusMessage("IDLE tick " + tickIndex);
   }

   @Override
   public void onExit()
   {
      roombaTelemetry.setStatusMessage("Exiting IDLE");
   }
}
