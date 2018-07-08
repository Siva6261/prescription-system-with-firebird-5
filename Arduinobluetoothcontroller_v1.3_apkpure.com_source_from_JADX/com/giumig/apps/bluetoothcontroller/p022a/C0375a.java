package com.giumig.apps.bluetoothcontroller.p022a;

import android.bluetooth.BluetoothDevice;
import android.support.v7.widget.dx;
import android.support.v7.widget.ey;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.giumig.apps.bluetoothcontroller.C0403j;
import com.giumig.apps.bluetoothcontroller.MyApplication;
import com.giumig.apps.bluetoothcontroller.bl;
import com.giumig.apps.bluetoothcontroller.p023c.C0382a;
import com.giumig.apps.bluetoothserialmonitor.R;
import java.util.ArrayList;

public class C0375a extends dx {
    private ArrayList f2619a;
    private C0382a f2620b;

    public C0375a(ArrayList arrayList) {
        this.f2619a = arrayList;
    }

    public int mo826a() {
        return this.f2619a.size();
    }

    public /* synthetic */ ey mo827a(ViewGroup viewGroup, int i) {
        return m5174c(viewGroup, i);
    }

    public void m5172a(C0377c c0377c, int i) {
        BluetoothDevice bluetoothDevice = (BluetoothDevice) this.f2619a.get(i);
        c0377c.f2624m.setText(bluetoothDevice.getName());
        c0377c.f2625n.setText(bluetoothDevice.getAddress());
        if (C0403j.m5337a(bluetoothDevice.getBluetoothClass())) {
            c0377c.f2626o.setImageDrawable(MyApplication.m5137a().getResources().getDrawable(R.drawable.ic_phone_android_black_24dp));
        } else if (C0403j.m5338b(bluetoothDevice.getBluetoothClass())) {
            c0377c.f2626o.setImageDrawable(MyApplication.m5137a().getResources().getDrawable(R.drawable.ic_laptop_black_24dp));
        }
        c0377c.f2623l.setOnClickListener(new C0376b(this, bluetoothDevice));
    }

    public void m5173a(C0382a c0382a) {
        this.f2620b = c0382a;
    }

    public C0377c m5174c(ViewGroup viewGroup, int i) {
        C0377c c0377c = new C0377c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_available_device, viewGroup, false));
        c0377c.f2626o.setColorFilter(MyApplication.m5137a().getResources().getColor(R.color.arduinoOrange1));
        bl.m5214a(c0377c.f2624m, "Roboto-Light.ttf");
        bl.m5214a(c0377c.f2625n, "Roboto-Thin.ttf");
        return c0377c;
    }
}
