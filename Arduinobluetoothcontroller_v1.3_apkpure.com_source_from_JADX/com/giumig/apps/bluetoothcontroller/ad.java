package com.giumig.apps.bluetoothcontroller;

import android.view.View;
import android.view.View.OnClickListener;

class ad implements OnClickListener {
    final /* synthetic */ DeviceSwitchActivity f2641a;

    ad(DeviceSwitchActivity deviceSwitchActivity) {
        this.f2641a = deviceSwitchActivity;
    }

    public void onClick(View view) {
        if (this.f2641a.f2552s) {
            this.f2641a.m5058c(this.f2641a.f2553t ? this.f2641a.f2551r.m5323c() : this.f2641a.f2551r.m5321b());
            this.f2641a.f2553t = !this.f2641a.f2553t;
            view.performHapticFeedback(1, 2);
            this.f2641a.m5067x();
            return;
        }
        this.f2641a.m5066w();
    }
}
