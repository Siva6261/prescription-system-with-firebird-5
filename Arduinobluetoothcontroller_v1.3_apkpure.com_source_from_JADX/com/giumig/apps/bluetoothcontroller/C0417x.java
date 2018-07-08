package com.giumig.apps.bluetoothcontroller;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class C0417x implements OnClickListener {
    final /* synthetic */ DeviceControllerActivity f2775a;

    C0417x(DeviceControllerActivity deviceControllerActivity) {
        this.f2775a = deviceControllerActivity;
    }

    public void onClick(View view) {
        if (!this.f2775a.f2537s) {
            this.f2775a.m5028w();
        } else if (!TextUtils.isEmpty(this.f2775a.f2536r.m5277i())) {
            view.performHapticFeedback(1, 2);
            this.f2775a.m5022c(this.f2775a.f2536r.m5277i());
        }
    }
}
