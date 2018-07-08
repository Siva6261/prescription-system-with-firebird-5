package com.giumig.apps.bluetoothcontroller;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class C0412s implements OnClickListener {
    final /* synthetic */ DeviceControllerActivity f2770a;

    C0412s(DeviceControllerActivity deviceControllerActivity) {
        this.f2770a = deviceControllerActivity;
    }

    public void onClick(View view) {
        if (!this.f2770a.f2537s) {
            this.f2770a.m5028w();
        } else if (!TextUtils.isEmpty(this.f2770a.f2536r.m5262b())) {
            view.performHapticFeedback(1, 2);
            this.f2770a.m5022c(this.f2770a.f2536r.m5262b());
        }
    }
}
