package com.giumig.apps.bluetoothcontroller;

import android.bluetooth.BluetoothDevice;
import com.giumig.apps.bluetoothcontroller.p023c.C0384b;

class aq implements C0384b {
    final /* synthetic */ MainActivity f2654a;

    aq(MainActivity mainActivity) {
        this.f2654a = mainActivity;
    }

    public void mo831a(BluetoothDevice bluetoothDevice) {
        this.f2654a.m5098c(bluetoothDevice);
    }
}
