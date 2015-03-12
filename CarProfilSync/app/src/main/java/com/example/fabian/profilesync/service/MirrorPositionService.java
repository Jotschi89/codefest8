package com.example.fabian.profilesync.service;

import com.example.fabian.profilesync.model.MirrorPositionDTO;

/**
 * Created by Jotschi on 12.03.2015.
 */
public interface MirrorPositionService {
    public void saveMirrorPosition(MirrorPositionDTO data);
    public MirrorPositionDTO readMirrorPosition();
}
