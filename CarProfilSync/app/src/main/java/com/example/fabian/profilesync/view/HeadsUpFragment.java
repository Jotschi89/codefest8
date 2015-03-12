package com.example.fabian.profilesync.view;

/**
 * Created by Fabian on 07.03.2015.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.fabian.profilesync.R;

import roboguice.fragment.provided.RoboFragment;

/**
 * A placeholder fragment containing a simple view.
 */
public class HeadsUpFragment extends RoboFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_frontend_headsup, container, false);

        return rootView;
    }

}