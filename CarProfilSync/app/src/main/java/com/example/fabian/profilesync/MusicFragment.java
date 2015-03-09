package com.example.fabian.profilesync;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fabian.profilesync.model.DataSaver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MusicFragment extends Fragment {

    ArrayList<String> arrayStrings = new ArrayList<String>();
    View rootView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_frontend_music, container, false);


        if(DataSaver.getDataDto().getMmDto().getStation1()==null) {
            DataSaver.getDataDto().getMmDto().setStation1("OE3");
            DataSaver.getDataDto().getMmDto().setStation2("FM4");
            DataSaver.getDataDto().getMmDto().setStation3("Welle1");
            DataSaver.getDataDto().getMmDto().setStation4("Radio Wien");
            DataSaver.getDataDto().getMmDto().setStation5("OE3");
            DataSaver.getDataDto().getMmDto().setStation6("Radio something");
            arrayStrings.add("OE3");
            arrayStrings.add("FM4");
            arrayStrings.add("Welle1");
            arrayStrings.add("Radio Wien");
            arrayStrings.add("OE3");
            arrayStrings.add("SomeThing");
        }else
        {
            arrayStrings.add(DataSaver.getDataDto().getMmDto().getStation1());
            arrayStrings.add(DataSaver.getDataDto().getMmDto().getStation2());
            arrayStrings.add(DataSaver.getDataDto().getMmDto().getStation3());
            arrayStrings.add(DataSaver.getDataDto().getMmDto().getStation4());
            arrayStrings.add(DataSaver.getDataDto().getMmDto().getStation5());
            arrayStrings.add(DataSaver.getDataDto().getMmDto().getStation6());
        }

        final ListView listview = (ListView) rootView.findViewById(R.id.listView);

        loadList(listview);


        CircularSeekBar seekbar = (CircularSeekBar) rootView.findViewById(R.id.circularSeekBar1);
        final TextView musicText = (TextView) rootView.findViewById(R.id.textView5);
        musicText.setText(DataSaver.getDataDto().getMmDto().getVolume() + "%");
        seekbar.getProgress();
        seekbar.setProgress(DataSaver.getDataDto().getMmDto().getVolume());
        seekbar.setOnSeekBarChangeListener(new CircularSeekBar.OnCircularSeekBarChangeListener() {
            @Override
            public void onProgressChanged(CircularSeekBar circularSeekBar, int progress, boolean fromUser) {
                musicText.setText(progress + "%");
                DataSaver.getDataDto().getMmDto().setVolume(progress);
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
                /*resultAdapter = new ArrayAdapter<String>(this,
                R.layout. simple_list_item_1, arrayStrings)
        /*String[] values = new String[] { "OE3", "FM4", "Welle1",
                "OE1", "Radio Wien", "Radio something"};*/
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
                                String radiooo = input.getText().toString();
                                arrayStrings.remove(myPos);
                                arrayStrings.add(myPos, radiooo);
                                loadList(listview);
                                if(myPos==0)
                                {
                                    DataSaver.getDataDto().getMmDto().setStation1(radiooo);
                                }else if(myPos ==1)
                                {
                                    DataSaver.getDataDto().getMmDto().setStation2(radiooo);
                                }else if(myPos ==2)
                                {
                                    DataSaver.getDataDto().getMmDto().setStation3(radiooo);
                                }else if(myPos ==3)
                                {
                                    DataSaver.getDataDto().getMmDto().setStation4(radiooo);
                                }else if(myPos ==4)
                                {
                                    DataSaver.getDataDto().getMmDto().setStation5(radiooo);
                                }else
                                {
                                    DataSaver.getDataDto().getMmDto().setStation6(radiooo);
                                }



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