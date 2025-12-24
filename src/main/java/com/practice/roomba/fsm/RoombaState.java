
/*
 * Purpose:
 * - State interface for the Roomba finite state machine.
 * - Each state can update telemetry and decide transitions.
 */


package com.practice.roomba.fsm;

public interface RoombaState {
    RoombaStateName getName();

    void onEnter();

    void onTick(int tickIndex);

    void onExit();
    
}
