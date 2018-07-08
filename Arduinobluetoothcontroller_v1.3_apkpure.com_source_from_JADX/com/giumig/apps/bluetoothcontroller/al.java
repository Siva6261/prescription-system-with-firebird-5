package com.giumig.apps.bluetoothcontroller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

class al extends BroadcastReceiver {
    final /* synthetic */ MainActivity f2649a;

    al(MainActivity mainActivity) {
        this.f2649a = mainActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if (!"android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
            return;
        }
        if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1) == 10) {
            Log.d("MainActivity", "bluetooth state OFF");
            this.f2649a.f2573m.cancelDiscovery();
            this.f2649a.m5132v();
        } else if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1) == 12) {
            Log.d("MainActivity", "bluetooth state ON");
            this.f2649a.m5130t();
            this.f2649a.m5129s();
        } else {
            Log.d("MainActivity", "bluetooth state CHANGED");
        }
    }
}
