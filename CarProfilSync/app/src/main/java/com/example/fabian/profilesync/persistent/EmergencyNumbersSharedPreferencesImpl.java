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
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(TAG+"-Number1", data.getNumber1());
        editor.putString(TAG+"-Number2", data.getNumber2());
        editor.putString(TAG+"-Number3", data.getNumber3());
        editor.putString(TAG+"-Number4", data.getNumber4());
        editor.putString(TAG+"-Number5", data.getNumber5());
        editor.putString(TAG+"-Number6", data.getNumber6());
        editor.commit();
    }

    @Override
    public EmergencyNumbersDTO readEmergencyNumbers() {
        EmergencyNumbersDTO emergencyNumbersDTO = new EmergencyNumbersDTO();
        emergencyNumbersDTO.setNumber1(preferences.getString(TAG+"-Number1", "empty"));
        emergencyNumbersDTO.setNumber2(preferences.getString(TAG+"-Number2", "empty"));
        emergencyNumbersDTO.setNumber3(preferences.getString(TAG+"-Number3", "empty"));
        emergencyNumbersDTO.setNumber4(preferences.getString(TAG+"-Number4", "empty"));
        emergencyNumbersDTO.setNumber5(preferences.getString(TAG+"-Number5", "empty"));
        emergencyNumbersDTO.setNumber6(preferences.getString(TAG+"-Number6", "empty"));
        return emergencyNumbersDTO;
    }
}
