package com.example.fabian.profilesync.model;

import java.io.Serializable;

/**
 * Created by schoe_000 on 07.03.2015.
 */
public class DataDTO implements Serializable{
    static final long serialVersionUID = 4;

    private MultimediaDTO multimediaDTO;
    private SeatPositionDTO seatPositionDTO;
    private EmergencyNumbersDTO emergencyNumbersDTO;
    private MirrorPositionDTO mirrorPositionDTO;
    private GpsFavoritesDTO gpsFavoritesDTO;

    public DataDTO() {
        multimediaDTO = new MultimediaDTO();
        seatPositionDTO = new SeatPositionDTO();
        emergencyNumbersDTO = new EmergencyNumbersDTO();
        mirrorPositionDTO = new MirrorPositionDTO();
        gpsFavoritesDTO = new GpsFavoritesDTO();
    }

    public EmergencyNumbersDTO getEmergencyNumbersDTO() {
        return emergencyNumbersDTO;
    }

    public void setEmergencyNumbersDTO(EmergencyNumbersDTO enDto) {
        this.emergencyNumbersDTO = enDto;
    }

    public GpsFavoritesDTO getGpsFavoritesDTO() {
        return gpsFavoritesDTO;
    }

    public void setGpsFavoritesDTO(GpsFavoritesDTO gpsFavoritesDTO) {
        this.gpsFavoritesDTO = gpsFavoritesDTO;
    }

    public MultimediaDTO getMultimediaDTO() {
        return multimediaDTO;
    }

    public void setMultimediaDTO(MultimediaDTO mmDto) {
        this.multimediaDTO = mmDto;
    }

    public SeatPositionDTO getSeatPositionDTO() {
        return seatPositionDTO;
    }

    public void setSeatPositionDTO(SeatPositionDTO seatDto) {
        this.seatPositionDTO = seatDto;
    }

    public MirrorPositionDTO getMirrorPositionDTO() {
        return mirrorPositionDTO;
    }

    public void setMirrorPositionDTO(MirrorPositionDTO mirrorPositionDTO) {
        this.mirrorPositionDTO = mirrorPositionDTO;
    }

    @Override
    public String toString() {
        return "Data recieved:\n\n" +
                multimediaDTO +
                seatPositionDTO +
                emergencyNumbersDTO +
                mirrorPositionDTO +
                gpsFavoritesDTO;
    }
}
