package com.example.fabian.profilesync.service;

import com.google.inject.AbstractModule;

/**
 * Created by Jotschi on 11.03.2015.
 */
public class ServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(EmergencyNumbersService.class).to(EmergencyNumbersServiceImpl.class);
        bind(GpsFavoritesService.class).to(GpsFavoritesServiceImpl.class);
        bind(MirrorPositionService.class).to(MirrorPositionServiceImpl.class);
        bind(MultimediaService.class).to(MultimediaServiceImpl.class);
        bind(SeatPositionService.class).to(SeatPositionServiceImpl.class);
    }
}
