/*
 * Purpose:
 * - Owns the top-level simulation loop.
 * - Calls the finite state machine each tick and prints telemetry.
 */
package com.practice.roomba.app;

import com.practice.roomba.fsm.RoombaFiniteStateMachine;
import com.practice.roomba.model.RoombaTelemetry;
import com.practice.roomba.yo.RoombaTelemetryCsvLogger;
import com.practice.roomba.yo.RoombaYoVariables;

import java.nio.file.Path;

public class RoombaApplication
{
   private final RoombaFiniteStateMachine roombaFiniteStateMachine;
   private final RoombaTelemetry roombaTelemetry;

   private final RoombaYoVariables roombaYoVariables;



   public RoombaApplication()
   {
      this.roombaTelemetry = new RoombaTelemetry();
      this.roombaFiniteStateMachine = new RoombaFiniteStateMachine(roombaTelemetry);
      this.roombaYoVariables = new RoombaYoVariables();
   }

   public void runFixedNumberOfTicks(int totalTickCount)
   {
      Path outputCsvPath = Path.of("build", "roomba-telemtry.csv");
      try (RoombaTelemetryCsvLogger roombaTelemetryCsvLogger = new RoombaTelemetryCsvLogger(outputCsvPath))
      {
         for (int tickIndex = 0; tickIndex < totalTickCount; tickIndex++)
         {
            roombaFiniteStateMachine.tickOnce(tickIndex);

            //Mirror the model state into YoVariables (IHMC Pattern)
            roombaYoVariables.mirrorFromTelemetry(tickIndex,roombaTelemetry);

            //console line
            System.out.println(roombaTelemetry.toConsoleLine());

            // Additional YoVariables snapshot every 10 ticks
            if (tickIndex % 10 == 0)
               System.out.println(roombaYoVariables.toConsoleSnapshotLine());

            //log every tick
            roombaTelemetryCsvLogger.appendOneTick(roombaYoVariables);

            //flush occassionally to gaze into file while it runs
            if (tickIndex % 25 == 0)
               roombaTelemetryCsvLogger.flush();
         }
      }
      catch(Exception exception)
      {
         throw new RuntimeException("Step 2 failed while logging telemetry to CSV.", exception);
      }
      System.out.println("Step 2 OK: wrote telemetry CSV to build/roomba-telemetry.csv");

   }
}
