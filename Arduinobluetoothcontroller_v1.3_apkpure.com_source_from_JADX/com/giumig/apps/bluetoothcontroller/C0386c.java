package com.giumig.apps.bluetoothcontroller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class C0386c extends BroadcastReceiver {
    final /* synthetic */ C0374b f2701a;

    C0386c(C0374b c0374b) {
        this.f2701a = c0374b;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
            if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1) == 10) {
                this.f2701a.mo819n();
            }
        } else if ("android.bluetooth.device.action.ACL_DISCONNECTED".equals(action) || "android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED".equals(action)) {
            this.f2701a.mo820o();
        }
    }
}
