package com.giumig.apps.bluetoothcontroller.p022a;

import android.bluetooth.BluetoothDevice;
import android.view.View;
import android.view.View.OnClickListener;

class C0376b implements OnClickListener {
    final /* synthetic */ BluetoothDevice f2621a;
    final /* synthetic */ C0375a f2622b;

    C0376b(C0375a c0375a, BluetoothDevice bluetoothDevice) {
        this.f2622b = c0375a;
        this.f2621a = bluetoothDevice;
    }

    public void onClick(View view) {
        if (this.f2622b.f2620b != null) {
            this.f2622b.f2620b.mo829a(this.f2621a);
        }
    }
}
