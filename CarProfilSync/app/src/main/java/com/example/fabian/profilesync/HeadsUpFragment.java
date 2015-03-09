package com.example.fabian.profilesync;

/**
 * Created by Fabian on 07.03.2015.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class HeadsUpFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_frontend_headsup, container, false);

        return rootView;
    }

}