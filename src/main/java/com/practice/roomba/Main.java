/*
 * Purpose:
 * - Step 1 entry point:
 *   Runs a small headless simulation loop and prints telemetry each tick.
 */
package com.practice.roomba;

import com.practice.roomba.app.RoombaApplication;

public class Main
{
   public static void main(String[] arguments)
   {
      RoombaApplication roombaApplication = new RoombaApplication();
      roombaApplication.runFixedNumberOfTicks(60);
   }
}
