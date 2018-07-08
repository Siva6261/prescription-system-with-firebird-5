package com.giumig.apps.bluetoothcontroller;

import android.view.View;
import android.view.View.OnClickListener;

class ab implements OnClickListener {
    final /* synthetic */ DeviceSwitchActivity f2639a;

    ab(DeviceSwitchActivity deviceSwitchActivity) {
        this.f2639a = deviceSwitchActivity;
    }

    public void onClick(View view) {
        this.f2639a.finish();
    }
}
