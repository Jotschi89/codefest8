package com.example.fabian.profilesync.persistent;

import android.app.Application;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * Created by Jotschi on 11.03.2015.
 */
public class PersistentModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(DataDtoPersistent.class).to(DataDtoSharedPreferencesImpl.class);
        bind(EmergencyNumbersPersistent.class).to(EmergencyNumbersSharedPreferencesImpl.class);
        bind(MultimediaPersistent.class).to(MultimediaSharedPreferencesImpl.class);
        bind(GpsFavoritesPersistent.class).to(GpsFavoritesSharedPreferencesImpl.class);
        bind(MirrorPositionPersistent.class).to(MirrorPositionSharedPreferencesImpl.class);
        bind(SeatPositionPersistent.class).to(SeatPositionSharedPreferencesImpl.class);
    }
}
