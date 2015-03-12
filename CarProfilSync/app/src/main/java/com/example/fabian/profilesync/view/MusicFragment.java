package com.example.fabian.profilesync.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fabian.profilesync.R;
import com.example.fabian.profilesync.model.DataDTO;
import com.example.fabian.profilesync.model.MultimediaDTO;
import com.example.fabian.profilesync.service.MultimediaService;
import com.google.inject.Inject;

import java.util.ArrayList;

import roboguice.fragment.provided.RoboFragment;


public class MusicFragment extends RoboFragment {
    @Inject
    MultimediaService multimediaService;

    ArrayList<String> arrayStrings = new ArrayList<String>();
    View rootView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final MultimediaDTO multimediaDTO = multimediaService.readMultimedia();
        rootView = inflater.inflate(R.layout.fragment_frontend_music, container, false);

        arrayStrings.add(multimediaDTO.getStation1());
        arrayStrings.add(multimediaDTO.getStation2());
        arrayStrings.add(multimediaDTO.getStation3());
        arrayStrings.add(multimediaDTO.getStation4());
        arrayStrings.add(multimediaDTO.getStation5());
        arrayStrings.add(multimediaDTO.getStation6());

        final ListView listview = (ListView) rootView.findViewById(R.id.listView);

        loadList(listview);


        CircularSeekBar seekbar = (CircularSeekBar) rootView.findViewById(R.id.circularSeekBar1);
        final TextView musicText = (TextView) rootView.findViewById(R.id.textView5);
        musicText.setText(multimediaDTO.getVolume() + "%");
        seekbar.getProgress();
        seekbar.setProgress(multimediaDTO.getVolume());
        seekbar.setOnSeekBarChangeListener(new CircularSeekBar.OnCircularSeekBarChangeListener() {
            @Override
            public void onProgressChanged(CircularSeekBar circularSeekBar, int progress, boolean fromUser) {
               musicText.setText(progress + "%");

               multimediaDTO.setVolume(progress);
               multimediaService.saveMultimedia(multimediaDTO);
            }

            @Override
            public void onStopTrackingTouch(CircularSeekBar seekBar) {

            }

            @Override
            public void onStartTrackingTouch(CircularSeekBar seekBar) {

            }
        });
        return rootView;
    }

    private void loadList(ListView list) {
        final MultimediaDTO multimediaDTO = multimediaService.readMultimedia();
        final ListView listview = list;
        final ArrayAdapter adapter = new ArrayAdapter<String>(listview.getContext(),
                R.layout.simple_list_item, R.id.label, arrayStrings);

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(view.getContext());
                alertDialog.setTitle("RadioSender hinzufügen");
                alertDialog.setMessage("Bitte Namen des Radiosenders eingeben: ");
                String radioStation;
                final int myPos = position;

                final EditText input = new EditText(view.getContext());
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);

                alertDialog.setPositiveButton("Sender zu Favoriten",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(listview.getContext(),
                                        "Radio Sender erfolgreich hinzugefügt", Toast.LENGTH_SHORT).show();
                                String radio = input.getText().toString();
                                arrayStrings.remove(myPos);
                                arrayStrings.add(myPos, radio);
                                loadList(listview);
                                if(myPos==0)
                                {
                                   multimediaDTO.setStation1(radio);
                                }else if(myPos ==1)
                                {
                                   multimediaDTO.setStation2(radio);
                                }else if(myPos ==2)
                                {
                                   multimediaDTO.setStation3(radio);
                                }else if(myPos ==3)
                                {
                                   multimediaDTO.setStation4(radio);
                                }else if(myPos ==4)
                                {
                                   multimediaDTO.setStation5(radio);
                                }else
                                {
                                   multimediaDTO.setStation6(radio);
                                }
                                multimediaService.saveMultimedia(multimediaDTO);
                            }
                        });
                alertDialog.setNegativeButton("Abbrechen",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                alertDialog.show();
            }
        });
    }

}