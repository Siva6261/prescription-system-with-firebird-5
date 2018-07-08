package com.giumig.apps.bluetoothcontroller;

import android.bluetooth.BluetoothDevice;
import com.giumig.apps.bluetoothcontroller.p023c.C0382a;
import com.giumig.apps.bluetoothserialmonitor.R;

class ao implements C0382a {
    final /* synthetic */ MainActivity f2652a;

    ao(MainActivity mainActivity) {
        this.f2652a = mainActivity;
    }

    public void mo829a(BluetoothDevice bluetoothDevice) {
        this.f2652a.m5091a(bluetoothDevice);
        this.f2652a.f2586z.setMessage(this.f2652a.getString(R.string.pairing) + " " + bluetoothDevice.getName());
        this.f2652a.f2586z.show();
    }
}
