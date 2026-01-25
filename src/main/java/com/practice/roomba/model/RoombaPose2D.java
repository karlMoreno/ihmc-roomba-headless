/*
 * Purpose:
 * - Minimal 2D pose: x, y, headingRadians
 * - Provides small integration helpers for motion updates.
 *
 * Your task:
 * - Implement integrateForward() and integrateRotation() so the unit tests pass.
 */
package com.practice.roomba.model;

public class RoombaPose2D
{
   private double positionXMeters;
   private double positionYMeters;
   private double headingRadians;

   public double getPositionXMeters()
   {
      return positionXMeters;
   }

   public double getPositionYMeters()
   {
      return positionYMeters;
   }

   public double getHeadingRadians()
   {
      return headingRadians;
   }

   public void integrateForward(double linearVelocityMetersPerSecond, double timeStepSeconds)
   {
      // TODO:
      // 1) Compute deltaDistanceMeters = linearVelocityMetersPerSecond * timeStepSeconds
      // 2) Update positionXMeters using cos(headingRadians)
      // 3) Update positionYMeters using sin(headingRadians)
      //
      // Hint: Math.cos(...) and Math.sin(...) are in java.lang.Math (auto-imported).

      System.out.println("Hello world");
      throw new UnsupportedOperationException("TODO: implement integrateForward");
   }

   public void integrateRotation(double angularVelocityRadiansPerSecond, double timeStepSeconds)
   {
      // TODO:
      // Update headingRadians by angularVelocityRadiansPerSecond * timeStepSeconds
      throw new UnsupportedOperationException("TODO: implement integrateRotation");
   }
}
