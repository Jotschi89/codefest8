package com.example.fabian.profilesync.persistent;

import android.content.SharedPreferences;

import com.example.fabian.profilesync.model.DataDTO;

/**
 * Created by Jotschi on 11.03.2015.
 */
public interface DataDtoPersistent {

    public void saveDto(DataDTO data);
    public DataDTO readDto();
}
