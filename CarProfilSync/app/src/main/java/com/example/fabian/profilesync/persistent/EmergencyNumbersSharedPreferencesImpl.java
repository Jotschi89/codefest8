package com.example.fabian.profilesync.persistent;

import android.content.SharedPreferences;
import android.util.Log;

import com.example.fabian.profilesync.model.DataDTO;
import com.example.fabian.profilesync.model.EmergencyNumbersDTO;
import com.example.fabian.profilesync.util.Serializer;
import com.google.inject.Singleton;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;

/**
 * Created by Jotschi on 12.03.2015.
 */
@Singleton
public class EmergencyNumbersSharedPreferencesImpl implements EmergencyNumbersPersistent {
    private static String TAG = "EmergencyNumbers";

    @Inject
    SharedPreferences preferences;

    @Override
    public void saveEmergencyNumbers(EmergencyNumbersDTO data) {
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
    public EmergencyNumbersDTO readEmergencyNumbers() {
        try {
            String s = preferences.getString(TAG, "");
            if(s.isEmpty()) {
                return new EmergencyNumbersDTO();
            }
            byte[] b = s.getBytes("ISO-8859-1");
            return (EmergencyNumbersDTO)Serializer.deSerialize(b);
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, e.getMessage(), e);
        }
        return null;
    }
}
