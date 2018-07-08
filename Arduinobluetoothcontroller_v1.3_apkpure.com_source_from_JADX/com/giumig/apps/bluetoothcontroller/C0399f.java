package com.giumig.apps.bluetoothcontroller;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.util.Log;
import java.io.IOException;
import java.util.UUID;

class C0399f extends Thread {
    final /* synthetic */ C0374b f2756a;
    private final BluetoothSocket f2757b;

    public C0399f(C0374b c0374b, BluetoothDevice bluetoothDevice) {
        BluetoothSocket createRfcommSocketToServiceRecord;
        IOException e;
        this.f2756a = c0374b;
        try {
            createRfcommSocketToServiceRecord = bluetoothDevice.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));
            try {
                Log.d("BaseDeviceActivity", "RFCOMM bluetooth socket successfully created");
            } catch (IOException e2) {
                e = e2;
                Log.w("BaseDeviceActivity", "RFCOMM bluetooth socket was not created");
                Log.w("BaseDeviceActivity", e.toString());
                c0374b.runOnUiThread(new C0400g(this, c0374b));
                this.f2757b = createRfcommSocketToServiceRecord;
            }
        } catch (IOException e3) {
            IOException iOException = e3;
            createRfcommSocketToServiceRecord = null;
            e = iOException;
            Log.w("BaseDeviceActivity", "RFCOMM bluetooth socket was not created");
            Log.w("BaseDeviceActivity", e.toString());
            c0374b.runOnUiThread(new C0400g(this, c0374b));
            this.f2757b = createRfcommSocketToServiceRecord;
        }
        this.f2757b = createRfcommSocketToServiceRecord;
    }

    public void m5336a() {
        try {
            this.f2757b.close();
        } catch (IOException e) {
            Log.w("BaseDeviceActivity", "ConnectionThread.cancel() - " + e);
        }
    }

    public void run() {
        this.f2756a.f2515m.cancelDiscovery();
        try {
            this.f2757b.connect();
            Log.d("BaseDeviceActivity", "RFCOMM bluetooth socket successfully connected");
            this.f2756a.runOnUiThread(new C0402i(this));
            this.f2756a.m5006a(this.f2757b);
        } catch (IOException e) {
            Log.w("BaseDeviceActivity", "RFCOMM bluetooth socket failed to connect");
            try {
                this.f2757b.close();
            } catch (IOException e2) {
                Log.w("BaseDeviceActivity", "RFCOMM bluetooth socket failed to connect");
                Log.w("BaseDeviceActivity", e2.toString());
            }
            this.f2756a.runOnUiThread(new C0401h(this));
        }
    }
}
