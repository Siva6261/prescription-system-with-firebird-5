package com.giumig.apps.bluetoothcontroller;

import android.graphics.Typeface;
import android.util.Log;
import android.widget.TextView;

public class bl {
    public static void m5214a(TextView textView, String str) {
        try {
            textView.setTypeface(Typeface.createFromAsset(MyApplication.m5137a().getAssets(), str));
        } catch (Exception e) {
            Log.e("Utils", e.toString());
        }
    }
}
