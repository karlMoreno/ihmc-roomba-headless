/*
 * Purpose:
 * - A small finite state machine that updates RoombaTelemetry.
 * - Demonstrates clean separation: application loop vs. state behavior.
 */
package com.practice.roomba.fsm;

import com.practice.roomba.model.RoombaTelemetry;

public class RoombaFiniteStateMachine
{
   private final RoombaTelemetry roombaTelemetry;

   private RoombaState currentRoombaState;

   //constructor takes in roombaTelemetry data
   public RoombaFiniteStateMachine(RoombaTelemetry roombaTelemetry)
   {
      this.roombaTelemetry = roombaTelemetry;
      transitionTo(new IdleState(roombaTelemetry));
   }

   public void tickOnce(int tickIndex)
   {
      currentRoombaState.onTick(tickIndex);

      // Simple demo transition logic:
      if (currentRoombaState.getName() == RoombaStateName.IDLE && tickIndex == 0)
      {
         transitionTo(new DriveForwardState(roombaTelemetry));
      }
      else if (currentRoombaState.getName() == RoombaStateName.DRIVE_FORWARD && tickIndex == 25)
      {
         transitionTo(new AvoidingState(roombaTelemetry));
      }
      else if (currentRoombaState.getName() == RoombaStateName.AVOIDING && tickIndex == 40)
      {
         transitionTo(new DRIVE_FORWARD_RETURN_STATE(roombaTelemetry));
      }
   }

   private void transitionTo(RoombaState nextRoombaState)
   {
      if (currentRoombaState != null)
         currentRoombaState.onExit();

      currentRoombaState = nextRoombaState;
      roombaTelemetry.setCurrentStateName(currentRoombaState.getName());
      currentRoombaState.onEnter();
   }

   /*
    * Purpose:
    * - A tiny helper “state” class to avoid repeating the DriveForwardState constructor call.
    * - Keeps the transitions readable for now.
    */
   private static final class DRIVE_FORWARD_RETURN_STATE extends DriveForwardState
   {
      private DRIVE_FORWARD_RETURN_STATE(RoombaTelemetry roombaTelemetry)
      {
         super(roombaTelemetry);
      }
   }
}
