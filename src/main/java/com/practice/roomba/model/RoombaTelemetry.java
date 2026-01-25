/*
 * Purpose:
 * - Holds all runtime values we care about printing/logging.
 * - In later steps, this becomes the bridge to IHMC "YoVariables" style logging.
 *
 * Your task:
 * - Implement toConsoleLine() so the unit test passes.
 * - Do NOT change field names or method signatures.
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
      // TODO:
      // Return a single formatted string that includes:
      // - state name
      // - x, y, heading (3 decimals)
      // - v and w (2 decimals)
      // - statusMessage
      //
      // Hint: use String.format(...) and match the exact format used in the unit tests.
      throw new UnsupportedOperationException("TODO: implement toConsoleLine");
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

   public RoombaStateName getCurrentStateName()
   {
      return currentStateName;
   }

   public void setStatusMessage(String statusMessage)
   {
      this.statusMessage = statusMessage;
   }
}
