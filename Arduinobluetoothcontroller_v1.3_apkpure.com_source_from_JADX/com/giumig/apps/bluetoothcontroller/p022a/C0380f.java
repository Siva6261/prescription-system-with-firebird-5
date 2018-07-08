package com.giumig.apps.bluetoothcontroller.p022a;

import android.bluetooth.BluetoothDevice;
import android.view.View;
import android.view.View.OnLongClickListener;

class C0380f implements OnLongClickListener {
    final /* synthetic */ BluetoothDevice f2632a;
    final /* synthetic */ C0378d f2633b;

    C0380f(C0378d c0378d, BluetoothDevice bluetoothDevice) {
        this.f2633b = c0378d;
        this.f2632a = bluetoothDevice;
    }

    public boolean onLongClick(View view) {
        if (this.f2633b.f2629c != null) {
            this.f2633b.f2629c.mo831a(this.f2632a);
        }
        return true;
    }
}
