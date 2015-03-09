package com.example.fabian.profilesync.model;

import java.io.Serializable;

/**
 * Created by schoe_000 on 07.03.2015.
 */
public class MultimediaDTO implements Serializable {
    static final long serialVersionUID = 3;
    
    private String station1;
    private String station2;
    private String station3;
    private String station4;
    private String station5;
    private String station6;

    private int volume;

    public String getStation1() {
        return station1;
    }

    public void setStation1(String station1) {
        this.station1 = station1;
    }

    public String getStation2() {
        return station2;
    }

    public void setStation2(String station2) {
        this.station2 = station2;
    }

    public String getStation3() {
        return station3;
    }

    public void setStation3(String station3) {
        this.station3 = station3;
    }

    public String getStation4() {
        return station4;
    }

    public void setStation4(String station4) {
        this.station4 = station4;
    }

    public String getStation5() {
        return station5;
    }

    public void setStation5(String station5) {
        this.station5 = station5;
    }

    public String getStation6() {
        return station6;
    }

    public void setStation6(String station6) {
        this.station6 = station6;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Multimedia:\n" +
                "station1 = '" + station1 + "'\n" +
                "station2 = '" + station2 + "'\n" +
                "station3 = '" + station3 + "'\n" +
                "station4 = '" + station4 + "'\n" +
                "station5 = '" + station5 + "'\n" +
                "station6 = '" + station6 + "'\n" +
                "volume = " + volume + "\n";
    }
}
