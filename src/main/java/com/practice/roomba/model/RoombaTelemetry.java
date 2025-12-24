/*
 * Purpose:
 * - Holds all runtime values we care about printing/logging.
 * - In later steps, this becomes the bridge to IHMC "YoVariables" style logging.
 */
package com.practice.roomba.model;

import com.practice.roomba.fsm.RoombaStateName;

public class RoombaTelemetry
{
   private final RoombaPose2D roombaPose2D = new RoombaPose2D();

   private RoombaStateName currentStateName = RoombaStateName.IDLE;
   private String statusMessage = "Boot";

   private final double timeStepSeconds = 0.02;

   private double linearVelocityMetersPerSecond = 0.0;
   private double angularVelocityRadiansPerSecond = 0.0;

   public String toConsoleLine()
   {
      return String.format(
            "state=%s | x=%.3f y=%.3f heading=%.3f | v=%.2f w=%.2f | %s",
            currentStateName,
            roombaPose2D.getPositionXMeters(),
            roombaPose2D.getPositionYMeters(),
            roombaPose2D.getHeadingRadians(),
            linearVelocityMetersPerSecond,
            angularVelocityRadiansPerSecond,
            statusMessage
      );
   }

   public RoombaPose2D getRoombaPose2D()
   {
      return roombaPose2D;
   }

   public double getTimeStepSeconds()
   {
      return timeStepSeconds;
   }

   public double getLinearVelocityMetersPerSecond()
   {
      return linearVelocityMetersPerSecond;
   }

   public void setLinearVelocityMetersPerSecond(double linearVelocityMetersPerSecond)
   {
      this.linearVelocityMetersPerSecond = linearVelocityMetersPerSecond;
   }

   public double getAngularVelocityRadiansPerSecond()
   {
      return angularVelocityRadiansPerSecond;
   }

   public void setAngularVelocityRadiansPerSecond(double angularVelocityRadiansPerSecond)
   {
      this.angularVelocityRadiansPerSecond = angularVelocityRadiansPerSecond;
   }

   public void setCurrentStateName(RoombaStateName currentStateName)
   {
      this.currentStateName = currentStateName;
   }

   public void setStatusMessage(String statusMessage)
   {
      this.statusMessage = statusMessage;
   }
}
