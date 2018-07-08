package com.giumig.apps.bluetoothcontroller;

import android.bluetooth.BluetoothDevice;
import com.giumig.apps.bluetoothcontroller.p023c.C0383c;

class ap implements C0383c {
    final /* synthetic */ MainActivity f2653a;

    ap(MainActivity mainActivity) {
        this.f2653a = mainActivity;
    }

    public void mo830a(BluetoothDevice bluetoothDevice) {
        this.f2653a.m5095b(bluetoothDevice);
    }
}
