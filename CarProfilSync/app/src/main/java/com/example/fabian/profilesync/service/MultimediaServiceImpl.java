package com.example.fabian.profilesync.service;

import com.example.fabian.profilesync.model.MultimediaDTO;
import com.example.fabian.profilesync.persistent.MultimediaPersistent;
import com.google.inject.Singleton;

import javax.inject.Inject;

/**
 * Created by Jotschi on 12.03.2015.
 */
@Singleton
public class MultimediaServiceImpl implements MultimediaService {
    @Inject
    MultimediaPersistent multimediaPersistent;

    @Override
    public void saveMultimedia(MultimediaDTO data) {
        multimediaPersistent.saveMultimedia(data);
    }

    @Override
    public MultimediaDTO readMultimedia() {
        return multimediaPersistent.readMultimedia();
    }
}
