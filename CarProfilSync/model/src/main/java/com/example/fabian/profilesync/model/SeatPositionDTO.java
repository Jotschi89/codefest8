package com.example.fabian.profilesync.model;

import java.io.Serializable;

/**
 * Created by schoe_000 on 07.03.2015.
 */
public class SeatPositionDTO implements Serializable {
    static final long serialVersionUID = 3;

    private int distanceSeatX;
    private int distanceSeatZ;
    private int distanceAngle;
    private int distanceHeadWrest;

    private int steeringWheelX;
    private int steeringWheelZ;

    private int mirrorLX;
    private int mirrorLZ;

    private int mirrorMX;
    private int mirrorMZ;

    private int mirrorRX;
    private int mirrorRZ;

    public int getDistanceSeatX() {
        return distanceSeatX;
    }

    public int getDistanceHeadWrest() {
        return distanceHeadWrest;
    }

    public void setDistanceHeadWrest(int distanceHeadWrest) {
        this.distanceHeadWrest = distanceHeadWrest;
    }

    public void setDistanceSeatX(int distanceSeatX) {
        this.distanceSeatX = distanceSeatX;
    }

    public int getDistanceSeatZ() {
        return distanceSeatZ;
    }

    public void setDistanceSeatZ(int distanceSeatZ) {
        this.distanceSeatZ = distanceSeatZ;
    }

    public int getDistanceAngle() {
        return distanceAngle;
    }

    public void setDistanceAngle(int distanceAngle) {
        this.distanceAngle = distanceAngle;
    }

    public int getSteeringWheelX() {
        return steeringWheelX;
    }

    public void setSteeringWheelX(int steeringWheelX) {
        this.steeringWheelX = steeringWheelX;
    }

    public int getSteeringWheelZ() {
        return steeringWheelZ;
    }

    public void setSteeringWheelZ(int steeringWheelZ) {
        this.steeringWheelZ = steeringWheelZ;
    }

    public int getMirrorLX() {
        return mirrorLX;
    }

    public void setMirrorLX(int mirrorLX) {
        this.mirrorLX = mirrorLX;
    }

    public int getMirrorLZ() {
        return mirrorLZ;
    }

    public void setMirrorLZ(int mirrorLZ) {
        this.mirrorLZ = mirrorLZ;
    }

    public int getMirrorMX() {
        return mirrorMX;
    }

    public void setMirrorMX(int mirrorMX) {
        this.mirrorMX = mirrorMX;
    }

    public int getMirrorMZ() {
        return mirrorMZ;
    }

    public void setMirrorMZ(int mirrorMZ) {
        this.mirrorMZ = mirrorMZ;
    }

    public int getMirrorRX() {
        return mirrorRX;
    }

    public void setMirrorRX(int mirrorRX) {
        this.mirrorRX = mirrorRX;
    }

    public int getMirrorRZ() {
        return mirrorRZ;
    }

    public void setMirrorRZ(int mirrorRZ) {
        this.mirrorRZ = mirrorRZ;
    }

    @Override
    public String toString() {
        return "SeatPosition:\n" +
                "distanceSeatX = " + distanceSeatX + "\n" +
                "distanceSeatZ = " + distanceSeatZ + "\n" +
                "distanceAngle = " + distanceAngle + "\n" +
                "distanceHeadWrest = " + distanceHeadWrest + "\n" +
                "steeringWheelX = " + steeringWheelX + "\n" +
                "steeringWheelZ = " + steeringWheelZ + "\n" +
                "mirrorLX = " + mirrorLX + "\n" +
                "mirrorLZ = " + mirrorLZ + "\n" +
                "mirrorMX = " + mirrorMX + "\n" +
                "mirrorMZ = " + mirrorMZ + "\n" +
                "mirrorRX = " + mirrorRX + "\n" +
                "mirrorRZ = " + mirrorRZ + "\n";
    }
}
