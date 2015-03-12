package com.example.fabian.profilesync.persistent;

import android.content.SharedPreferences;
import android.util.Log;

import com.example.fabian.profilesync.model.SeatPositionDTO;
import com.example.fabian.profilesync.util.Serializer;
import com.google.inject.Singleton;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;

/**
 * Created by Jotschi on 12.03.2015.
 */
@Singleton
public class SeatPositionSharedPreferencesImpl implements SeatPositionPersistent {
    private static String TAG = "SeatPosition";

    @Inject
    SharedPreferences preferences;

    @Override
    public void saveSeatPosition(SeatPositionDTO data) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(TAG + "-DistanceAngle", data.getDistanceAngle());
        editor.putInt(TAG + "-DistanceHeadWrest", data.getDistanceHeadWrest());
        editor.putInt(TAG + "-DistanceSeatX", data.getDistanceSeatX());
        editor.putInt(TAG + "-DistanceSeatZ", data.getDistanceSeatZ());
        editor.putInt(TAG + "-SteeringWheelX", data.getSteeringWheelX());
        editor.putInt(TAG + "-SteeringWheelZ", data.getSteeringWheelZ());
        editor.commit();
    }

    @Override
    public SeatPositionDTO readSeatPosition() {
        SeatPositionDTO seatPositionDTO = new SeatPositionDTO();
        seatPositionDTO.setDistanceAngle(preferences.getInt(TAG + "-DistanceAngle", 0));
        seatPositionDTO.setDistanceHeadWrest(preferences.getInt(TAG + "-DistanceHeadWrest", 0));
        seatPositionDTO.setDistanceSeatX(preferences.getInt(TAG + "-DistanceSeatX", 0));
        seatPositionDTO.setDistanceSeatZ(preferences.getInt(TAG + "-DistanceSeatZ", 0));
        seatPositionDTO.setSteeringWheelX(preferences.getInt(TAG + "-SteeringWheelX", 0));
        seatPositionDTO.setSteeringWheelZ(preferences.getInt(TAG + "-SteeringWheelZ", 0));
        return seatPositionDTO;
    }
}
