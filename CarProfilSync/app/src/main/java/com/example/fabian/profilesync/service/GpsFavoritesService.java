package com.example.fabian.profilesync.service;

import com.example.fabian.profilesync.model.GpsFavoritesDTO;

/**
 * Created by Jotschi on 12.03.2015.
 */
public interface GpsFavoritesService {
    public void saveGpsFavorites(GpsFavoritesDTO data);
    public GpsFavoritesDTO readGpsFavorites();
}
