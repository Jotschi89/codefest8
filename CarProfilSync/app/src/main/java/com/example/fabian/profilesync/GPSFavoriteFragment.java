package com.example.fabian.profilesync;

/**
 * Created by Fabian on 07.03.2015.
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

import com.example.fabian.profilesync.model.DataSaver;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class GPSFavoriteFragment extends Fragment {

    ArrayList<GpsKoords> favoList = new ArrayList<GpsKoords>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

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
                /*resultAdapter = new ArrayAdapter<String>(this,
                R.layout. simple_list_item_1, arrayStrings)
        /*String[] values = new String[] { "OE3", "FM4", "Welle1",
                "OE1", "Radio Wien", "Radio something"};*/
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
