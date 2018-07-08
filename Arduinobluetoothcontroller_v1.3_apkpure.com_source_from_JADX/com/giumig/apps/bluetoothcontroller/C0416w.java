package com.giumig.apps.bluetoothcontroller;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class C0416w implements OnClickListener {
    final /* synthetic */ DeviceControllerActivity f2774a;

    C0416w(DeviceControllerActivity deviceControllerActivity) {
        this.f2774a = deviceControllerActivity;
    }

    public void onClick(View view) {
        if (!this.f2774a.f2537s) {
            this.f2774a.m5028w();
        } else if (!TextUtils.isEmpty(this.f2774a.f2536r.m5275h())) {
            view.performHapticFeedback(1, 2);
            this.f2774a.m5022c(this.f2774a.f2536r.m5275h());
        }
    }
}
