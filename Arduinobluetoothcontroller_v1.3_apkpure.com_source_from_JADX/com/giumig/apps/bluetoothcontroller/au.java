package com.giumig.apps.bluetoothcontroller;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.giumig.apps.bluetoothserialmonitor.R;

class au implements OnClickListener {
    final /* synthetic */ ar f2657a;

    au(ar arVar) {
        this.f2657a = arVar;
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        String str = "android.intent.extra.TEXT";
        intent.putExtra(str, "" + this.f2657a.m828a((int) R.string.app_name) + " " + Uri.parse("https://play.google.com/store/apps/details?id=" + this.f2657a.ai.getPackageName()).toString());
        intent.setType("text/plain");
        this.f2657a.m836a(Intent.createChooser(intent, this.f2657a.m875l().getText(R.string.share)));
        this.f2657a.m891a();
    }
}
