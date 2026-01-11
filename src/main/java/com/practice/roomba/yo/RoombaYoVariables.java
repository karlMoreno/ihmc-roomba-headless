
/*
 * Purpose:
 * - IHMC-style instrumentation container.
 * - Owns a YoRegistry and the YoVariables we care about.
 * - Mirrors values from RoombaTelemetry each tick.
 */

package com.practice.roomba.yo;

import com.practice.roomba.model.RoombaTelemetry;
import com.practice.roomba.fsm.RoombaStateName;
import us.ihmc.yoVariables.registry.YoRegistry;
import us.ihmc.yoVariables.variable.YoDouble;
import us.ihmc.yoVariables.variable.YoInteger;
import us.ihmc.yoVariables.variable.YoEnum;

public class RoombaYoVariables {
    private final YoRegistry roombaYoRegistry = new YoRegistry("Roomba");

    private final YoInteger tickIndexYoVariable = new YoInteger("tickIndex", roombaYoRegistry);

    private final YoDouble positionXMetersYoVariable = new YoDouble("positionXMeters", roombaYoRegistry);
    private final YoDouble positionYMetersYoVariable = new YoDouble("positionYMeters", roombaYoRegistry);
    private final YoDouble headingRadiansYoVariable = new YoDouble("headingRadians", roombaYoRegistry);

    private final YoDouble linearVelocityMetersPerSecondYoVariable = new YoDouble("linearVelocityMetersPerSecond",
            roombaYoRegistry);
    private final YoDouble angularVelocityRadiansPerSecondYoVariable = new YoDouble("angularVelocityRadiansPerSecond",
            roombaYoRegistry);

    private final YoEnum<RoombaStateName> roombaStateNameYoVariable = new YoEnum<>("roombaState", roombaYoRegistry,
            RoombaStateName.class, true);

    public YoRegistry getRoombaYoRegistry() {
        return roombaYoRegistry;
    }

    public void mirrorFromTelemetry(int tickIndex, RoombaTelemetry roombaTelemetry) {
        tickIndexYoVariable.set(tickIndex);

        positionXMetersYoVariable.set(roombaTelemetry.getRoombaPose2D().getPositionXMeters());
        positionYMetersYoVariable.set(roombaTelemetry.getRoombaPose2D().getPositionYMeters());
        headingRadiansYoVariable.set(roombaTelemetry.getRoombaPose2D().getHeadingRadians());

        linearVelocityMetersPerSecondYoVariable.set(roombaTelemetry.getLinearVelocityMetersPerSecond());
        angularVelocityRadiansPerSecondYoVariable.set(roombaTelemetry.getAngularVelocityRadiansPerSecond());

        roombaStateNameYoVariable.set(roombaTelemetry.getCurrentStateName());

    }

    public String toConsoleSnapshotLine()
    {
       return String.format(
             "YO | tick=%d x=%.3f y=%.3f h=%.3f v=%.2f w=%.2f state=%s",
             tickIndexYoVariable.getIntegerValue(),
             positionXMetersYoVariable.getDoubleValue(),
             positionYMetersYoVariable.getDoubleValue(),
             headingRadiansYoVariable.getDoubleValue(),
             linearVelocityMetersPerSecondYoVariable.getDoubleValue(),
             angularVelocityRadiansPerSecondYoVariable.getDoubleValue(),
             roombaStateNameYoVariable.getEnumValue()
       );
    }


    public int getTickIndex()
   {
      return tickIndexYoVariable.getIntegerValue();
   }

   public double getPositionXMeters()
   {
      return positionXMetersYoVariable.getDoubleValue();
   }

   public double getPositionYMeters()
   {
      return positionYMetersYoVariable.getDoubleValue();
   }

   public double getHeadingRadians()
   {
      return headingRadiansYoVariable.getDoubleValue();
   }

   public double getLinearVelocityMetersPerSecond()
   {
      return linearVelocityMetersPerSecondYoVariable.getDoubleValue();
   }

   public double getAngularVelocityRadiansPerSecond()
   {
      return angularVelocityRadiansPerSecondYoVariable.getDoubleValue();
   }

   public RoombaStateName getRoombaStateName()
   {
      return roombaStateNameYoVariable.getEnumValue();
   }

}
