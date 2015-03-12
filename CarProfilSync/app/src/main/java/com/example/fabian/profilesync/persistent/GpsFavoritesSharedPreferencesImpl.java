package com.example.fabian.profilesync.persistent;

import android.content.SharedPreferences;
import android.util.Log;

import com.example.fabian.profilesync.model.GpsFavoritesDTO;
import com.example.fabian.profilesync.util.Serializer;
import com.google.inject.Singleton;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;

/**
 * Created by Jotschi on 12.03.2015.
 */
@Singleton
public class GpsFavoritesSharedPreferencesImpl implements GpsFavoritesPersistent {
    private static String TAG = "GpsFavorites";

    @Inject
    SharedPreferences preferences;

    @Override
    public void saveGpsFavorites(GpsFavoritesDTO data) {
        SharedPreferences.Editor editor = preferences.edit();
        //todo
        editor.commit();
    }

    @Override
    public GpsFavoritesDTO readGpsFavorites() {
        GpsFavoritesDTO gpsFavoritesDTO = new GpsFavoritesDTO();
        // todo
        return gpsFavoritesDTO;
    }
}
