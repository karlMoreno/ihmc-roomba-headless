/*
 * Purpose:
 * - Headless telemetry sink.
 * - Writes selected YoVariables to a CSV file each tick.
 * - This is the bridge to later visualization / plotting.
 */
package com.practice.roomba.yo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.practice.roomba.yo.RoombaYoVariables;


public class RoombaTelemetryCsvLogger implements AutoCloseable{

    // private final bufferwriter
    private final BufferedWriter bufferedWriter;

    //constructor 
    public RoombaTelemetryCsvLogger(Path outputCvsPath) throws IOException
    {
        Files.createDirectories(outputCvsPath.getParent());
        this.bufferedWriter = Files.newBufferedWriter(outputCvsPath);

        bufferedWriter.write("tickIndex,positionXMeters,positionYMeters,headingRadians,linearVelocityMetersPerSecond, angularVelocityRadiansPerSecond,state");
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }
    
    //write to file every tick
    public void appendOneTick(RoombaYoVariables roombaYoVariables) throws IOException
    {
        String rowLine = String.format(
            "%d,%.6f,%.6f,%.6f,%.6f,%.6f,%s",
            roombaYoVariables.getTickIndex(),
            roombaYoVariables.getPositionXMeters(),
            roombaYoVariables.getPositionYMeters(),
            roombaYoVariables.getHeadingRadians(),
            roombaYoVariables.getLinearVelocityMetersPerSecond(),
            roombaYoVariables.getAngularVelocityRadiansPerSecond(),
            roombaYoVariables.getRoombaStateName()
      );

      bufferedWriter.write(rowLine);
      bufferedWriter.newLine();
    }


    //flush all the data anyway if things get stuck
    public void flush() throws IOException
    {
        bufferedWriter.flush();
    }

  

    //close file
    @Override
    public void close() throws IOException
    {
        bufferedWriter.flush();
        bufferedWriter.close();
    }


    
}
