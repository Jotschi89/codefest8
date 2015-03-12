package com.example.fabian.profilesync.view;

/**
 * Created by Fabian on 07.03.2015.
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.fabian.profilesync.GpsAdapter;
import com.example.fabian.profilesync.GpsKoords;
import com.example.fabian.profilesync.R;
import com.example.fabian.profilesync.model.GpsFavoritesDTO;
import com.example.fabian.profilesync.service.GpsFavoritesService;
import com.google.inject.Inject;

import java.util.ArrayList;

import roboguice.fragment.provided.RoboFragment;


/**
 * A placeholder fragment containing a simple view.
 */
public class GPSFavoriteFragment extends RoboFragment {
    @Inject
    GpsFavoritesService gpsFavoritesService;

    ArrayList<GpsKoords> favoList = new ArrayList<GpsKoords>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final GpsFavoritesDTO gpsFavoritesDTO = gpsFavoritesService.readGpsFavorites();

        final View rootView = inflater.inflate(R.layout.fragment_frontend_gps, container, false);

        favoList.add(new GpsKoords("Zu Hause", true, 0.0f, 0.0f));
        favoList.add(new GpsKoords("TU Wien", true, 48.198655f, 16.368463f));
        favoList.add(new GpsKoords("Flughafen Wien", false, 48.115833f, 16.566575f));
        favoList.add(new GpsKoords("Nächstes Ziel", false, 48.115833f, 16.566575f));
        favoList.add(new GpsKoords("Weiteress Ziel", false, 48.115833f, 16.566575f));
        favoList.add(new GpsKoords("Ziel 4000", false, 48.115833f, 16.566575f));
        favoList.add(new GpsKoords("Ziel", false, 48.115833f, 16.566575f));

        final ListView listview = (ListView) rootView.findViewById(R.id.listViewFavo);

        loadList(listview);

        return rootView;
    }

    private void loadList(ListView list) {
        final ListView listview = list;

        final GpsAdapter adapter = new GpsAdapter(listview.getContext(), favoList);

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GpsKoords changeElem = favoList.get(position);
                changeElem.setActive(changeElem.getActive()?false:true);
                favoList.remove(position);
                favoList.add(position,changeElem);

                loadList(listview);
            }

        });

    }
}
