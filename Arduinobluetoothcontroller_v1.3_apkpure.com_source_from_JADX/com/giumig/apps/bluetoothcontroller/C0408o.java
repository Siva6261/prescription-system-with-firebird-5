package com.giumig.apps.bluetoothcontroller;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class C0408o implements OnClickListener {
    final /* synthetic */ DeviceControllerActivity f2766a;

    C0408o(DeviceControllerActivity deviceControllerActivity) {
        this.f2766a = deviceControllerActivity;
    }

    public void onClick(View view) {
        if (!this.f2766a.f2537s) {
            this.f2766a.m5028w();
        } else if (!TextUtils.isEmpty(this.f2766a.f2536r.m5281k())) {
            view.performHapticFeedback(1, 2);
            this.f2766a.m5022c(this.f2766a.f2536r.m5281k());
        }
    }
}
