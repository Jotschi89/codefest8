package com.example.fabian.profilesync.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.example.fabian.profilesync.R;
import com.example.fabian.profilesync.model.DataDTO;
import com.example.fabian.profilesync.model.SeatPositionDTO;
import com.example.fabian.profilesync.service.SeatPositionService;
import com.google.inject.Inject;

import roboguice.fragment.provided.RoboFragment;


public class SeatPositionFragment extends RoboFragment {
    @Inject
    SeatPositionService seatPositionService;

    int value1;
    int value2;
    int value3;
    int value4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final SeatPositionDTO seatPositionDTO = seatPositionService.readSeatPosition();

        final View rootView = inflater.inflate(R.layout.fragment_frontend_seat_position, container, false);
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.myImage);
        final float originX = imageView.getX();
        final float originY = imageView.getY();

        final ImageView imageViewan = (ImageView) rootView.findViewById(R.id.myImage2);
        final float originX2 = imageViewan.getX()+75;
        final float originY2 = imageViewan.getY();

        final ImageView imageViewn = (ImageView) rootView.findViewById(R.id.myImage3);
        final float originX3 = imageViewn.getX();
        final float originY3 = imageViewn.getY()-100;

        final SeekBar sk = (SeekBar) rootView.findViewById(R.id.seekBar);
        sk.setProgress(seatPositionDTO.getDistanceAngle());
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
                // TODO Auto-generated method stub
                //ImageView imageView = (ImageView) rootView.findViewById(R.id.myImage);

                //RotateAnimation rotate = new RotateAnimation(-10.f, new Float(progress/3), Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);  // substitude deltaDegrees for whatever you want
                //rotate.setFillAfter(true); // prevents View from restoring to original direction.

                imageViewn.setRotation(new Float(-progress/3+10));
                imageView.setX(originX-progress/3);
                imageView.setY(originY+progress);
                imageView.setRotation(new Float(-progress/3+10));

                imageViewan.setX(originX2+progress*3);

                //imageViewan.setY(originY2);
                //imageView.startAnimation(rotate);
                value1 = progress;

                seatPositionDTO.setDistanceAngle(value1);
                seatPositionService.saveSeatPosition(seatPositionDTO);
            }

        });

        final SeekBar sk2 = (SeekBar) rootView.findViewById(R.id.seekBar2);
        sk2.setProgress(seatPositionDTO.getDistanceHeadWrest());
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
                value2 = progress;
                imageView.setRotation(new Float(-progress/3+10));

                seatPositionDTO.setDistanceHeadWrest(value2);
                seatPositionService.saveSeatPosition(seatPositionDTO);
            }

        });

        final SeekBar sk3 = (SeekBar) rootView.findViewById(R.id.seekBar3);
        sk3.setProgress(seatPositionDTO.getDistanceSeatZ());
        sk3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

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
                value3 = progress;
                imageView.setY(originY+progress*3);
                imageViewan.setY(originY2+progress*3);
                imageViewn.setY(originY3+progress*3);

                seatPositionDTO.setDistanceSeatZ(value3);
                seatPositionService.saveSeatPosition(seatPositionDTO);
            }

        });
        final SeekBar sk4 = (SeekBar) rootView.findViewById(R.id.seekBar4);
        sk4.setProgress(seatPositionDTO.getDistanceSeatX());
        sk4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

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
                value4 = progress;
                imageView.setX(originX+progress*3);
                imageViewan.setX(originX2+progress*3);
                imageViewn.setX(originX3+progress*3);

                seatPositionDTO.setDistanceSeatX(value4);
                seatPositionService.saveSeatPosition(seatPositionDTO);
            }

        });

        return rootView;
    }



}