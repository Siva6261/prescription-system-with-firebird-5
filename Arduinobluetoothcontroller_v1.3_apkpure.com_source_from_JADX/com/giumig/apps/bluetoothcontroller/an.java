package com.giumig.apps.bluetoothcontroller;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

class an extends BroadcastReceiver {
    final /* synthetic */ MainActivity f2651a;

    an(MainActivity mainActivity) {
        this.f2651a = mainActivity;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.d("MainActivity", "bluetoothBondStateChangedBroadcastReceiver action: " + action);
        if ("android.bluetooth.device.action.BOND_STATE_CHANGED".equals(action)) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", Integer.MIN_VALUE);
            int intExtra2 = intent.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", Integer.MIN_VALUE);
            if (intExtra == 12 && intExtra2 == 11) {
                Log.d("MainActivity", "Paired");
                this.f2651a.f2586z.dismiss();
                if (!this.f2651a.f2574n.contains(bluetoothDevice)) {
                    this.f2651a.f2574n.add(bluetoothDevice);
                }
                this.f2651a.f2581u.getAdapter().m4492c();
                this.f2651a.m5133w();
                this.f2651a.f2575o.remove(bluetoothDevice);
                this.f2651a.f2584x.getAdapter().m4492c();
                this.f2651a.m5095b(bluetoothDevice);
            } else if (intExtra == 10 && intExtra2 == 12) {
                Log.d("MainActivity", "Unpaired");
                this.f2651a.f2574n.remove(bluetoothDevice);
                this.f2651a.f2581u.getAdapter().m4492c();
                if (this.f2651a.f2574n.size() > 0) {
                    this.f2651a.m5133w();
                } else {
                    this.f2651a.m5134x();
                }
                this.f2651a.m5129s();
            } else if (intExtra == 10 && intExtra2 == 11) {
                Log.d("MainActivity", "Pairing canceled");
                this.f2651a.f2586z.dismiss();
            }
        }
    }
}
