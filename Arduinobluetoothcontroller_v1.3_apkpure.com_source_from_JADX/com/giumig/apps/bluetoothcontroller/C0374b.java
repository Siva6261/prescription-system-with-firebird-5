package com.giumig.apps.bluetoothcontroller;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

public class C0374b extends C0373a {
    protected BluetoothAdapter f2515m;
    protected BluetoothDevice f2516n;
    private C0399f f2517o;
    private C0397d f2518p;
    private final BroadcastReceiver f2519q = new C0386c(this);

    private void m5006a(BluetoothSocket bluetoothSocket) {
        Log.d("BaseDeviceActivity", "manageConnectedSocket");
        this.f2518p = new C0397d(this, bluetoothSocket);
        this.f2518p.start();
    }

    protected void mo818a(String str) {
    }

    protected void m5009a(byte[] bArr) {
        if (this.f2518p != null) {
            this.f2518p.m5335a(bArr);
        }
    }

    protected void mo819n() {
    }

    protected void mo820o() {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2515m = BluetoothAdapter.getDefaultAdapter();
        this.f2516n = bundle == null ? MyApplication.m5137a().m5139b() : (BluetoothDevice) bundle.getParcelable("SERIALIZED_DEVICE");
        m3225g().mo528a(this.f2516n.getName());
        this.f2517o = new C0399f(this, this.f2516n);
        this.f2517o.start();
    }

    protected void onDestroy() {
        if (this.f2518p != null) {
            this.f2518p.m5334a();
        }
        if (this.f2517o != null) {
            this.f2517o.m5336a();
        }
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
        unregisterReceiver(this.f2519q);
    }

    protected void onResume() {
        super.onResume();
        registerReceiver(this.f2519q, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        registerReceiver(this.f2519q, new IntentFilter("android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED"));
        registerReceiver(this.f2519q, new IntentFilter("android.bluetooth.device.action.ACL_DISCONNECTED"));
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("SERIALIZED_DEVICE", this.f2516n);
        super.onSaveInstanceState(bundle);
    }

    protected void mo821p() {
    }

    protected void mo822q() {
    }

    protected void mo823r() {
    }
}
