package com.giumig.apps.bluetoothcontroller;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class C0413t implements OnClickListener {
    final /* synthetic */ DeviceControllerActivity f2771a;

    C0413t(DeviceControllerActivity deviceControllerActivity) {
        this.f2771a = deviceControllerActivity;
    }

    public void onClick(View view) {
        if (!this.f2771a.f2537s) {
            this.f2771a.m5028w();
        } else if (!TextUtils.isEmpty(this.f2771a.f2536r.m5265c())) {
            view.performHapticFeedback(1, 2);
            this.f2771a.m5022c(this.f2771a.f2536r.m5265c());
        }
    }
}
