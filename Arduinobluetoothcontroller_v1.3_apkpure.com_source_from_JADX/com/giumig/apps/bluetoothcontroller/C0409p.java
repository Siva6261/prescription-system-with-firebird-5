package com.giumig.apps.bluetoothcontroller;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class C0409p implements OnClickListener {
    final /* synthetic */ DeviceControllerActivity f2767a;

    C0409p(DeviceControllerActivity deviceControllerActivity) {
        this.f2767a = deviceControllerActivity;
    }

    public void onClick(View view) {
        if (!this.f2767a.f2537s) {
            this.f2767a.m5028w();
        } else if (!TextUtils.isEmpty(this.f2767a.f2536r.m5271f())) {
            view.performHapticFeedback(1, 2);
            this.f2767a.m5022c(this.f2767a.f2536r.m5271f());
        }
    }
}
