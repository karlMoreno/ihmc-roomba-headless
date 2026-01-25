/*
 * Purpose:
 * - Unit tests for RoombaTelemetry.
 * - Verifies default values, setter/getter round-trips, and console line formatting.
 * - These tests keep debugging/telemetry stable while core logic evolves.
 */
package com.practice.roomba.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.practice.roomba.fsm.RoombaStateName;
import org.junit.jupiter.api.Test;

class RoombaTelemetryTest
{
   @Test
   void defaultConstructionCreatesPoseAndHasDefaults()
   {
      RoombaTelemetry roombaTelemetry = new RoombaTelemetry();

      assertNotNull(roombaTelemetry.getRoombaPose2D());
      assertEquals(0.02, roombaTelemetry.getTimeStepSeconds(), 0.0);
      assertEquals(0.0, roombaTelemetry.getLinearVelocityMetersPerSecond(), 0.0);
      assertEquals(0.0, roombaTelemetry.getAngularVelocityRadiansPerSecond(), 0.0);

      // This must match your class default: currentStateName = RoombaStateName.IDLE
      assertEquals(RoombaStateName.IDLE, roombaTelemetry.getCurrentStateName());
   }

   @Test
   void settersAndGettersRoundTrip()
   {
      RoombaTelemetry roombaTelemetry = new RoombaTelemetry();

      roombaTelemetry.setLinearVelocityMetersPerSecond(1.23);
      roombaTelemetry.setAngularVelocityRadiansPerSecond(0.45);
      roombaTelemetry.setCurrentStateName(RoombaStateName.AVOIDING);
      roombaTelemetry.setStatusMessage("Testing");

      assertEquals(1.23, roombaTelemetry.getLinearVelocityMetersPerSecond(), 0.0);
      assertEquals(0.45, roombaTelemetry.getAngularVelocityRadiansPerSecond(), 0.0);
      assertEquals(RoombaStateName.AVOIDING, roombaTelemetry.getCurrentStateName());
   }

   @Test
   void toConsoleLineIncludesKeyValuesAndFormatting()
   {
      RoombaTelemetry roombaTelemetry = new RoombaTelemetry();

      roombaTelemetry.setLinearVelocityMetersPerSecond(0.5);
      roombaTelemetry.setAngularVelocityRadiansPerSecond(1.0);
      roombaTelemetry.setCurrentStateName(RoombaStateName.DRIVE_FORWARD);
      roombaTelemetry.setStatusMessage("Ready");

      String consoleLine = roombaTelemetry.toConsoleLine();

      // State printed via %s and enum toString/name
      assertTrue(consoleLine.contains("state=DRIVE_FORWARD"));

      // Pose section exists and uses 3 decimals
      assertTrue(consoleLine.contains("x=0.000"));
      assertTrue(consoleLine.contains("y=0.000"));
      assertTrue(consoleLine.contains("heading=0.000"));

      // Velocity section uses 2 decimals
      assertTrue(consoleLine.contains("v=0.50"));
      assertTrue(consoleLine.contains("w=1.00"));

      // Status message included at end
      assertTrue(consoleLine.contains("Ready"));
   }
}
