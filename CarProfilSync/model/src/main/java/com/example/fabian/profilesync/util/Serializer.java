package com.example.fabian.profilesync.util;

import android.util.Log;

import com.example.fabian.profilesync.model.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Arrays;

/**
 * Created by Jotschi on 10.03.2015.
 */
public class Serializer {
    private static final String TAG = "SERIALIZER";

    public static Object deSerialize(byte[] data) {
        Object o = null;
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        ObjectInput in = null;
        try {
            in = new ObjectInputStream(bis);
            o = in.readObject();
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
        return o;
    }

    public static byte[] serialize(Object dataDto) {
        byte[] bytes = new byte[0];
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(dataDto);
            out.flush();
            bytes = bos.toByteArray();
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
        return bytes;
    }
}
