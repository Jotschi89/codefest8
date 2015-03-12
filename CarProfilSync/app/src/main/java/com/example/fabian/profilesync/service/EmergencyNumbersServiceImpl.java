package com.example.fabian.profilesync.service;

import com.example.fabian.profilesync.model.EmergencyNumbersDTO;
import com.example.fabian.profilesync.persistent.DataDtoPersistent;
import com.example.fabian.profilesync.persistent.EmergencyNumbersPersistent;
import com.google.inject.Singleton;

import javax.inject.Inject;

/**
 * Created by Jotschi on 12.03.2015.
 */
@Singleton
public class EmergencyNumbersServiceImpl implements EmergencyNumbersService {
    @Inject
    EmergencyNumbersPersistent emergencyNumbersPersistent;

    @Override
    public void saveEmergencyNumbers(EmergencyNumbersDTO data) {
        emergencyNumbersPersistent.saveEmergencyNumbers(data);
    }

    @Override
    public EmergencyNumbersDTO readEmergencyNumbers() {
        return emergencyNumbersPersistent.readEmergencyNumbers();
    }
}
