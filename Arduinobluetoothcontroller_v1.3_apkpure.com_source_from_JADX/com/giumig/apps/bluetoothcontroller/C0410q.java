package com.giumig.apps.bluetoothcontroller;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class C0410q implements OnClickListener {
    final /* synthetic */ DeviceControllerActivity f2768a;

    C0410q(DeviceControllerActivity deviceControllerActivity) {
        this.f2768a = deviceControllerActivity;
    }

    public void onClick(View view) {
        if (!this.f2768a.f2537s) {
            this.f2768a.m5028w();
        } else if (!TextUtils.isEmpty(this.f2768a.f2536r.m5273g())) {
            view.performHapticFeedback(1, 2);
            this.f2768a.m5022c(this.f2768a.f2536r.m5273g());
        }
    }
}
