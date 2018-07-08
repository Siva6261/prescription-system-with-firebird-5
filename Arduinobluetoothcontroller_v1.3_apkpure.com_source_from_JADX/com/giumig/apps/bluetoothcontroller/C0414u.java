package com.giumig.apps.bluetoothcontroller;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class C0414u implements OnClickListener {
    final /* synthetic */ DeviceControllerActivity f2772a;

    C0414u(DeviceControllerActivity deviceControllerActivity) {
        this.f2772a = deviceControllerActivity;
    }

    public void onClick(View view) {
        if (!this.f2772a.f2537s) {
            this.f2772a.m5028w();
        } else if (!TextUtils.isEmpty(this.f2772a.f2536r.m5269e())) {
            view.performHapticFeedback(1, 2);
            this.f2772a.m5022c(this.f2772a.f2536r.m5269e());
        }
    }
}
