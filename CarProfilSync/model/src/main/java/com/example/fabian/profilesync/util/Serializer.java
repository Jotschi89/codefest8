package com.example.fabian.profilesync.util;

import android.media.AudioManager;
import android.media.ToneGenerator;
import android.util.Log;

import com.example.fabian.profilesync.model.DataDTO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * Created by Jotschi on 10.03.2015.
 */
public class Serializer {
    private static final String TAG = "SERIALIZER";

    public static DataDTO deSerialize(byte [] data) {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        ObjectInput in = null;
        try {
            in = new ObjectInputStream(bis);
            DataDTO o = (DataDTO)in.readObject();
            return o;
        } catch (ClassNotFoundException | IOException ex) {
            Log.e(TAG, ex.getMessage(), ex);
        }finally {
            try {
                bis.close();
            } catch (IOException ex) {
                Log.e(TAG, ex.getMessage(), ex);
            }
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                Log.e(TAG, ex.getMessage(), ex);
            }
        }
        return null;
    }

    public static byte[] serialize(DataDTO dataDto) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(dataDto);
            byte[] yourBytes = bos.toByteArray();
            return yourBytes;
        } catch (IOException ex) {
            Log.e(TAG, ex.getMessage(), ex);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException ex) {
                Log.e(TAG, ex.getMessage(), ex);
            }
            try {
                bos.close();
            } catch (IOException ex) {
                Log.e(TAG, ex.getMessage(), ex);
            }
        }
        return null;
    }
}
