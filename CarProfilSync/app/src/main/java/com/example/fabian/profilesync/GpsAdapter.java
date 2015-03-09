package com.example.fabian.profilesync;

/**
 * Created by Fabian on 08.03.2015.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GpsAdapter extends ArrayAdapter<GpsKoords> {
    private final Context context;
    private final GpsKoords[] values;

    public GpsAdapter(Context context, GpsKoords[] values) {
        super(context, R.layout.my_list_item, values);
        this.context = context;
        this.values = values;
    }

    public GpsAdapter(Context context, ArrayList<GpsKoords> values) {
        super(context, R.layout.my_list_item, values);
        this.context = context;
        this.values = values.toArray(new GpsKoords[values.size()]);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.my_list_item_gps, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.mylabel2);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.isdcon2);
        TextView subTitle = (TextView) rowView.findViewById(R.id.textView11);
        subTitle.setText(values[position].getKoord());
        textView.setText(values[position].getName());
        if (values[position].getActive()) {
            imageView.setImageResource(R.drawable.herz_dunkel);
        } else {
            imageView.setImageResource(R.drawable.herz_hell);
        }
        // Change the icon for Windows and iPhone
       /* String s = values[position];
        if (s.startsWith("Windows7") || s.startsWith("iPhone")
                || s.startsWith("Solaris")) {
            imageView.setImageResource(R.drawable.no);
        } else {
            imageView.setImageResource(R.drawable.ok);
        }*/

        return rowView;
    }

}
