package com.giumig.apps.bluetoothcontroller.p022a;

import android.bluetooth.BluetoothDevice;
import android.view.View;
import android.view.View.OnClickListener;

class C0379e implements OnClickListener {
    final /* synthetic */ BluetoothDevice f2630a;
    final /* synthetic */ C0378d f2631b;

    C0379e(C0378d c0378d, BluetoothDevice bluetoothDevice) {
        this.f2631b = c0378d;
        this.f2630a = bluetoothDevice;
    }

    public void onClick(View view) {
        if (this.f2631b.f2628b != null) {
            this.f2631b.f2628b.mo830a(this.f2630a);
        }
    }
}
