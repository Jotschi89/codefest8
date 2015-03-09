package com.example.fabian.profilesync.model;

import java.io.Serializable;

public class EmergencyNumbersDTO implements Serializable {

    static final long serialVersionUID = 3;

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

    private String station1;
    private String station2;

    @Override
    public String toString() {
        return "EmergencyNumbers:\n" +
                "number1 = '" + station1 + "'\n" +
                "number2 = '" + station2 + "'\n" +
                "number3 = '" + station3 + "'\n" +
                "number4 = '" + station4 + "'\n" +
                "number5 = '" + station5 + "'\n" +
                "number6 = '" + station6 + "'\n";
    }

    private String station3;
    private String station4;
    private String station5;
    private String station6;

}
