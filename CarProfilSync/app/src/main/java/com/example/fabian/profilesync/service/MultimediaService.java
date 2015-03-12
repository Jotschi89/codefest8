package com.example.fabian.profilesync.service;

import com.example.fabian.profilesync.model.MultimediaDTO;

/**
 * Created by Jotschi on 12.03.2015.
 */
public interface MultimediaService {
    public void saveMultimedia(MultimediaDTO data);
    public MultimediaDTO readMultimedia();
}
