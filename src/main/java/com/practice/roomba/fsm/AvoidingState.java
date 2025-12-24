/*
 * Purpose:
 * - AVOIDING: rotates in place (simple avoidance maneuver).
 */
package com.practice.roomba.fsm;

import com.practice.roomba.model.RoombaPose2D;
import com.practice.roomba.model.RoombaTelemetry;

public class AvoidingState implements RoombaState
{
   private final RoombaTelemetry roombaTelemetry;

   public AvoidingState(RoombaTelemetry roombaTelemetry)
   {
      this.roombaTelemetry = roombaTelemetry;
   }

   @Override
   public RoombaStateName getName()
   {
      return RoombaStateName.AVOIDING;
   }

   @Override
   public void onEnter()
   {
      roombaTelemetry.setStatusMessage("Entering AVOIDING");
      roombaTelemetry.setLinearVelocityMetersPerSecond(0.0);
      roombaTelemetry.setAngularVelocityRadiansPerSecond(1.0);
   }

   @Override
   public void onTick(int tickIndex)
   {
      roombaTelemetry.setStatusMessage("AVOIDING tick " + tickIndex);

      RoombaPose2D roombaPose2D = roombaTelemetry.getRoombaPose2D();
      roombaPose2D.integrateRotation(roombaTelemetry.getAngularVelocityRadiansPerSecond(), roombaTelemetry.getTimeStepSeconds());
   }

   @Override
   public void onExit()
   {
      roombaTelemetry.setStatusMessage("Exiting AVOIDING");
   }
}
