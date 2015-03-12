package com.example.fabian.profilesync.persistent;

import com.example.fabian.profilesync.model.GpsFavoritesDTO;

/**
 * Created by Jotschi on 12.03.2015.
 */
public interface GpsFavoritesPersistent {
    public void saveGpsFavorites(GpsFavoritesDTO data);
    public GpsFavoritesDTO readGpsFavorites();
}
