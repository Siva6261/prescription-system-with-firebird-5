package com.giumig.apps.bluetoothcontroller;

import android.bluetooth.BluetoothSocket;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

class C0397d extends Thread {
    final /* synthetic */ C0374b f2750a;
    private final BluetoothSocket f2751b;
    private final InputStream f2752c;
    private final OutputStream f2753d;

    public C0397d(C0374b c0374b, BluetoothSocket bluetoothSocket) {
        InputStream inputStream;
        IOException e;
        OutputStream outputStream = null;
        this.f2750a = c0374b;
        this.f2751b = bluetoothSocket;
        try {
            inputStream = bluetoothSocket.getInputStream();
            try {
                outputStream = bluetoothSocket.getOutputStream();
            } catch (IOException e2) {
                e = e2;
                Log.w("BaseDeviceActivity", e.toString());
                this.f2752c = inputStream;
                this.f2753d = outputStream;
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = outputStream;
            Log.w("BaseDeviceActivity", e.toString());
            this.f2752c = inputStream;
            this.f2753d = outputStream;
        }
        this.f2752c = inputStream;
        this.f2753d = outputStream;
    }

    public void m5334a() {
        try {
            this.f2752c.close();
            this.f2753d.close();
            this.f2751b.close();
        } catch (IOException e) {
            Log.w("BaseDeviceActivity", "ConnectedThread.cancel() - " + e);
        }
    }

    public synchronized void m5335a(byte[] bArr) {
        try {
            this.f2753d.write(bArr);
        } catch (IOException e) {
            Log.w("BaseDeviceActivity", "write failed");
            Log.w("BaseDeviceActivity", e.toString());
        }
    }

    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f2752c));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    Log.d("BaseDeviceActivity", readLine);
                    this.f2750a.runOnUiThread(new C0398e(this, readLine));
                }
            }
        } catch (Exception e) {
        }
    }
}
