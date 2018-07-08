package com.giumig.apps.bluetoothcontroller;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class C0415v implements OnClickListener {
    final /* synthetic */ DeviceControllerActivity f2773a;

    C0415v(DeviceControllerActivity deviceControllerActivity) {
        this.f2773a = deviceControllerActivity;
    }

    public void onClick(View view) {
        if (!this.f2773a.f2537s) {
            this.f2773a.m5028w();
        } else if (!TextUtils.isEmpty(this.f2773a.f2536r.m5267d())) {
            view.performHapticFeedback(1, 2);
            this.f2773a.m5022c(this.f2773a.f2536r.m5267d());
        }
    }
}
