package com.giumig.apps.bluetoothcontroller;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.giumig.apps.bluetoothserialmonitor.R;

class at implements OnClickListener {
    final /* synthetic */ ar f2656a;

    at(ar arVar) {
        this.f2656a = arVar;
    }

    public void onClick(View view) {
        String packageName = this.f2656a.ai.getPackageName();
        try {
            this.f2656a.m836a(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
        } catch (ActivityNotFoundException e) {
            this.f2656a.m836a(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
        }
        this.f2656a.m891a();
        Toast.makeText(this.f2656a.ai, R.string.thanks, 0).show();
    }
}
