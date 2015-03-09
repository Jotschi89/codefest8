package com.example.fabian.profilesync.model;

/**
 * Created by schoe_000 on 07.03.2015.
 */
public class DataSaver {

    private static DataDTO dataDto;

    public static DataDTO getDataDto() {
        if (dataDto == null) {
            dataDto = new DataDTO();
        }
        return dataDto;
    }

    public static void setDataDto(DataDTO dataDto) {
        dataDto = dataDto;
    }
}
