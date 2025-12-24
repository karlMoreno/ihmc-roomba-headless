/*
 * Purpose:
 * - Minimal 2D pose: x, y, headingRadians
 * - Provides small integration helpers for motion updates.
 */



package com.practice.roomba.model;

public class RoombaPose2D {
    private double positionXMeters;
    private double positionYMeters;
    private double headingRadians;


    public double getPositionXMeters() {
        return positionXMeters;
    }
    
    public double getPositionYMeters() {
        return positionYMeters;
    }

    public double getHeadingRadians() {
        return headingRadians;
    }


    public void integrateForward(double linearVelocityMetersPerSecond,double timeStepSeconds){

        double deltaDistanceMeters = linearVelocityMetersPerSecond * timeStepSeconds;

        positionXMeters += deltaDistanceMeters * Math.cos(headingRadians);
        positionYMeters += deltaDistanceMeters * Math.sin(headingRadians);


    }

    public void integrateRotation(double angularVelocityRadiansPerSecond, double timeStepSeconds){

        headingRadians += angularVelocityRadiansPerSecond * timeStepSeconds;

    }
}
