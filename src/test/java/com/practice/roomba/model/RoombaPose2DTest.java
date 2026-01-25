
/*
 * Purpose:
 * - Unit tests for RoombaPose2D.
 * - Verifies deterministic pose integration behavior for forward motion and rotation.
 * - These tests protect the "pose math" layer so later FSM/Strategy/BT logic can trust pose updates.
 */
package com.practice.roomba.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RoombaPose2DTest
{
   private static final double EPSILON = 1e-9;

   @Test
   void defaultPoseStartsAtOriginWithZeroHeading()
   {
      RoombaPose2D roombaPose2D = new RoombaPose2D();

      assertEquals(0.0, roombaPose2D.getPositionXMeters(), EPSILON);
      assertEquals(0.0, roombaPose2D.getPositionYMeters(), EPSILON);
      assertEquals(0.0, roombaPose2D.getHeadingRadians(), EPSILON);
   }

   @Test
   void integrateForwardMovesAlongHeadingZero()
   {
      RoombaPose2D roombaPose2D = new RoombaPose2D();

      roombaPose2D.integrateForward(2.0, 0.5); // distance = 1.0m, heading = 0

      assertEquals(1.0, roombaPose2D.getPositionXMeters(), EPSILON);
      assertEquals(0.0, roombaPose2D.getPositionYMeters(), EPSILON);
      assertEquals(0.0, roombaPose2D.getHeadingRadians(), EPSILON);
   }

   @Test
   void integrateRotationChangesHeading()
   {
      RoombaPose2D roombaPose2D = new RoombaPose2D();

      roombaPose2D.integrateRotation(1.5, 2.0); // deltaHeading = 3.0

      assertEquals(3.0, roombaPose2D.getHeadingRadians(), EPSILON);
   }
}
