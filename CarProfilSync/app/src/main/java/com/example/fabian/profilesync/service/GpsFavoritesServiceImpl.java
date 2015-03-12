package com.example.fabian.profilesync.service;

import com.example.fabian.profilesync.model.GpsFavoritesDTO;
import com.example.fabian.profilesync.persistent.GpsFavoritesPersistent;
import com.google.inject.Singleton;

import javax.inject.Inject;

/**
 * Created by Jotschi on 12.03.2015.
 */
@Singleton
public class GpsFavoritesServiceImpl implements GpsFavoritesService {
    @Inject
    GpsFavoritesPersistent gpsFavoritesPersistent;

    @Override
    public void saveGpsFavorites(GpsFavoritesDTO data) {
        gpsFavoritesPersistent.saveGpsFavorites(data);
    }

    @Override
    public GpsFavoritesDTO readGpsFavorites() {
        return gpsFavoritesPersistent.readGpsFavorites();
    }
}
