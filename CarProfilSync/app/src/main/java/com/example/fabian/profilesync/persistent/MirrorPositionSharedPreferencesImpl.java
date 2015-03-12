package com.example.fabian.profilesync.persistent;

import android.content.SharedPreferences;
import android.util.Log;

import com.example.fabian.profilesync.model.MirrorPositionDTO;
import com.example.fabian.profilesync.util.Serializer;
import com.google.inject.Singleton;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;

/**
 * Created by Jotschi on 12.03.2015.
 */
@Singleton
public class MirrorPositionSharedPreferencesImpl implements MirrorPositionPersistent {
    private static String TAG = "MirrorPosition";

    @Inject
    SharedPreferences preferences;

    @Override
    public void saveMirrorPosition(MirrorPositionDTO data) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(TAG + "-MirrorLX", data.getMirrorLX());
        editor.putInt(TAG + "-MirrorLZ", data.getMirrorLZ());
        editor.putInt(TAG+"-MirrorMX", data.getMirrorMX());
        editor.putInt(TAG+"-MirrorMZ", data.getMirrorMZ());
        editor.putInt(TAG+"-MirrorRX", data.getMirrorRX());
        editor.putInt(TAG+"-MirrorRZ", data.getMirrorRZ());
        editor.commit();
    }

    @Override
    public MirrorPositionDTO readMirrorPosition() {
        MirrorPositionDTO mirrorPositionDTO = new MirrorPositionDTO();
        mirrorPositionDTO.setMirrorLX(preferences.getInt(TAG + "-MirrorLX", 0));
        mirrorPositionDTO.setMirrorLX(preferences.getInt(TAG + "-MirrorLZ", 0));
        mirrorPositionDTO.setMirrorLX(preferences.getInt(TAG + "-MirrorMX", 0));
        mirrorPositionDTO.setMirrorLX(preferences.getInt(TAG + "-MirrorMZ", 0));
        mirrorPositionDTO.setMirrorLX(preferences.getInt(TAG + "-MirrorRX", 0));
        mirrorPositionDTO.setMirrorLX(preferences.getInt(TAG + "-MirrorRZ", 0));
        return mirrorPositionDTO;
    }
}
