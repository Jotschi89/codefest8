package com.example.fabian.profilesync.service;

import com.example.fabian.profilesync.model.SeatPositionDTO;

/**
 * Created by Jotschi on 12.03.2015.
 */
public interface SeatPositionService {
    public void saveSeatPosition(SeatPositionDTO data);
    public SeatPositionDTO readSeatPosition();
}
