package com.giumig.apps.bluetoothcontroller;

import android.app.Application;
import android.bluetooth.BluetoothDevice;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.giumig.apps.bluetoothcontroller.p025d.C0395b;
import com.giumig.apps.bluetoothserialmonitor.R;
import io.realm.C0483m;
import io.realm.C0490u;
import io.realm.C0492w;

public class MyApplication extends Application {
    private static MyApplication f2587a;
    private static String f2588b;
    private BluetoothDevice f2589c;
    private C0490u f2590d;

    public static MyApplication m5137a() {
        return f2587a;
    }

    public void m5138a(BluetoothDevice bluetoothDevice) {
        Log.d(f2588b, "stored device to connect to: " + bluetoothDevice.getName() + ", " + bluetoothDevice.getAddress());
        this.f2589c = bluetoothDevice;
    }

    public BluetoothDevice m5139b() {
        BluetoothDevice bluetoothDevice = this.f2589c;
        this.f2589c = null;
        Log.d(f2588b, "fetching device to connect to: " + bluetoothDevice.getName() + ", " + bluetoothDevice.getAddress());
        return bluetoothDevice;
    }

    public boolean m5140c() {
        return getSharedPreferences("TUTORIAL_PREFERENCE", 0).getBoolean("TUTORIAL_SKIPPED", false);
    }

    public void m5141d() {
        Editor edit = getSharedPreferences("TUTORIAL_PREFERENCE", 0).edit();
        edit.putBoolean("TUTORIAL_SKIPPED", true);
        edit.commit();
    }

    public boolean m5142e() {
        return getResources().getBoolean(R.bool.isTablet);
    }

    public void onCreate() {
        super.onCreate();
        f2587a = this;
        f2588b = getClass().getSimpleName();
        this.f2590d = new C0492w(this).m5849a(new C0395b()).m5848a();
        C0483m.m5788b(this.f2590d);
    }
}
