/*
 * Purpose:
 * - Step 3B: Deterministic simulation time source.
 * - Owns (timeSeconds, stepSeconds) and increments time by exactly stepSeconds per tick.
 */



package com.practice.roomba.simulation;

public final class SimulationClock {
    private double simulationTimeSeconds;
    private final double simulationStepSeconds;


    public SimulationClock(double simulationStepSeconds)
    {
        this.simulationStepSeconds = simulationStepSeconds;
        this.simulationTimeSeconds = 0.0;
    }


    public void step()
    {
        simulationTimeSeconds += simulationStepSeconds;

    }

    public double getSimulationTimeSeconds()
    {
        return simulationTimeSeconds;
    }

    public double getSimulationStepSeconds()
    {
        return simulationStepSeconds;
    }

    
}
