package com.example.fabian.profilesync.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fabian.profilesync.R;

import roboguice.fragment.provided.RoboFragment;

/**
 * Created by Fabian on 08.03.2015.
 */
public class AirCoolingFragment extends RoboFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_frontend_headsup, container, false);

        return rootView;
    }

}