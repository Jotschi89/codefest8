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
        try {
            SharedPreferences.Editor editor = preferences.edit();
            byte[] b = Serializer.serialize(data);
            String decoded = new String(b, "ISO-8859-1");
            editor.putString(TAG, decoded);
            editor.commit();
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }

    @Override
    public SeatPositionDTO readSeatPosition() {
        try {
            String s = preferences.getString(TAG, "");
            if(s.isEmpty()) {
                return new SeatPositionDTO();
            }
            byte[] b = s.getBytes("ISO-8859-1");
            return (SeatPositionDTO)Serializer.deSerialize(b);
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, e.getMessage(), e);
        }
        return null;
    }
}
