package com.example.fabian.profilesync.model;

import com.example.fabian.profilesync.util.Serializer;

import java.io.Serializable;

/**
 * Created by Jotschi on 12.03.2015.
 */
public class MirrorPositionDTO implements Serializable {
    static final long serialVersionUID = 4;

    private int mirrorLX;
    private int mirrorLZ;

    private int mirrorMX;
    private int mirrorMZ;

    private int mirrorRX;
    private int mirrorRZ;

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
        return
                "mirrorLX = " + mirrorLX + "\n" +
                "mirrorLZ = " + mirrorLZ + "\n" +
                "mirrorMX = " + mirrorMX + "\n" +
                "mirrorMZ = " + mirrorMZ + "\n" +
                "mirrorRX = " + mirrorRX + "\n" +
                "mirrorRZ = " + mirrorRZ + "\n";
    }
}
