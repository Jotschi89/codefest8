package com.example.fabian.profilesync.persistent;

import com.example.fabian.profilesync.model.EmergencyNumbersDTO;

/**
 * Created by Jotschi on 12.03.2015.
 */
public interface EmergencyNumbersPersistent {

    public void saveEmergencyNumbers(EmergencyNumbersDTO data);
    public EmergencyNumbersDTO readEmergencyNumbers();
}
