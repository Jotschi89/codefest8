package com.example.fabian.profilesync;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.fabian.profilesync.model.DataSaver;

public class SteeringWheelFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_frontend_steering, container, false);
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView4);

        final float originX = imageView.getX();
        final float originY = imageView.getY();

        final ImageView imageViewan = (ImageView) rootView.findViewById(R.id.imageView5);
        final float originX2 = imageViewan.getX()+100;
        final float originY2 = imageViewan.getY()+100;


        final SeekBar sk = (SeekBar) rootView.findViewById(R.id.seekBar6);
        sk.setProgress(DataSaver.getDataDto().getSeatDto().getSteeringWheelX());
        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                imageViewan.setX(originY2-progress);


                DataSaver.getDataDto().getSeatDto().setSteeringWheelX(progress);
            }

        });
        final SeekBar sk2 = (SeekBar) rootView.findViewById(R.id.seekBar7);
        sk2.setProgress(DataSaver.getDataDto().getSeatDto().getSteeringWheelZ());
        sk2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                imageViewan.setY(originY2-progress);

                DataSaver.getDataDto().getSeatDto().setSteeringWheelZ(progress);
            }

        });
        return rootView;
    }

}