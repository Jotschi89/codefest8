package com.example.fabian.profilesync;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NavigationAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public NavigationAdapter(Context context, String[] values) {
        super(context, R.layout.my_list_item, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.my_list_item, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.mylabel);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.isdcon);
        textView.setText(values[position]);
        if(position==0)
        {
            imageView.setImageResource(R.drawable.sitz);
        }else if(position == 1)
        {
            imageView.setImageResource(R.drawable.lenker);
        }
        else if(position == 2)
        {
            imageView.setImageResource(R.drawable.musiknote);
        }else if(position == 3)
        {
            imageView.setImageResource(R.drawable.agps);
        }
        else if(position == 5)
        {
            imageView.setImageResource(R.drawable.sync_grau);
        }
        else
            imageView.setImageResource(R.drawable.tacho);
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

    public boolean replace(String S) {
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals(S)) {
                values[i] = S;
                return true;
            }
        }
        return false;
    }
}