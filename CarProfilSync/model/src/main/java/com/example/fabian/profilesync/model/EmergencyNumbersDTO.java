package com.example.fabian.profilesync.model;

import java.io.Serializable;

public class EmergencyNumbersDTO implements Serializable {
    static final long serialVersionUID = 4;

    private String number1 = "";
    private String number2 = "";
    private String number3 = "";
    private String number4 = "";
    private String number5 = "";
    private String number6 = "";

    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    public String getNumber3() {
        return number3;
    }

    public void setNumber3(String number3) {
        this.number3 = number3;
    }

    public String getNumber4() {
        return number4;
    }

    public void setNumber4(String number4) {
        this.number4 = number4;
    }

    public String getNumber5() {
        return number5;
    }

    public void setNumber5(String number5) {
        this.number5 = number5;
    }

    public String getNumber6() {
        return number6;
    }

    public void setNumber6(String number6) {
        this.number6 = number6;
    }


    @Override
    public String toString() {
        return "EmergencyNumbers:\n" +
                "number1 = '" + number1 + "'\n" +
                "number2 = '" + number2 + "'\n" +
                "number3 = '" + number3 + "'\n" +
                "number4 = '" + number4 + "'\n" +
                "number5 = '" + number5 + "'\n" +
                "number6 = '" + number6 + "'\n";
    }

}
