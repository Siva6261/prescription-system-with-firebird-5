package com.giumig.apps.bluetoothcontroller;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.giumig.apps.bluetoothserialmonitor.R;

class am extends BroadcastReceiver {
    final /* synthetic */ MainActivity f2650a;

    am(MainActivity mainActivity) {
        this.f2650a = mainActivity;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.bluetooth.device.action.FOUND".equals(action)) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            Log.d("MainActivity", this.f2650a.getString(R.string.available_device_found) + ": " + bluetoothDevice.getName() + ", " + bluetoothDevice.getAddress());
            if (!this.f2650a.f2575o.contains(bluetoothDevice) && !this.f2650a.f2574n.contains(bluetoothDevice)) {
                this.f2650a.f2575o.add(bluetoothDevice);
                this.f2650a.f2584x.getAdapter().m4493c(this.f2650a.f2575o.size());
            }
        } else if ("android.bluetooth.adapter.action.DISCOVERY_STARTED".equals(action)) {
            Log.d("MainActivity", "bluetooth discovery started");
            this.f2650a.m5131u();
        } else if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
            Log.d("MainActivity", "bluetooth discovery finished");
            this.f2650a.m5132v();
        }
    }
}
