/*
 * Purpose:
 * - DRIVE_FORWARD: updates pose by moving forward at constant speed.
 */
package com.practice.roomba.fsm;

import com.practice.roomba.model.RoombaPose2D;
import com.practice.roomba.model.RoombaTelemetry;

public class DriveForwardState implements RoombaState
{
   private final RoombaTelemetry roombaTelemetry;

   public DriveForwardState(RoombaTelemetry roombaTelemetry)
   {
      this.roombaTelemetry = roombaTelemetry;
   }

   @Override
   public RoombaStateName getName()
   {
      return RoombaStateName.DRIVE_FORWARD;
   }

   @Override
   public void onEnter()
   {
      roombaTelemetry.setStatusMessage("Entering DRIVE_FORWARD");
      roombaTelemetry.setLinearVelocityMetersPerSecond(0.25);
      roombaTelemetry.setAngularVelocityRadiansPerSecond(0.0);
   }

   @Override
   public void onTick(int tickIndex)
   {
      roombaTelemetry.setStatusMessage("DRIVE_FORWARD tick " + tickIndex);

      RoombaPose2D roombaPose2D = roombaTelemetry.getRoombaPose2D();
      roombaPose2D.integrateForward(roombaTelemetry.getLinearVelocityMetersPerSecond(), roombaTelemetry.getTimeStepSeconds());
   }

   @Override
   public void onExit()
   {
      roombaTelemetry.setStatusMessage("Exiting DRIVE_FORWARD");
   }
}
