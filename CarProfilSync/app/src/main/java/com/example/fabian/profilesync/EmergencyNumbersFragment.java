package com.example.fabian.profilesync;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fabian.profilesync.model.DataSaver;

import java.util.ArrayList;

public class EmergencyNumbersFragment extends Fragment {

    ArrayList<String> arrayStrings = new ArrayList<String>();
    View rootView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_frontend_emergencynumbers, container, false);

        if(DataSaver.getDataDto().getEnDto().getStation1()==null) {
            DataSaver.getDataDto().getEnDto().setStation1("0664/1234567");
            DataSaver.getDataDto().getEnDto().setStation2("empty");
            DataSaver.getDataDto().getEnDto().setStation3("empty");
            DataSaver.getDataDto().getEnDto().setStation4("empty");
            DataSaver.getDataDto().getEnDto().setStation5("empty");
            DataSaver.getDataDto().getEnDto().setStation6("empty");
            arrayStrings.add("0664/1234567");
            arrayStrings.add("empty");
            arrayStrings.add("empty");
            arrayStrings.add("empty");
            arrayStrings.add("empty");
            arrayStrings.add("empty");
        }else
        {
            arrayStrings.add(DataSaver.getDataDto().getEnDto().getStation1());
            arrayStrings.add(DataSaver.getDataDto().getEnDto().getStation2());
            arrayStrings.add(DataSaver.getDataDto().getEnDto().getStation3());
            arrayStrings.add(DataSaver.getDataDto().getEnDto().getStation4());
            arrayStrings.add(DataSaver.getDataDto().getEnDto().getStation5());
            arrayStrings.add(DataSaver.getDataDto().getEnDto().getStation6());
        }

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

        DataSaver.getDataDto().getEnDto().setStation1("0664/1234567");
        DataSaver.getDataDto().getEnDto().setStation2("empty");
        DataSaver.getDataDto().getEnDto().setStation3("empty");
        DataSaver.getDataDto().getEnDto().setStation4("empty");
        DataSaver.getDataDto().getEnDto().setStation5("empty");
        DataSaver.getDataDto().getEnDto().setStation6("empty");

        final ArrayAdapter adapter = new ArrayAdapter<String>(listview.getContext(),
                R.layout.simple_list_item, R.id.label, arrayStrings);

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(view.getContext());
                alertDialog.setTitle("Notfallnummer hinzufügen");
                alertDialog.setMessage("Bitte Notfallnummer eingeben: ");
                String radioStation;
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
                                    DataSaver.getDataDto().getEnDto().setStation1(radiooo);
                                }else if(myPos ==1)
                                {
                                    DataSaver.getDataDto().getEnDto().setStation2(radiooo);
                                }else if(myPos ==2)
                                {
                                    DataSaver.getDataDto().getEnDto().setStation3(radiooo);
                                }else if(myPos ==3)
                                {
                                    DataSaver.getDataDto().getEnDto().setStation4(radiooo);
                                }else if(myPos ==4)
                                {
                                    DataSaver.getDataDto().getEnDto().setStation5(radiooo);
                                }else
                                {
                                    DataSaver.getDataDto().getEnDto().setStation6(radiooo);
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