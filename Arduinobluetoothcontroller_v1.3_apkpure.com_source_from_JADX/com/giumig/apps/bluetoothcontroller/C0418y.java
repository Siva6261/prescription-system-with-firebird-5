package com.giumig.apps.bluetoothcontroller;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class C0418y implements OnClickListener {
    final /* synthetic */ DeviceControllerActivity f2776a;

    C0418y(DeviceControllerActivity deviceControllerActivity) {
        this.f2776a = deviceControllerActivity;
    }

    public void onClick(View view) {
        if (!this.f2776a.f2537s) {
            this.f2776a.m5028w();
        } else if (!TextUtils.isEmpty(this.f2776a.f2536r.m5279j())) {
            view.performHapticFeedback(1, 2);
            this.f2776a.m5022c(this.f2776a.f2536r.m5279j());
        }
    }
}
