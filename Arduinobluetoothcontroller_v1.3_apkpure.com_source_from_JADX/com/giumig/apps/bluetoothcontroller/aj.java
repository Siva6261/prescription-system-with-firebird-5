package com.giumig.apps.bluetoothcontroller;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class aj implements OnClickListener {
    final /* synthetic */ MainActivity f2647a;

    aj(MainActivity mainActivity) {
        this.f2647a = mainActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2647a.finish();
    }
}
