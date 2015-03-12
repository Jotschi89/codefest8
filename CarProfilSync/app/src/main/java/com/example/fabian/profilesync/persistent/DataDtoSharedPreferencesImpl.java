package com.example.fabian.profilesync.persistent;

import android.content.SharedPreferences;
import android.util.Log;

import com.example.fabian.profilesync.model.DataDTO;
import com.example.fabian.profilesync.model.EmergencyNumbersDTO;
import com.example.fabian.profilesync.util.Serializer;
import com.google.inject.Singleton;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;


/**
 * Created by Jotschi on 11.03.2015.
 */
@Singleton
public class DataDtoSharedPreferencesImpl implements DataDtoPersistent {
    @Inject
    EmergencyNumbersPersistent emergencyNumbersPersistent;
    @Inject
    GpsFavoritesPersistent gpsFavoritesPersistent;
    @Inject
    MirrorPositionPersistent mirrorPositionPersistent;
    @Inject
    MultimediaPersistent multimediaPersistent;
    @Inject
    SeatPositionPersistent seatPositionPersistent;

    @Override
    public void saveDto(DataDTO data) {
       emergencyNumbersPersistent.saveEmergencyNumbers(data.getEmergencyNumbersDTO());
        gpsFavoritesPersistent.saveGpsFavorites(data.getGpsFavoritesDTO());
        mirrorPositionPersistent.saveMirrorPosition(data.getMirrorPositionDTO());
        multimediaPersistent.saveMultimedia(data.getMultimediaDTO());
        seatPositionPersistent.saveSeatPosition(data.getSeatPositionDTO());
    }

    @Override
    public DataDTO readDto() {
        DataDTO dataDTO = new DataDTO();
        dataDTO.setEmergencyNumbersDTO(emergencyNumbersPersistent.readEmergencyNumbers());
        dataDTO.setGpsFavoritesDTO(gpsFavoritesPersistent.readGpsFavorites());
        dataDTO.setMirrorPositionDTO(mirrorPositionPersistent.readMirrorPosition());
        dataDTO.setMultimediaDTO(multimediaPersistent.readMultimedia());
        dataDTO.setSeatPositionDTO(seatPositionPersistent.readSeatPosition());

        return dataDTO;
    }
}
