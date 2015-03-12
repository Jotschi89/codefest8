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
import android.widget.Toast;

import com.example.fabian.profilesync.R;
import com.example.fabian.profilesync.model.EmergencyNumbersDTO;
import com.example.fabian.profilesync.service.EmergencyNumbersService;
import com.google.inject.Inject;

import java.util.ArrayList;

import roboguice.fragment.provided.RoboFragment;


public class EmergencyNumbersFragment extends RoboFragment {
    @Inject
    EmergencyNumbersService emergencyNumbersService;
    
    ArrayList<String> arrayStrings = new ArrayList<String>();
    View rootView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        EmergencyNumbersDTO emergencyNumbersDTO = emergencyNumbersService.readEmergencyNumbers();
        rootView = inflater.inflate(R.layout.fragment_frontend_emergencynumbers, container, false);

        arrayStrings.add(emergencyNumbersDTO.getNumber1());
        arrayStrings.add(emergencyNumbersDTO.getNumber2());
        arrayStrings.add(emergencyNumbersDTO.getNumber3());
        arrayStrings.add(emergencyNumbersDTO.getNumber4());
        arrayStrings.add(emergencyNumbersDTO.getNumber5());
        arrayStrings.add(emergencyNumbersDTO.getNumber6());

        final ListView listview = (ListView) rootView.findViewById(R.id.emergencylistView);

        loadList(listview);

        return rootView;
    }

    private void loadList(ListView list) {
                /*resultAdapter = new ArrayAdapter<String>(this,
                R.layout. simple_list_item_1, arrayStrings)
        /*String[] values = new String[] { "OE3", "FM4", "Welle1",
                "OE1", "Radio Wien", "Radio something"};*/
        final ListView listview = list;
        final EmergencyNumbersDTO emergencyNumbersDTO = emergencyNumbersService.readEmergencyNumbers();

        final ArrayAdapter adapter = new ArrayAdapter<String>(listview.getContext(),
                R.layout.simple_list_item, R.id.label, arrayStrings);

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(view.getContext());
                alertDialog.setTitle("Notfallnummer hinzufügen");
                alertDialog.setMessage("Bitte Notfallnummer eingeben: ");
                String radioNumber;
                final int myPos = position;

                final EditText input = new EditText(view.getContext());
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);

                alertDialog.setPositiveButton("Notfallnummer hinzufügen",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(listview.getContext(),
                                        "Notfallnummer erfolgreich hinzugefügt", Toast.LENGTH_SHORT).show();
                                String radiooo = input.getText().toString();
                                arrayStrings.remove(myPos);
                                arrayStrings.add(myPos, radiooo);
                                loadList(listview);
                                if(myPos==0)
                                {
                                    emergencyNumbersDTO.setNumber1(radiooo);
                                }else if(myPos ==1)
                                {
                                    emergencyNumbersDTO.setNumber2(radiooo);
                                }else if(myPos ==2)
                                {
                                    emergencyNumbersDTO.setNumber3(radiooo);
                                }else if(myPos ==3)
                                {
                                    emergencyNumbersDTO.setNumber4(radiooo);
                                }else if(myPos ==4)
                                {
                                    emergencyNumbersDTO.setNumber5(radiooo);
                                }else
                                {
                                    emergencyNumbersDTO.setNumber6(radiooo);
                                }
                                emergencyNumbersService.saveEmergencyNumbers(emergencyNumbersDTO);
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