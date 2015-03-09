package com.example.fabian.profilesync;

public class GpsKoords {
    private String name;
    private boolean active;
    private Float X;
    private Float Y;

    public GpsKoords(String name, boolean active, Float X, Float Y) {
        this.name = name;
        this.active = active;
        this.X = X;
        this.Y = Y;
    }

    public String getName()
    {
        return this.name;
    }

    public boolean getActive()
    {
        return this.active;
    }

    public String getKoord()
    {
        return "Wien - " + X + "°" + Y + "°";
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
