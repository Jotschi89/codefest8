package com.example.fabian.profilesync.persistent;

import android.content.SharedPreferences;
import android.util.Log;

import com.example.fabian.profilesync.model.MultimediaDTO;
import com.example.fabian.profilesync.util.Serializer;
import com.google.inject.Singleton;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;

/**
 * Created by Jotschi on 12.03.2015.
 */
@Singleton
public class MultimediaSharedPreferencesImpl implements MultimediaPersistent {
    private static String TAG = "Multimedia";

    @Inject
    SharedPreferences preferences;

    @Override
    public void saveMultimedia(MultimediaDTO data) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(TAG+"-Station1", data.getStation1());
        editor.putString(TAG+"-Station2", data.getStation2());
        editor.putString(TAG+"-Station3", data.getStation3());
        editor.putString(TAG+"-Station4", data.getStation4());
        editor.putString(TAG+"-Station5", data.getStation5());
        editor.putString(TAG+"-Station6", data.getStation6());
        editor.putInt(TAG+"-Volume", data.getVolume());
        editor.commit();
    }

    @Override
    public MultimediaDTO readMultimedia() {
        MultimediaDTO multimediaDTO = new MultimediaDTO();
        multimediaDTO.setStation1(preferences.getString(TAG+"-Station1", "empty"));
        multimediaDTO.setStation2(preferences.getString(TAG+"-Station2", "empty"));
        multimediaDTO.setStation3(preferences.getString(TAG+"-Station3", "empty"));
        multimediaDTO.setStation4(preferences.getString(TAG+"-Station4", "empty"));
        multimediaDTO.setStation5(preferences.getString(TAG+"-Station5", "empty"));
        multimediaDTO.setStation6(preferences.getString(TAG+"-Station6", "empty"));
        multimediaDTO.setVolume(preferences.getInt(TAG+"-Volume", 50));
        return multimediaDTO;
    }
}
