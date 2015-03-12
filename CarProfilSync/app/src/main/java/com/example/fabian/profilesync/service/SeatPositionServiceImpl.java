package com.example.fabian.profilesync.service;

import com.example.fabian.profilesync.model.SeatPositionDTO;
import com.example.fabian.profilesync.persistent.SeatPositionPersistent;
import com.google.inject.Singleton;

import javax.inject.Inject;

/**
 * Created by Jotschi on 12.03.2015.
 */
@Singleton
public class SeatPositionServiceImpl implements SeatPositionService {
    @Inject
    SeatPositionPersistent seatPositionPersistent;

    @Override
    public void saveSeatPosition(SeatPositionDTO data) {
        seatPositionPersistent.saveSeatPosition(data);
    }

    @Override
    public SeatPositionDTO readSeatPosition() {
        return seatPositionPersistent.readSeatPosition();
    }
}
