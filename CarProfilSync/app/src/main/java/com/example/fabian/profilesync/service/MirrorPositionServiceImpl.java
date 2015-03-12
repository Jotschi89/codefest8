package com.example.fabian.profilesync.service;

import com.example.fabian.profilesync.model.MirrorPositionDTO;
import com.example.fabian.profilesync.persistent.MirrorPositionPersistent;
import com.google.inject.Singleton;

import javax.inject.Inject;

/**
 * Created by Jotschi on 12.03.2015.
 */
@Singleton
public class MirrorPositionServiceImpl implements MirrorPositionService {
    @Inject
    MirrorPositionPersistent mirrorPositionPersistent;

    @Override
    public void saveMirrorPosition(MirrorPositionDTO data) {
        mirrorPositionPersistent.saveMirrorPosition(data);
    }

    @Override
    public MirrorPositionDTO readMirrorPosition() {
        return mirrorPositionPersistent.readMirrorPosition();
    }
}
