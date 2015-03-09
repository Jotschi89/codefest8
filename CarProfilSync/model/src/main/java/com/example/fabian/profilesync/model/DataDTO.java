package com.example.fabian.profilesync.model;

import java.io.Serializable;

/**
 * Created by schoe_000 on 07.03.2015.
 */
public class DataDTO implements Serializable{

    static final long serialVersionUID = 3;

    private MultimediaDTO mmDto;

    private SeatPositionDTO seatDto;

    private EmergencyNumbersDTO enDto;

    public DataDTO() {
        mmDto = new MultimediaDTO();
        seatDto = new SeatPositionDTO();
        enDto = new EmergencyNumbersDTO();

    }

    public EmergencyNumbersDTO getEnDto() {
        return enDto;
    }

    public void setEnDto(EmergencyNumbersDTO enDto) {
        this.enDto = enDto;
    }

    public MultimediaDTO getMmDto() {
        return mmDto;
    }

    public void setMmDto(MultimediaDTO mmDto) {
        this.mmDto = mmDto;
    }

    public SeatPositionDTO getSeatDto() {
        return seatDto;
    }

    public void setSeatDto(SeatPositionDTO seatDto) {
        this.seatDto = seatDto;
    }

    @Override
    public String toString() {
        return "Data recieved:\n\n" + mmDto + seatDto + enDto;
    }
}
